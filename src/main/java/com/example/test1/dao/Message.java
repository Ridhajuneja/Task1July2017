package com.example.test1.dao;

import javax.persistence.*;

/**
 * Created by ridha on 11/7/17.
 */
@Entity
public class Message {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private  Long id;
    @Column(nullable = false)
    private String sender;
    @Column(nullable = false)
    private String reciever;
    private String message;

    public String getSender() {
        return sender;
    }

    public String getReciever() {
        return reciever;
    }

    public String getMessage() {
        return message;
    }

    public Message(String sender, String user, String message) {
        this.sender = sender;
        this.reciever = user;
        this.message = message;

    }
    public Message()
    {

    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public void setReciever(String user) {
        this.reciever = user;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
