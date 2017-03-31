package com.yushan.rxjava.model;

/**
 * Created by yushan on 2016/7/21.
 */
public class LoginRequest {
    private String authName = "";
    private String authPassword = "";
    private String username = "";
    private String password = "";
    private String phonemodel = "";
    private String phonebrand = "";

    public LoginRequest() {
    }

    public String getAuthName() {
        return authName;
    }

    public void setAuthName(String authName) {
        this.authName = authName;
    }

    public String getAuthPassword() {
        return authPassword;
    }

    public void setAuthPassword(String authPassword) {
        this.authPassword = authPassword;
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

    public String getPhonemodel() {
        return phonemodel;
    }

    public void setPhonemodel(String phonemodel) {
        this.phonemodel = phonemodel;
    }

    public String getPhonebrand() {
        return phonebrand;
    }

    public void setPhonebrand(String phonebrand) {
        this.phonebrand = phonebrand;
    }
}
