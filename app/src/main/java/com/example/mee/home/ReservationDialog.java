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

    public ReservationDialog() {
    }

    public ReservationDialog(JSONObject data) {
        this.data = data;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.trip_doalog,null);

    }
}
