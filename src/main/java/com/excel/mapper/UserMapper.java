package com.excel.mapper;

import com.excel.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import sun.nio.cs.US_ASCII;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserMapper {

    public List<Map> queryUserList();

    public  User findByNamePassword(@Param("username")String username , @Param("password")String password);

}
