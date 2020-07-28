package com.excel.mapper;

import com.excel.domain.Admin;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 获取用户数据权限
 */
@Mapper
public interface InfoMapper {

    public Admin findByNameAndPassword(String username, String password);

}
