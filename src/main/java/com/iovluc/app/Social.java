package com.iovluc.app;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

public class Social {
    Users users;
    Messages messages;
    Integer id = 0;

    Social(){
        users = new Users();
        messages = new Messages();
        init();
    }
    public Users getUsers() {
        return users;
    }

    public Messages getMessages() {
        return messages;
    }

    public void init(){
        users.addUser("Luca");
        users.addUser("Giovanni");
        users.addUser("Marta");

        addMessage("Luca", "Giovanni", "Prova");
        addMessage("Luca", "Marta", "Prova");
    }


    public String getMessagesByUsername(String username){
        return getRappresentation(users.getUserByUsername(username));
    }

    public String getAllMessages(){
        HashMap<User,List<Message>> map = messages.getMessageSent();
        JSONArray jsonArrayOfAllMsg = new JSONArray();
        JSONObject json = new JSONObject();

        for(Map.Entry<User, List<Message>> e : map.entrySet()){
            jsonArrayOfAllMsg.put(new JSONObject(getRappresentation(e.getKey())));
        }

        json.put("AllMsg", jsonArrayOfAllMsg);
        return json.toString();
    }

    public String getRappresentation(User user){
        JSONObject json = new JSONObject();
        JSONArray jsonMsg = new JSONArray();
        JSONObject jsonMsgData;

        List<Message> msgList = messages.getMessageOfUser(user);

        if(msgList != null) {
            for (Message m : msgList) {
                jsonMsgData = new JSONObject();

                jsonMsgData.put("Id", m.getId());
                jsonMsgData.put("Destinatario", m.getReciver().getName());
                jsonMsgData.put("Messaggio", m.getMsg());
                jsonMsg.put(jsonMsgData);
            }

            json.put("Mittente", user.getName());
            json.put("Messages", jsonMsg);
        }

        return json.toString();
    }

    public void updateMessage(Integer id, String sender, String msg){
        User user = users.getUserByUsername(sender);
        List<Message> msgOfSender = messages.getMessageOfUser(user);
        for(Message m: msgOfSender){
            if(m.getId() == id) {
                m.updateMsg(msg);
                return;
            }
        }
    }

    public void deleteMessage(Integer id, String sender){
        User user = users.getUserByUsername(sender);
        List<Message> msgOfSender = messages.getMessageOfUser(user);

        for(Message m: msgOfSender){
            if(m.getId() == id) {
                msgOfSender.remove(m);
                return;
            }
        }
    }

    public void addMessage(String sender, String receiver, String msg){
        messages.addMessage(users.getUserByUsername(sender),
                new Message(id, users.getUserByUsername(receiver), msg));

        id++;
    }
}
