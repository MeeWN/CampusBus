package com.example.mee.home;

import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MotionEvent;
import android.view.View;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.mee.home.core.CardAdapter;
import com.example.mee.home.core.DBHelper;
import com.example.mee.home.core.ReservationController;
import org.json.JSONArray;
import org.json.JSONObject;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {
    int toggle = 0;
    ImageView reserv;
    TextView text1;
    long time =10000;
    TextView from,to,timeText ;
    private static final String FORMAT = "%02d:%02d:%02d";
    private SharedPreferences sharedpf ;
    private TextView viewName;
    private TextView viewUsername;
    private TextView viewFacuty;
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private RecyclerView.LayoutManager layoutManager;
    private Context context;
    private RecyclerView.Adapter adapter;
    private ReservationController reserveController;
    private JSONArray dataSet;
    private JSONObject dataobj;
    private String username;
    private DBHelper helper;
    private android.app.FragmentManager fragmentManager;
    private Fragment fragment;
    int seconds , minutes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        helper= new DBHelper(this);
        sharedpf = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        viewName = (TextView)findViewById(R.id.viewName);
        viewUsername = (TextView)findViewById(R.id.viewUsername);
        viewFacuty = (TextView)findViewById(R.id.viewFacuty);
        viewName.setText(sharedpf.getString("name","Unknown"));
        viewUsername.setText(sharedpf.getString("username","unknown"));
        viewFacuty.setText(sharedpf.getString("facuty","unknown"));
        username = sharedpf.getString("username","59130500001");
        reserveController = new ReservationController();
        fragment = new  Fragment();
        fragmentManager = getFragmentManager();
        try {
            dataSet = reserveController.getWhere(username);
            CardAdapter cardAdapter = new CardAdapter(dataSet);
            recyclerView = (RecyclerView)findViewById(R.id.recycleView);
            recyclerView.setHasFixedSize(true);
            linearLayoutManager = new LinearLayoutManager(this);
            recyclerView.setLayoutManager(linearLayoutManager);
            recyclerView.setAdapter(cardAdapter);
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }



//COUNTDOWN TIMER
//        text1=(TextView)findViewById(R.id.cd);
//
//        new CountDownTimer(time, 1000) { // adjust the milli seconds here
//
//            public void onTick(long millisUntilFinished) {
//
//                text1.setText("รถจะออกใน  "+String.format(FORMAT,
//                        TimeUnit.MILLISECONDS.toHours(millisUntilFinished),
//                        TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished) - TimeUnit.HOURS.toMinutes(
//                                TimeUnit.MILLISECONDS.toHours(millisUntilFinished)),
//                        TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) - TimeUnit.MINUTES.toSeconds(
//                                TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished))));
//            }
//
//            public void onFinish() {
//                text1.setText("ีรถออกจากสถานีแล้ว");
//            }
//        }.start();
//
//        FloatingActionButton plus = (FloatingActionButton) findViewById(R.id.plus);
//        plus.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if(toggle%2==0) {
//                    findViewById(R.id.bus).setVisibility(View.VISIBLE);
//                    findViewById(R.id.noti).setVisibility(View.VISIBLE);
//                    findViewById(R.id.report).setVisibility(View.VISIBLE);
//                    toggle++;
//                }
//                else{
//                    findViewById(R.id.bus).setVisibility(View.INVISIBLE);
//                    findViewById(R.id.noti).setVisibility(View.INVISIBLE);
//                    findViewById(R.id.report).setVisibility(View.INVISIBLE);
//                    toggle++;
//                }
//            }
//        });



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
//    //GET DATA FROM RESERVATION PAGE AND SHOW
//    public void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if (requestCode == 1) {
//            if (resultCode == RESULT_OK) {
//                TextView f =(TextView)findViewById(R.id.textView);
//                f.setVisibility(View.INVISIBLE);
//                ImageView arrow =(ImageView) findViewById(R.id.arrow);
//                arrow.setVisibility(View.VISIBLE);
//                String strEditText = data.getStringExtra("stSpinner");
//                from = (TextView)findViewById(R.id.tFrom);
//                from.setText(strEditText);
//                String strEditText2 = data.getStringExtra("stSpinner2");
//                to = (TextView)findViewById(R.id.tTo);
//                to.setText(strEditText2);
//            }
//        }
//    }

}
