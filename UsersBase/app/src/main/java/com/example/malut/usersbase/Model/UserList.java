package com.example.malut.usersbase.Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class UserList {

    private ArrayList<User> results;

    public ArrayList<User> getResults() {
        return results;
    }

    public void appendList(UserList newList){
        this.results.addAll(newList.results);
    }




}
