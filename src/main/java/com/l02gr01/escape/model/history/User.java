package com.l02gr01.escape.model.history;

public class User {

    private static final User instance = new User();
    private String username;

    public static User getInstance() {
        return instance;
    }

    private User() {
        username = "";
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
