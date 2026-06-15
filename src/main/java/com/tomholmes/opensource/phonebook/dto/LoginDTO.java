package com.tomholmes.opensource.phonebook.dto;

import jakarta.enterprise.context.ApplicationScoped;

import java.io.Serializable;

@SuppressWarnings("serial")
@ApplicationScoped
public class LoginDTO implements Serializable
{
    private String username;
    private String password;

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
}
