package com.bishion.springboot.test.service;

import com.bishion.springboot.test.dao.UserDao;
import com.bishion.springboot.test.dto.UserDTO;
import com.bishion.springboot.test.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private CallRemoteService callRemoteService;
    @Value("${config.username:bishion}")
    private String username;
    @Autowired
    private UserDao userDao;
    public String addUser(UserDTO userDTO){
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setAge(userDTO.getAge());
        Integer result = userDao.addUser(user);

        return result == 1?"SUCCESS":"FAILURE";
    }
}
