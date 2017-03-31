package com.yushan.rxjava.model;

/**
 * Created by yushan on 2016/7/20.
 */
public class LoginResponse {
    private int redirectflag = 0;
    private String accessToken = "";


    public int getRedirectflag() {
        return redirectflag;
    }

    public void setRedirectflag(int redirectflag) {
        this.redirectflag = redirectflag;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }


    @Override
    public String toString() {
        return "LoginResponse{" +
                "redirectflag=" + redirectflag +
                ", accessToken='" + accessToken + '\'' +
                '}';
    }
}
