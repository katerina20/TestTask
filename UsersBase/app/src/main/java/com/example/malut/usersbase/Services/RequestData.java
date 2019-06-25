package com.example.malut.usersbase.Services;

public class RequestData {

    private static String apiLink = "https://randomuser.me/api/";
    private static String amount = "20";


    public static String apiRequest(){
        StringBuilder link = new StringBuilder(apiLink);
        link.append(String.format("?results=%s&noinfo",amount));
        return link.toString();
    }

}
