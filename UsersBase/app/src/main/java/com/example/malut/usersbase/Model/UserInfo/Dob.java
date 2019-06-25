package com.example.malut.usersbase.Model.UserInfo;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Dob implements Serializable {
    private Date date;
    private int age;

    public Dob(Date date, int age) {
        this.date = date;
        this.age = age;
    }

    public String getDate() {
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        return dateFormat.format(this.date);
    }

    public int getAge() {
        return age;
    }
}
