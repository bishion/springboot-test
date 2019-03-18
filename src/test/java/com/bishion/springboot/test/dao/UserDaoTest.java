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

@RunWith(SpringRunner.class)
@MybatisTest
//@Rollback(false)   // 执行完用例回滚
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserDaoTest {

    @Autowired
    private UserDao userDao;

    @Test
    public void testUserDao(){
        // 测试插入数据
        User user = new User();
        user.setUsername("bizi");
        user.setAge(18);
        userDao.addUser(user);

        // 测试更新数据
        User newUser = new User();
        newUser.setId(user.getId());
        newUser.setUsername("bishion");
        userDao.updateUserById(newUser);

        // 测试查询数据
        List<User> userList = userDao.queryUserByName("bishion");
        Assert.notNull(user.getId(),"未获取到ID");
        Assert.notEmpty(userList,"未查到插入数据");
    }

}