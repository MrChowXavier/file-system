package com.aura.filesys.service.model;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.Date;

public class UserInfoModel implements Serializable {
    private String userName;
    private String userPswd;
    private String userLocation;

    @JSONField(format = "yyyy-MM-dd")
    private Date userBirthday;
    private String userGender;
    private String userLanguage;
    private String userDesc;

    public UserInfoModel() {
    }

    public UserInfoModel(String userName, String userPswd, String userLocation, Date userBrithday, String userGender, String userLanguage, String userDesc) {
        this.userName = userName;
        this.userPswd = userPswd;
        this.userLocation = userLocation;
        this.userBirthday = userBrithday;
        this.userGender = userGender;
        this.userLanguage = userLanguage;
        this.userDesc = userDesc;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPswd() {
        return userPswd;
    }

    public void setUserPswd(String userPswd) {
        this.userPswd = userPswd;
    }

    public String getUserLocation() {
        return userLocation;
    }

    public void setUserLocation(String userLocation) {
        this.userLocation = userLocation;
    }

    public Date getUserBirthday() {
        return userBirthday;
    }

    public void setUserBirthday(Date userBirthday) {
        this.userBirthday = userBirthday;
    }

    public String getUserGender() {
        return userGender;
    }

    public void setUserGender(String userGender) {
        this.userGender = userGender;
    }

    public String getUserLanguage() {
        return userLanguage;
    }

    public void setUserLanguage(String userLanguage) {
        this.userLanguage = userLanguage;
    }

    public String getUserDesc() {
        return userDesc;
    }

    public void setUserDesc(String userDesc) {
        this.userDesc = userDesc;
    }
}

