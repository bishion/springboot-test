package com.bishion.springboot.test.service;

import com.bishion.springboot.test.remote.BaiduService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

@RunWith(SpringRunner.class)
@Import(CallRemoteService.class)
public class CallRemoteServiceTest {

    @MockBean
    private BaiduService baiduService;

    @Autowired
    private CallRemoteService callRemoteService;

    @Test
    public void callBaidu() {
        BDDMockito.given(this.baiduService.request()).willReturn("SUCCESS");
        String result = callRemoteService.callBaidu();
        Assert.hasLength(result,"返回数据不应该为空");
        Assert.isTrue(result.length() == 2,"返回数据长度应为2");

    }
}