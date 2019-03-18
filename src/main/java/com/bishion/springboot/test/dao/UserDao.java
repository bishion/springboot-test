package com.bishion.springboot.test.dao;

import com.bishion.springboot.test.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;
@Mapper
public interface UserDao {

    @Insert("insert into User values(null,#{username},#{age})")
    @Options(useGeneratedKeys=true,keyColumn = "id")
    Integer addUser(User user);

    @Select("select * from User where username = #{username}")
    List<User> queryUserByName(String username);
    // 该方法为 xml 配置
    Integer updateUserById(User user);
}
