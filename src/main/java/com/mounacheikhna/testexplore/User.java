package com.mounacheikhna.testexplore;

public class User {

    private String username;

    public User(String username) {
        this.username = username;
    }

    public String configFileName() {
        return username + "/" + "config";
    }
}
