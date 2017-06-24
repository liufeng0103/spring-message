package com.bnade.spring.service;

import com.bnade.spring.BnadeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsOperations;
import org.springframework.stereotype.Service;

/**
 * 消息服务
 * Created by liufeng0103@163.com on 2017/6/24.
 */
@Service
public class AlertServiceImpl implements AlertService {

    @Autowired
    private JmsOperations jmsOperations; // 注入JMS模板

    /**
     * 发送消息
     * @param bnadeMessage 对象消息
     */
    @Override
    public void sendBnadeAlert(final BnadeMessage bnadeMessage) {
        jmsOperations.convertAndSend(bnadeMessage);
    }

    /**
     * 接受对象消息
     * 这种是同步方式，如果队列中没有消息将会阻塞线程，直到有新的消息或者超时
     * @return 对象消息
     */
    @Override
    public BnadeMessage retriveMessageAlert() {
        return (BnadeMessage)jmsOperations.receiveAndConvert();
    }
}
