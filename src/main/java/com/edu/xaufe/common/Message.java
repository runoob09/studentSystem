package com.edu.xaufe.common;

import lombok.Data;

@Data
public class Message {
    private int code;
    private String message;
    private Object data;

    public Message(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
}