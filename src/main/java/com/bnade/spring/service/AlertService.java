package com.bnade.spring.service;

import com.bnade.spring.BnadeMessage;

/**
 * 消息发送服务
 * Created by liufeng0103@163.com on 2017/6/24.
 */
public interface AlertService {
    void sendBnadeAlert(BnadeMessage bnadeMessage);

    BnadeMessage retriveMessageAlert();
}
