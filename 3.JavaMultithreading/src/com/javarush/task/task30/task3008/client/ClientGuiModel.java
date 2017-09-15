package com.javarush.task.task30.task3008.client;

import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

public class ClientGuiModel {
    private final Set allUserNames = new TreeSet();
    private String newMessage;

    public String getNewMessage() {
        return newMessage;
    }

    public void setNewMessage(String newMessage) {
        this.newMessage = newMessage;
    }

    public Set getAllUserNames() {
        return Collections.unmodifiableSet(allUserNames);
    }

    public void addUser(String newUserName) {
        allUserNames.add(newUserName);
    }

    public void deleteUser(String userName) {
        if (userName.contains(userName)) {
            allUserNames.remove(userName);
        }
    }
}
