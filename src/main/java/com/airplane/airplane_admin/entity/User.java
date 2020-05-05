package com.airplane.airplane_admin.entity;

public class User {
    private String username;
    private String passWord;

    public User(){}

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getPassWord() {
        return passWord;
    }

    public String getUsername() {
        return username;
    }
}
