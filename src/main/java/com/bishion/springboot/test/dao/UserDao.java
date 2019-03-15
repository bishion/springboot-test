package com.bishion.springboot.test.dao;

import com.bishion.springboot.test.model.User;
import org.apache.ibatis.annotations.Insert;

public interface UserDao {

    @Insert("insert into User values(null,#{username},#{age})")
    Integer addUser(User user);

}
