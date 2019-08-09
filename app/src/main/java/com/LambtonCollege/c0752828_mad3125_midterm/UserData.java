package com.LambtonCollege.c0752828_mad3125_midterm;

public class UserData {
    String email,Password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public UserData(String email, String password) {
        this.email = email;
        Password = password;
    }
}
