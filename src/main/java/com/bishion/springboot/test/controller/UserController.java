package com.bishion.springboot.test.controller;

import com.bishion.springboot.test.dto.UserDTO;
import com.bishion.springboot.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Value("${config.username:bishion}")
    private String username;
    @Autowired
    private UserService userService;
    @RequestMapping("/addUser")
    public String addUser(UserDTO userDTO){
        if(StringUtils.isEmpty(userDTO.getUsername())){
            userDTO.setUsername(username);
        }
        return userService.addUser(userDTO);
    }

}
