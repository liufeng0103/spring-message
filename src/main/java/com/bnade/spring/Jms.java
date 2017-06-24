package com.bnade.spring;



import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;

import javax.jms.*;

/**
 * 使用传统的JMS（不适用spring）发送消息
 * Created by liufeng0103@163.com on 2017/6/24.
 */
public class Jms {

    /**
     * 发送message到ActiveMQ
     * @param message 文本消息
     */
    public void send(String message) {
        ConnectionFactory cf = new ActiveMQConnectionFactory("tcp://localhost:61616");
        Connection conn = null;
        Session session = null;
        try {
            conn = cf.createConnection();
            session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
            Destination destination = new ActiveMQQueue("bnade.queue");
            MessageProducer producer = session.createProducer(destination);
            TextMessage textMessage = session.createTextMessage();
            textMessage.setText(message);
            producer.send(textMessage);
        } catch (JMSException e) {
            e.printStackTrace();
        } finally {
            try {
                if (session != null) {
                    session.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 从ActiveMQ获取消息
     * 这种是同步方式，当没有消息时线程会被阻塞直到有新的消息到来
     */
    public void receive() {
        ConnectionFactory cf = new ActiveMQConnectionFactory("tcp://localhost:61616");
        Connection conn = null;
        Session session = null;
        try {
            conn = cf.createConnection();
            conn.start();
            session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
            Destination destination = new ActiveMQQueue("bnade.queue");
            MessageConsumer consumer = session.createConsumer(destination);
            Message message = consumer.receive();
            TextMessage textMessage = (TextMessage) message;
            System.out.println("Got a message: " + textMessage.getText());
            conn.start();
        } catch (JMSException e) {
            e.printStackTrace();
        } finally {
            try {
                if (session != null) {
                    session.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }
    }

}
