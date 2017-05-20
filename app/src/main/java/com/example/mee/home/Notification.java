package com.example.mee.home;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.icu.text.SimpleDateFormat;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.NotificationCompat;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import com.example.mee.home.core.CardAdapter;

import org.w3c.dom.Text;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;
//
//import static com.example.mee.home.R.id.cd;
//import static com.example.mee.home.R.id.hour;

public class Notification extends AppCompatActivity {
    public static boolean stHour;
    public static boolean stMin30;
    public static boolean stMin15;
    public static boolean stMin5;
    Switch hour, min30, min15, min5;
    private static final String FORMAT = "%02d:%02d:%02d";

    static Uri uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_RINGTONE);

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        hour = (Switch) findViewById(R.id.hour);
        hour.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    stHour = true;
                  //  checkNoti();


                } else
                    stHour = false;
            }

        });
        min30 = (Switch) findViewById(R.id.min30);
        min30.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    stMin30 = true;

                } else
                    stMin30 = false;
            }
        });
        min15 = (Switch) findViewById(R.id.min15);
        min15.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    stMin15 = true;
                } else
                    stMin15 = false;
            }
        });
        min5 = (Switch) findViewById(R.id.min5);
        min5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    stMin5 = true;
                } else
                    stMin5 = false;
            }

        });
        hour.setChecked(stHour);
        min30.setChecked(stMin30);
        min15.setChecked(stMin15);
        min5.setChecked(stMin5);
    }
}





