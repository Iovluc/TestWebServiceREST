package com.iovluc.app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Messages {
    HashMap<User, List<Message>> messageSent;

    Messages(){
        messageSent = new HashMap<>();
        init();
    }

    private void init(){

    }

    public void addMessage(User user, Message msg){
        List<Message> msgList = messageSent.get(user);
        if(msgList != null){
            msgList.add(msg);
        }
        else{
            msgList = new ArrayList<>();
            msgList.add(msg);
            messageSent.put(user, msgList);
        }
    }

    public List<Message> getMessageOfUser(User user){
        return messageSent.get(user);
    }

    public HashMap<User, List<Message>> getMessageSent(){
        return messageSent;
    }
}
