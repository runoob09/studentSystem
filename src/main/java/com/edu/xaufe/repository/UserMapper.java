package com.edu.xaufe.repository;

import com.edu.xaufe.enity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {
    @Select("select * from user where username = #{username} and password = #{password}")
    User selectByUsernameAndPassword(@Param("username") String username,@Param("password") String password);
}
