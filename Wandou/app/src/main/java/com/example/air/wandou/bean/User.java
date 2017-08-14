package com.example.air.wandou.bean;


import java.io.Serializable;

public class User implements Serializable {

    //
    String id;

    String username;

    String nickname;
    //电话号码
    String mobile;

    String email;

    String token;
    //头像的URL
    String avatarUrl;

    long lastAddressId;

    public User(String id, String username, String nickname, String mobile, String email, String token, String avatarUrl, long lastAddressId) {
        this.id = id;
        this.username = username;
        this.nickname = nickname;
        this.mobile = mobile;
        this.email = email;
        this.token = token;
        this.avatarUrl = avatarUrl;
        this.lastAddressId = lastAddressId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public long getLastAddressId() {
        return lastAddressId;
    }

    public void setLastAddressId(long lastAddressId) {
        this.lastAddressId = lastAddressId;
    }
}
