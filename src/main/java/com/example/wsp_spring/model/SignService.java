package com.example.wsp_spring.model;

public class SignService {

    public boolean doSignIn(String userID, String passphrase){
        if(userID.equals(passphrase)){
            return true;
        }
        return false;
    }
}
