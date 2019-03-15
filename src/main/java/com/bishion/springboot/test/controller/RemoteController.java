package com.bishion.springboot.test.controller;

import com.bishion.springboot.test.service.CallRemoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Bishion
 * @date 19-3-15 下午8:37
 * @description
 */
@RestController
public class RemoteController {
    @Autowired
    private CallRemoteService callRemoteService;
    @RequestMapping("/request")
    public String request(){
        return callRemoteService.callBaidu();
    }
}
