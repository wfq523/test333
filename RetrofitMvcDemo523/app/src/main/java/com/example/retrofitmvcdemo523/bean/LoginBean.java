package com.example.retrofitmvcdemo523.bean;

public class LoginBean {
    private String id;
    private String sessiodid;

    public String getSessiodid() {
        return sessiodid;
    }

    public void setSessiodid(String sessiodid) {
        this.sessiodid = sessiodid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    private String username;
    private String userpass;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserpass() {
        return userpass;
    }

    public void setUserpass(String userpass) {
        this.userpass = userpass;
    }
}
