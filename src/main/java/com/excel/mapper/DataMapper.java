package com.excel.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface DataMapper {

    public List<Map> queryDeptList();

    public List<Map<String, Object>> queryChainList();

    public List<Map> queryChainList(@Param("pageIndex") int pageIndex, @Param("pageSize") int pageSize);
    public List<Map<String, Object>> data1(Map<String, String> map);
    public List<Map<String, Object>> data2(Map<String, String> map);
    public List<Map<String, Object>> data3(Map<String, String> map);
    public List<Map<String, Object>> data4(Map<String, String> map);
    public List<Map<String, Object>> data5(Map<String, String> map);
    public List<Map<String, Object>> data6(Map<String, String> map);
    public List<Map<String, Object>> data7(Map<String, String> map);
    public List<Map<String, Object>> data8(Map<String, String> map);
    public List<Map<String, Object>> data9(Map<String, String> map);

}
