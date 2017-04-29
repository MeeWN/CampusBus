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
    private String name;
    private String facuty;
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
        while (realPassword==null){
            this.realPassword=conn.getPassword();
        }
    }

    public void loadUserData(){
        JSONObject jobj =  conn.getJson();
       try{
           this.name = jobj.getString("name");
           this.facuty = jobj.getString("facuty");
       }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public String getRealUsername() {
        return realUsername;
    }

    public void setRealUsername(String realUsername) {
        this.realUsername = realUsername;
    }

    public String getRealPassword() {
        return realPassword;
    }

    public void setRealPassword(String realPassword) {
        this.realPassword = realPassword;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFacuty() {
        return facuty;
    }

    public void setFacuty(String facuty) {
        this.facuty = facuty;
    }

    public boolean checkLogin(){
        if(givenPassword.equals(realPassword)){
            return true;
        }else{
            return false;
        }
    }





}

