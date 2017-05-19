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




    /*    FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

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
 /*   public void checkNoti() {

        long curTime = CardAdapter.getCurTime();
        new CountDownTimer(curTime, 1000) {
            public void onTick(long millisUntilFinished) {

                String.format(FORMAT,
                        TimeUnit.MILLISECONDS.toHours(millisUntilFinished),
                        TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished) - TimeUnit.HOURS.toMinutes(
                                TimeUnit.MILLISECONDS.toHours(millisUntilFinished)),
                        TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) - TimeUnit.MINUTES.toSeconds(
                                TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished)));

                if (millisUntilFinished >= 3599000 && millisUntilFinished <= 3601000 && Notification.stHour == true) {
                    showNotification("อีก 1 ชม.รถจะออกจากสถานี");
                }
                if (millisUntilFinished >= 1799000 && millisUntilFinished <= 1801000 && Notification.stMin30 == true) {
                    showNotification("อีก 30 นาที รถจะออกจากสถานี");
                }
                if (millisUntilFinished >= 899000 && millisUntilFinished <= 901000 && Notification.stMin15 == true) {
                    showNotification("อีก 15 นาที รถจะออกจากสถานี");
                }
                if (millisUntilFinished >= 299000 && millisUntilFinished <= 301000 && Notification.stMin5 == true) {
                    showNotification("อีก 5 นาที รถจะออกจากสถานี");
                }
            }

            public void onFinish() {

            }
        }.start();
    }

*/

  /*  public void showNotification(String text) {
        android.app.Notification notification = new NotificationCompat.Builder(this) // this is context
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("CampusBus")
                .setContentText(text)
                 .setSound(uri)
                .setAutoCancel(true)
                .build();

        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(1000, notification);
    }*/
}





