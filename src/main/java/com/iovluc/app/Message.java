package com.iovluc.app;

public class Message {
    Integer id;
    String msg;
    User receiver;

    Message(Integer id, User receiver, String msg){
        this.id = id;
        this.msg = msg;
        this.receiver = receiver;
    }

    public Integer getId(){
        return id;
    }

    public String getMsg() {
        return msg;
    }

    public User getReciver() {
        return receiver;
    }

    public void updateMsg(String msg){
        this.msg = msg;
    }
}
