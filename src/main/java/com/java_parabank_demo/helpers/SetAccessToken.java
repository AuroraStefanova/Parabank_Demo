//package com.java_parabank_demo.helpers;
//
//import com.google.gson.JsonParser;
//
//public class SetAccessToken {
//
//    //Use Gson instead that JsonParser
//
//    public static String CheckAuthCodeAndSetAccessToken(String response){
//        JsonParser json = new JsonParser();
//        String authCode = json.getResponseCode(response);
//        String accessToken = "";
//        if (authCode.equals("0")) {
//            accessToken = json.getAccessToken(response);
//        }
//        return accessToken;
//    }
//}
