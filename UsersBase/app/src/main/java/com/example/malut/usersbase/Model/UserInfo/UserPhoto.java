package com.example.malut.usersbase.Model.UserInfo;

import java.io.Serializable;

public class UserPhoto implements Serializable {
    private String large;
    private String medium;
    private String thumbnail;

    public UserPhoto(String large, String medium, String thumbnail) {
        this.large = large;
        this.medium = medium;
        this.thumbnail = thumbnail;
    }

    public String getLarge() {
        return large;
    }

    public String getMedium() {
        return medium;
    }

    public String getThumbnail() {
        return thumbnail;
    }
}
