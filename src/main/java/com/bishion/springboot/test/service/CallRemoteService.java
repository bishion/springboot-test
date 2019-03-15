package com.bishion.springboot.test.service;

import com.bishion.springboot.test.remote.BaiduService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author Bishion
 * @date 19-3-15 下午8:24
 * @description
 */
@Service
public class CallRemoteService {
    @Value("${config.username}")
    private String username;

    @Autowired
    private BaiduService baiduService;

    public String callBadu() {
        String badu = baiduService.request();

        return username + ":" + badu.substring(2, 4);
    }
}
