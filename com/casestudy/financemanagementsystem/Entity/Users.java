package com.casestudy.financemanagementsystem.Entity;

public class Users {
    private int user_id;
    private String username;
    private String password;
    private String email;
    private static int userCount = 0;

    public Users(){

    }

    public Users(String username, String password, String email) {
        this.user_id = userCount++;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
