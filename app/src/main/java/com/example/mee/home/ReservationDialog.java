package com.example.mee.home;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.json.JSONObject;

/**
 * Created by aftei on 12-May-17.
 */

public class ReservationDialog extends DialogFragment{

    private JSONObject data;
    private int position;
    private TextView dialog_from,dialog_to,text_bus,text_Time;

    public ReservationDialog() {
    }

    public ReservationDialog(int position) {
        this.position = position;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView =  inflater.inflate(R.layout.trip_doalog,null);
        dialog_from =(TextView)  rootView.findViewById(R.id.dialog_from);
        dialog_to = (TextView) rootView.findViewById(R.id.dialog_to);
        text_bus = (TextView) rootView.findViewById(R.id.text_bus);
        text_Time = (TextView) rootView.findViewById(R.id.text_time);
        try{
            dialog_from.setText(coverRoute(data.getString("DEPART")));
            dialog_to.setText(coverRoute(data.getString("ARRIVE")));
            text_bus.setText(data.getString("TYPE"));
            text_Time.setText(data.getString("DATETIME"));
        }catch (Exception e){
            e.getStackTrace();
        }
        return  rootView;
    }

    public void setData(JSONObject data){
        this.data = data;
    }

    public int getPosition(){
        return position;
    }

    public String coverRoute(String in){
        switch (in){
            case "BKT":
                return "KMUTT Bangkhuntien";
            case "BMD":
                return "KMUTT Bangmod";
            case "RM2":
                return "Lotus Rama2";
            case "KX":
                return "Knowledge Exchange";
        }
        return null;
    }

    public String convertType(String in){
        switch (in){
            case "1":
                return "B";
            case "2":
                return "B2";
            case "3":
                return "V";

        }
        return null;
    }
}
