package com.bnade.spring.service;

import com.bnade.spring.BnadeMessage;
import com.bnade.spring.rabbit.RabbitAlertServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by liufeng0103@163.com on 2017/6/25.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-rabbit.xml")
public class RabbitAlertServiceImplTest {

    @Autowired
    private RabbitAlertServiceImpl alertService;

    @Test
    public void sendBnadeAlert() throws Exception {
        BnadeMessage message = new BnadeMessage(2, "hello rabbit");
        System.out.println("发送消息 " + message);
        alertService.sendBnadeAlert(message);
    }

    @Test
    public void retriveMessageAlert() throws Exception {
        System.out.println("收到消息 " + alertService.retriveMessageAlert());
    }

}