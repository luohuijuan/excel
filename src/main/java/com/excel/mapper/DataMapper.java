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

    public List<Map> queryChainList();

    public List<Map> queryChainList(@Param("pageIndex") int pageIndex, @Param("pageSize") int pageSize);

}
