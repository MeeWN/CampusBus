package com.example.mee.home;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.Image;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MotionEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {
    int toggle = 0;
    ImageView reserv;
    TextView text1;
    long time =10000;
    TextView from,to,timeText ;
    private static final String FORMAT = "%02d:%02d:%02d";
    private SharedPreferences sharedpf = getSharedPreferences("userInfo", Context.MODE_PRIVATE);

    int seconds , minutes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        text1=(TextView)findViewById(R.id.cd);

        new CountDownTimer(time, 1000) { // adjust the milli seconds here

            public void onTick(long millisUntilFinished) {

                text1.setText("รถจะออกใน  "+String.format(FORMAT,
                        TimeUnit.MILLISECONDS.toHours(millisUntilFinished),
                        TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished) - TimeUnit.HOURS.toMinutes(
                                TimeUnit.MILLISECONDS.toHours(millisUntilFinished)),
                        TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) - TimeUnit.MINUTES.toSeconds(
                                TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished))));
            }

            public void onFinish() {
                text1.setText("ีรถออกจากสถานีแล้ว");
            }
        }.start();

        FloatingActionButton plus = (FloatingActionButton) findViewById(R.id.plus);
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(toggle%2==0) {
                    findViewById(R.id.bus).setVisibility(View.VISIBLE);
                    findViewById(R.id.noti).setVisibility(View.VISIBLE);
                    findViewById(R.id.report).setVisibility(View.VISIBLE);
                    toggle++;
                }
                else{
                    findViewById(R.id.bus).setVisibility(View.INVISIBLE);
                    findViewById(R.id.noti).setVisibility(View.INVISIBLE);
                    findViewById(R.id.report).setVisibility(View.INVISIBLE);
                    toggle++;
                }
            }
        });
        ImageView bus = (ImageView) findViewById(R.id.bus);
        bus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        reserv = (ImageView) findViewById(R.id.bus);

        reserv.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {

                Intent mainIntent =new Intent(MainActivity.this,Reservation.class);
                mainIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivityForResult(mainIntent,1);
                return true;
            }
        });
        ImageView notifi = (ImageView) findViewById(R.id.noti);

        notifi.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {

                Intent mainIntent =new Intent(MainActivity.this,Notification.class);
                mainIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivityForResult(mainIntent,1);
                return true;
            }
        });
        ImageView re = (ImageView) findViewById(R.id.report);

        re.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {

                Intent mainIntent =new Intent(MainActivity.this,Report.class);
                mainIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivityForResult(mainIntent,1);
                return true;
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                TextView f =(TextView)findViewById(R.id.textView);
                f.setVisibility(View.INVISIBLE);
                ImageView arrow =(ImageView) findViewById(R.id.arrow);
                arrow.setVisibility(View.VISIBLE);
                String strEditText = data.getStringExtra("stSpinner");
                from = (TextView)findViewById(R.id.tFrom);
                from.setText(strEditText);
                String strEditText2 = data.getStringExtra("stSpinner2");
                to = (TextView)findViewById(R.id.tTo);
                to.setText(strEditText2);
            }
        }
    }
}
