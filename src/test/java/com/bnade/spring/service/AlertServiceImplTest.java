package com.bnade.spring.service;

import com.bnade.spring.BnadeMessage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by liufeng0103@163.com on 2017/6/24.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class AlertServiceImplTest {

    @Autowired
    private AlertService alertService;

    @Test
    public void sendBnadeAlertTest() throws Exception {
        BnadeMessage message = new BnadeMessage(1, "lf");
        System.out.println("发送消息 " + message);
        alertService.sendBnadeAlert(message);
    }

    @Test
    public void retriveMessageAlert() throws Exception {
        sendBnadeAlertTest();
        BnadeMessage message = alertService.retriveMessageAlert();
        System.out.println(message);
    }
}