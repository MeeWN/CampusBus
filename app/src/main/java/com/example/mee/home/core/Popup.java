package com.example.mee.home.core;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;

import com.example.mee.home.R;

/**
 * Created by aftei on 12-May-17.
 */

public class Popup extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popupwindow);

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);

        int width = displayMetrics.widthPixels;
        int height = displayMetrics.heightPixels;

        getWindow().setLayout((int)(width*0.8),(int)(height*0.6));



    }
}
