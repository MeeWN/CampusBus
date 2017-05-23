package com.example.mee.home;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.IntentCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.mee.home.core.Model.Cancelation;

import java.io.IOException;

public class Report extends AppCompatActivity {

    private TextView text_report;
    private Button button;
    private SharedPreferences shPreference;
    private String userName;
    private com.example.mee.home.core.Model.Report report;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        text_report = (TextView) findViewById(R.id.editText);
        button = (Button) findViewById(R.id.report_button);
        shPreference = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        userName = shPreference.getString("username","unknown");

        button.setOnClickListener(new View.OnClickListener() {
            /*
            *
            *
            * Reservation  Button
            *
            */
            @Override
            public void onClick(View v) {
                report = new com.example.mee.home.core.Model.Report(userName,text_report.getText().toString());
                report.setUrl("http://ebus.dreaminc.xyz/report");
                report.execute(); //Send PostRequest
                AlertDialog.Builder builder = new AlertDialog.Builder(Report.this);
                builder.setMessage("Thankyou for your feedback :)");
                builder.show();
                Intent mainIntent = new Intent(Report.this, MainActivity.class);
                mainIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | IntentCompat.FLAG_ACTIVITY_CLEAR_TASK);
                startActivityForResult(mainIntent,1);
            }
        });



    }

}
