package com.bishion.springboot.test.controller;

import com.bishion.springboot.test.dto.UserDTO;
import com.bishion.springboot.test.model.User;
import com.bishion.springboot.test.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
@TestPropertySource(properties = "config.username=test")
public class UserControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private UserService userService;

    @Test
    public void query() throws Exception {
        List<User> userList = new ArrayList<>(1);
        User user = new User();
        user.setUsername("bishion");
        userList.add(user);
        BDDMockito.given(userService.queryUser(null)).willReturn(Collections.emptyList());
        BDDMockito.given(userService.queryUser(BDDMockito.startsWith("bi"))).willReturn(userList);
        BDDMockito.given(userService.queryUser(BDDMockito.startsWith("test"))).willReturn(userList);

        this.mvc.perform(MockMvcRequestBuilders.get("/query")
                .param("username", "bishion"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()", "").value(1));

        this.mvc.perform(MockMvcRequestBuilders.get("/query")
                .param("username", "guo"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()", "").value(0));

        this.mvc.perform(MockMvcRequestBuilders.get("/query"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()", "").value(1));
    }

    @Test
    public void addUser() throws Exception {
        UserDTO userDTO = new UserDTO();
        userDTO.setUsername("bishion");
        BDDMockito.given(this.userService.addUser(userDTO)).willReturn("SUCCESS");
        BDDMockito.given(this.userService.addUser(new UserDTO())).willReturn("FAILURE");
        this.mvc.perform(MockMvcRequestBuilders.get("/addUser")
                .param("username","bishion")
                .accept(MediaType.TEXT_PLAIN))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("SUCCESS"));
    }
}