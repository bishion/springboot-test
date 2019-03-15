package com.bishion.springboot.test.service;

import com.bishion.springboot.test.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private CallRemoteService callRemoteService;
    public String addUser(UserDTO userDTO){
        return "SUCCESS";
    }
}
