package com.example.malut.usersbase.Model;

import com.example.malut.usersbase.Model.UserInfo.Dob;
import com.example.malut.usersbase.Model.UserInfo.Location;
import com.example.malut.usersbase.Model.UserInfo.Name;
import com.example.malut.usersbase.Model.UserInfo.RegisterDate;
import com.example.malut.usersbase.Model.UserInfo.UserPhoto;

import java.io.Serializable;

public class User implements Serializable {

    private Name name;
    private Location location;
    private String email;
    private Dob dob;
    private RegisterDate registered;
    private UserPhoto picture;

    public User(Name name, Location location, String email, Dob dob, RegisterDate registered, UserPhoto picture) {
        this.name = name;
        this.location = location;
        this.email = email;
        this.dob = dob;
        this.registered = registered;
        this.picture = picture;
    }

    public Name getName() {
        return name;
    }

    public Location getLocation() {
        return location;
    }

    public String getEmail() {
        return email;
    }

    public Dob getDob() {
        return dob;
    }

    public RegisterDate getRegistered() {
        return registered;
    }

    public UserPhoto getPicture() {
        return picture;
    }
}
