package com.iovluc.app;

import java.util.ArrayList;
import java.util.List;

public class Users {
    List<User> users;

    Users(){
        users = new ArrayList<>();
    }

    public void addUser(String userName){
        if(getUserByUsername(userName) == null)
            users.add(new User(userName));
    }

    public User getUserByUsername(String userName){
        for (User user: users) {
            if(user.getName().equals(userName))
                return user;
        }

        return null;
    }
}
