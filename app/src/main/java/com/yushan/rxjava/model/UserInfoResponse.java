package com.yushan.rxjava.model;

/**
 * Created by yushan on 2016/8/1.
 */
public class UserInfoResponse {
    private int userid = 0;
    private String username = "";
    private String headpicurl = "";
    private String realname = "";
    private String nickname = "";
    private String mobile = "";
    private int usertype = 0;
    private int regtype = 0;
    private int height = 0;
    private int weight = 0;
    private int stepwidth = 0;
    private int stepgoal = 0;
    private int birthday = 0;
    private String email = "";
    private int gender = 0;
    private String city = "";
    private int pedstatus = 0;
    private String spacecoverUrl = "";


    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getHeadpicurl() {
        return headpicurl;
    }

    public void setHeadpicurl(String headpicurl) {
        this.headpicurl = headpicurl;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public int getUsertype() {
        return usertype;
    }

    public void setUsertype(int usertype) {
        this.usertype = usertype;
    }

    public int getRegtype() {
        return regtype;
    }

    public void setRegtype(int regtype) {
        this.regtype = regtype;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getStepwidth() {
        return stepwidth;
    }

    public void setStepwidth(int stepwidth) {
        this.stepwidth = stepwidth;
    }

    public int getStepgoal() {
        return stepgoal;
    }

    public void setStepgoal(int stepgoal) {
        this.stepgoal = stepgoal;
    }

    public int getBirthday() {
        return birthday;
    }

    public void setBirthday(int birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getPedstatus() {
        return pedstatus;
    }

    public void setPedstatus(int pedstatus) {
        this.pedstatus = pedstatus;
    }

    public String getSpacecoverUrl() {
        return spacecoverUrl;
    }

    public void setSpacecoverUrl(String spacecoverUrl) {
        this.spacecoverUrl = spacecoverUrl;
    }

    @Override
    public String toString() {
        return "UserInfoResponse{" +
                "userid=" + userid +
                ", username='" + username + '\'' +
                ", headpicurl='" + headpicurl + '\'' +
                ", realname='" + realname + '\'' +
                ", nickname='" + nickname + '\'' +
                ", mobile='" + mobile + '\'' +
                ", usertype=" + usertype +
                ", regtype=" + regtype +
                ", height=" + height +
                ", weight=" + weight +
                ", stepwidth=" + stepwidth +
                ", stepgoal=" + stepgoal +
                ", birthday=" + birthday +
                ", email='" + email + '\'' +
                ", gender=" + gender +
                ", city='" + city + '\'' +
                ", pedstatus=" + pedstatus +
                ", spacecoverUrl='" + spacecoverUrl + '\'' +
                '}';
    }
}
