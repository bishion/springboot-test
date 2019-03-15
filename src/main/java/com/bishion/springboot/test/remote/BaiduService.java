package com.bishion.springboot.test.remote;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Bishion
 * @date 19-3-15 下午8:21
 * @description
 */
@FeignClient(name = "remote-service",url = "https://www.baidu.com")
public interface BaiduService {
    @RequestMapping("/")
    String request();
}
