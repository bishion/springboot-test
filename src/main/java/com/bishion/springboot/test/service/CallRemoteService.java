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
    @Autowired
    private BaiduService baiduService;

    public String callBaidu() {
        String baidu = baiduService.request();

        return baidu.substring(2, 4);
    }
}
