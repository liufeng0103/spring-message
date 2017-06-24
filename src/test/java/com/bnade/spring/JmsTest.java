package com.bnade.spring;

import org.junit.Test;

/**
 * Created by liufeng0103@163.com on 2017/6/24.
 */
public class JmsTest {
    @Test
    public void sendTest() throws Exception {
        Jms jms = new Jms();
        jms.send("hello jms");
    }

    @Test
    public void receiveTest() throws Exception {
        Jms jms = new Jms();
        jms.receive();
    }
}