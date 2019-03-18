package com.bishion.springboot.test.controller;

import com.bishion.springboot.test.dto.UserDTO;
import com.bishion.springboot.test.model.User;
import com.bishion.springboot.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
public class UserController {
    @Value("${config.username:bishion}")
    private String defaultUser;
    @Autowired
    private UserService userService;
    @RequestMapping("/addUser")
    public String addUser(UserDTO userDTO){
        if(StringUtils.isEmpty(userDTO.getUsername())){
            userDTO.setUsername(defaultUser);
        }
        return userService.addUser(userDTO);
    }

    @RequestMapping("/update")
    public String updateUser(UserDTO userDTO){
        if (userDTO.getId() == null){
            return "FAILURE";
        }
        return userService.updateUser(userDTO);
    }

    @RequestMapping("/query")
    public List<UserDTO> query(String username){
        List<User> users =  userService.queryUser(username);
        return transfer(users);

    }
    private List<UserDTO> transfer(List<User> userList){
        if(CollectionUtils.isEmpty(userList)){
            return Collections.emptyList();
        }
        List<UserDTO> userDTOList = new ArrayList<>(userList.size());
        userList.stream().forEach(user->{
            UserDTO userDTO = new UserDTO();
            userDTO.setId(user.getId());
            userDTO.setUsername(user.getUsername());
            userDTO.setAge(user.getAge());
            userDTOList.add(userDTO);
        });
        return userDTOList;
    }
}
