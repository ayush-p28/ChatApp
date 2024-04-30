package com.chat.app.chatap.models;

public class Message {
    private String name;
    private String content;
    private String gender;

    // Parameterized contructor to initialize message
    public Message(String name, String content, String gender){
        this.name = name;
        this.content = content;
        this.gender = gender;
    }

    // creating getter for Gender
    public String getGender() {
        return gender;
    }

    // creating setting for Gender
    public void setGender(String gender) {
        this.gender = gender;
    }

    // creating getter for Name
    public String getName() {
        return name;
    }

    // creating setting for Name
    public void setName(String name) {
        this.name = name;
    }

    // creating getter for Content
    public String getContent() {
        return content;
    }

    // creating setting for content
    public void setContent(String content) {
        this.content = content;
    }
}
