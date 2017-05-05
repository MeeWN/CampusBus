package com.example.mee.home.core;

import com.example.mee.home.core.Model.Reservation;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.concurrent.ExecutionException;

/**
 * Created by aftei on 4/30/2017.
 */

public class ReservationController {
    private JSONArray dataArr ;
    private JSONObject dataObj;
    private Reservation reservation;

    public ReservationController(){
        reservation =new Reservation();
    }

    public JSONArray getAll(){
        reservation.setUrl("http://ebus.dreaminc.xyz/reserve");
        reservation.execute();
        return reservation.getDataArray();
    }

    public JSONArray getWhere(int id)  {
        reservation.setUrl("http://ebus.dreaminc.xyz/reserve/"+id);
        reservation.execute();
        return reservation.getDataArray();
    }

    public JSONArray getWhere(String id) throws ExecutionException, InterruptedException {
        reservation.setUrl("http://ebus.dreaminc.xyz/reserve/"+id);
        reservation.execute().get();
        return reservation.getDataArray();
    }



}
