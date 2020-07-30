package com.excel.util;

import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.*;
import java.util.Map.Entry;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ExcelUtil {
	public static String downloadPath;
	private static ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();

	private static class DeleteFileRunnable implements Runnable {
		public void run() {
			File rootfile = new File(downloadPath);
			File[] files = rootfile.listFiles();
			for (File file : files) {
				if(System.currentTimeMillis() - file.lastModified() > 5 * 60 * 1000) {
					file.delete();
				}
			}
		}
	}
	static {
		scheduledExecutorService.scheduleWithFixedDelay(new DeleteFileRunnable(), 0, 1, TimeUnit.MINUTES);
	}
	
	public static void main(String[] args) throws Exception {
		Map<String, List<Map<String, Object>>> dataListMap = readExcel("C:\\Users\\Administrator\\Desktop\\纳雍商家入驻.xls");
		dataListMap.forEach((key, value) -> System.err.println(key + ":" + dataListMap.get(key).size()));
		writeExcel(dataListMap, "C:\\Users\\Administrator\\Desktop/测试1.xlsx");
	}
	
	public static Map<String, List<Map<String, Object>>> readExcel(String pathName) throws Exception {
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
	
	public static void writeExcel(Map<String, List<Map<String, Object>>> dataListMap, String fileName) throws IOException {
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
							cell.setCellValue(String.valueOf(entry.getValue()));
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
