package com.example.malut.usersbase.Model.UserInfo;

import java.io.Serializable;

public class Name implements Serializable {

    private String first;
    private String last;

    public Name(String first, String last) {
        this.first = first;
        this.last = last;
    }

    public String getFirst() {
        return toUpperCase(first);
    }

    public String getLast() {
        return toUpperCase(last);
    }

    private String toUpperCase(String s){
        return s.substring(0, 1).toUpperCase() + s.substring(1);
    }

    @Override
    public String toString() {
        return toUpperCase(this.first) + " " + toUpperCase(this.last);
    }
}
