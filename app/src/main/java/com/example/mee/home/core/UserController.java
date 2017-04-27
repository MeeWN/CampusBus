package com.example.mee.home.core;

import android.accounts.NetworkErrorException;
import android.util.Log;

import com.example.mee.home.core.Model.Auth;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created by aftei on 4/27/2017.
 */

public class UserController {

    private String realUsername;
    private String realPassword = "";
    private String givenPassword;
    private String url;
    private Auth conn;
    private JSONArray data ;


    public UserController(String username,String password)  {
        this.realUsername = username;
        this.givenPassword = password;
        this.url = "http://ebus.dreaminc.xyz/auth/"+realUsername;
        //http://ebus.dreaminc.xyz/auth/59130500001
        try {
            conn = new Auth(url);
            conn.execute();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        this.realPassword=conn.getPassword();
        int count=0;
        while (realPassword==null){
            this.realPassword=conn.getPassword();
        }
    }


    public boolean checkLogin(){
        if(givenPassword.equals(realPassword)){
            return true;
        }else{
            return false;
        }
    }



}

