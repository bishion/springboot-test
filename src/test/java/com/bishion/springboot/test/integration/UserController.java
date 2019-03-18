package com.bishion.springboot.test.integration;

import com.bishion.springboot.test.dto.UserDTO;
import com.bishion.springboot.test.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.List;

/**
 * @author Bishion
 * @date 19-3-18 下午4:10
 * @description
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)
@TestPropertySource(properties = "config.username=test")
public class UserController {
    @Autowired
    private TestRestTemplate template;

    @Test
    public void testAddUser(){
        UserDTO userDTO = new UserDTO();
        userDTO.setUsername("bishion");
        String result = template.postForEntity("/addUser",userDTO, String.class).getBody();
        Assert.isTrue("SUCCESS".endsWith(result),"返回不成功"+result);
    }
    @Test
    public void testQueryUser(){
        MultiValueMap<String, String> map= new LinkedMultiValueMap<>();
        map.add("username", "bishion");
        List<UserDTO> result = template.postForEntity("/query",map, List.class).getBody();
        Assert.isTrue(result.size()>0,"没有查出数据");

    }
}
