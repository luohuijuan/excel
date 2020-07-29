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
    public List<Map<String, Object>> data1(@Param("pageIndex") int pageIndex, @Param("pageSize") int pageSize);
    public List<Map<String, Object>> data2();
    public List<Map<String, Object>> data3();
    public List<Map<String, Object>> data4();
    public List<Map<String, Object>> data5();
    public List<Map<String, Object>> data6(Map<String, String> map);
    public List<Map<String, Object>> data7();

    /**
     * 线下门店扫码单个门店订单
     * @param map
     * @return
     */
    public List<Map<String, Object>> data8(Map<String, String> map);

    /**
     * 0-线下扫码多个店铺、门店订单数据
     * @return
     */
    public List<Map<String, Object>> data9(Map<String, String> map);

}
