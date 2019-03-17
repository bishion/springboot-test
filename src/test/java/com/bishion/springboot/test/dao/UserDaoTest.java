package com.bishion.springboot.test.dao;

import com.bishion.springboot.test.model.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import java.util.List;

//@RunWith(SpringRunner.class)
//@MybatisTest
//@Rollback(false)
public class UserDaoTest {

    @Autowired
    private UserDao userDao;

    @Test
    public void testUserDao(){
        User user = new User();
        user.setUsername("bizi");
        user.setAge(18);
        userDao.addUser(user);

        List<User> userList = userDao.queryUserByName("bizi");
        Assert.notNull(user.getId(),"未获取到ID");
        Assert.notEmpty(userList,"未查到插入数据");
    }

}