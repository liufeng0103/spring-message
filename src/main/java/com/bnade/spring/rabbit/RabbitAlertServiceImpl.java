package com.bnade.spring.rabbit;

import com.bnade.spring.BnadeMessage;
import com.bnade.spring.service.AlertService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 使用Sping的rabbit template发送和接受RabbitMQ消息
 * Created by liufeng0103@163.com on 2017/6/25.
 */
@Service
public class RabbitAlertServiceImpl implements AlertService {

    @Autowired
    private RabbitTemplate rabbit;

    @Override
    public void sendBnadeAlert(BnadeMessage bnadeMessage) {
        // exchange和routing-key在spring-rabbit.xml中配置
        rabbit.convertAndSend(bnadeMessage);
    }

    /**
     * 获取MQ中消息
     * 跟JMS不同，如果MQ中没有消息时，不会阻塞线程，而是返回null
     * @return
     */
    @Override
    public BnadeMessage retriveMessageAlert() {
        return (BnadeMessage) rabbit.receiveAndConvert();
    }
}
