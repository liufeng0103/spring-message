package com.bnade.spring;

import java.io.Serializable;

/**
 * JMS消息对象
 * Created by liufeng0103@163.com on 2017/6/24.
 */
public class BnadeMessage implements Serializable {

    private Integer id;
    private String message;

    public BnadeMessage(Integer id, String message) {
        this.id = id;
        this.message = message;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "BnadeMessage{" +
                "id=" + id +
                ", message='" + message + '\'' +
                '}';
    }
}
