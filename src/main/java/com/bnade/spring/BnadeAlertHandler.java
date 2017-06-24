package com.bnade.spring;

/**
 * 消息驱动的POJO，这种方式异步处理消息
 * Created by liufeng0103@163.com on 2017/6/24.
 */
public class BnadeAlertHandler {

    public void handleBnadeAlert(BnadeMessage message) {
        System.out.println("处理器被调用，接受到消息 " + message);
    }
}
