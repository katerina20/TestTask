package com.example.malut.usersbase.Model.UserInfo;

import java.io.Serializable;

public class Location implements Serializable {
    private String state;
    private String city;

    public Location(String state, String city) {
        this.state = state;
        this.city = city;
    }

    public String getState() {
        return toUpperCase(this.state);
    }

    public String getCity() {
        return toUpperCase(this.city);
    }

    private String toUpperCase(String s){
        return s.substring(0, 1).toUpperCase() + s.substring(1);
    }

    @Override
    public String toString() {
        return toUpperCase(this.city) + ", " + toUpperCase(this.state);
    }
}
