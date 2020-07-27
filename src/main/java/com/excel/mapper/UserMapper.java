package com.excel.mapper;

import com.excel.domain.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserMapper {

    public List<Map> queryUserList();

}
