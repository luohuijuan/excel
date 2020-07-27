package util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtil {

	public static void main(String[] args) throws Exception {
		Map<String, List<Map<String, Object>>> dataListMap = readExcel("C:\\Users\\Administrator\\Desktop\\20200721-20200726-线下门店扫码单个门店订单 - 副本.xlsx");
		dataListMap.forEach((key, value) -> System.err.println(key + ":" + dataListMap.get(key).size()));
		writeExcel(dataListMap, "D:/tmp/测试1.xlsx");
	}
	
	private static Map<String, List<Map<String, Object>>> readExcel(String pathName) throws Exception {
		Map<String, List<Map<String, Object>>> excelMap = new LinkedHashMap<String, List<Map<String,Object>>>();
		File file = new File(pathName);
		DataFormatter formatter = new DataFormatter();
		Workbook workbook = null;
		try {
			workbook = WorkbookFactory.create(file);
			for (Sheet sheet : workbook) {
				List<Map<String, Object>> sheetList = new ArrayList<Map<String,Object>>();
				List<String> keyList = new ArrayList<String>();
				for (Row row : sheet) {
					if(row.getRowNum() == 0) {
						for (Cell cell : row) {
							keyList.add(formatter.formatCellValue(cell));
						}
					} else {
						Map<String, Object> rowMap = new LinkedHashMap<String, Object>();
						for (Cell cell : row) {
							rowMap.put(keyList.get(cell.getColumnIndex()), formatter.formatCellValue(cell));
						}
						sheetList.add(rowMap);
					}
				}
				excelMap.put(sheet.getSheetName(), sheetList);
			}
		} finally {
			if(workbook != null) {
				workbook.close();
			}
		}
		return excelMap;
	}
	
	private static void writeExcel(Map<String, List<Map<String, Object>>> dataListMap, String fileName) throws IOException {
		File excelFile = new File(fileName);
		if(!excelFile.exists()) {
			excelFile.createNewFile();
		}
		try (
				OutputStream outputStream = new FileOutputStream(excelFile);
				Workbook workbook = WorkbookFactory.create(true);
			){
			Set<String> keySet = dataListMap.keySet();
			for (String sheetName : keySet) {
				Sheet sheet = workbook.createSheet(sheetName);
				List<Map<String, Object>> list = dataListMap.get(sheetName);
				for (int index = 0; index < list.size(); index++) {
					Map<String, Object> map = list.get(index);
					Row row = sheet.createRow(index);
					int cellIndex = 0;
					if(index == 0) {
						Set<Entry<String, Object>> entrySet = map.entrySet();
						for (Entry<String, Object> entry : entrySet) {
							Cell cell = row.createCell(cellIndex++);
							cell.setCellValue(entry.getKey());
						}
					} else {
						Set<Entry<String, Object>> entrySet = map.entrySet();
						for (Entry<String, Object> entry : entrySet) {
							Cell cell = row.createCell(cellIndex++);
							cell.setCellValue((String)entry.getValue());
						}
					}
				}
			}
			workbook.write(outputStream);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
