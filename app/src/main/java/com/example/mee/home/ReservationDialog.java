package com.example.mee.home;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.json.JSONObject;

/**
 * Created by aftei on 12-May-17.
 */

public class ReservationDialog extends DialogFragment{

    private JSONObject data;
    private int position;

    public ReservationDialog() {
    }

    public ReservationDialog(int position) {
        this.position = position;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.trip_doalog,null);
    }

    public void setData(JSONObject data){
        this.data = data;
    }

    public int getPosition(){
        return position;
    }
}
