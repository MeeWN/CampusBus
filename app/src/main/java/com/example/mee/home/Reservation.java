package com.example.mee.home;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.icu.text.IDNA;
import android.icu.text.IDNA.Info;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.mee.home.core.Model.PostReserve;

import java.io.Serializable;

import static android.R.attr.value;
import static com.example.mee.home.R.id.spinner;
import static com.example.mee.home.R.id.spinner2;

public class Reservation extends AppCompatActivity {
    String stSpinner,stSpinner2,stSpinner3;
    PostReserve postReserve;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


      /*  Button fab = (Button) findViewById(R.id.button);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Reservation Complete", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        Button btnSubmit = (Button) findViewById(R.id.btnReserv);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            Spinner spinner = (Spinner) findViewById(R.id.spinner);
            Spinner spinner2 = (Spinner) findViewById(R.id.spinner2);
            Spinner spinner3 = (Spinner) findViewById(R.id.spinner3);
            SharedPreferences sharedpf = getSharedPreferences("userInfo", Context.MODE_PRIVATE);

            @Override
            public void onClick(View v) {
                stSpinner = spinner.getSelectedItem().toString();
                stSpinner2 = spinner2.getSelectedItem().toString();
                stSpinner3 = spinner3.getSelectedItem().toString();
                postReserve = new PostReserve(
                        sharedpf.getString("username","59130500001"),
                        "2"
                );
                postReserve.execute("http://ebus.dreaminc.xyz/reserve/save");
                Intent intent = new Intent();
//                intent.putExtra("stSpinner",stSpinner);
//                intent.putExtra("stSpinner2",stSpinner2);
//                intent.putExtra("stSpinner3",stSpinner3);
                setResult(RESULT_OK,intent);
                finish();
            }
        });
    }



}


