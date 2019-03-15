package com.bishion.springboot.test.service;

import com.bishion.springboot.test.dto.UserDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@Import({UserService.class})
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @MockBean
    private CallRemoteService callRemoteService;
    @Test
    public void addUser() {
        userService.addUser(new UserDTO());
    }
}