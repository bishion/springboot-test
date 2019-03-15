package com.bishion.springboot.test.service;

import com.bishion.springboot.test.remote.BaiduService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@Import({BaiduService.class, CallRemoteService.class})
public class CallRemoteServiceTest {

    @MockBean
    private BaiduService baiduService;

    @Autowired
    private CallRemoteService callRemoteService;
    @Test
    public void callGitHub() {
        BDDMockito.given(this.baiduService.request()).willReturn("SUCCESS");
        String result = callRemoteService.callBadu();
        System.out.println(result);

    }
}