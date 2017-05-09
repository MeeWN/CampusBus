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
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;
import com.example.mee.home.core.Model.PostReserve;
import java.io.Serializable;
import java.util.ArrayList;
import static android.R.attr.value;
import static com.example.mee.home.R.id.spinner;
import static com.example.mee.home.R.id.spinner2;

public class Reservation extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    private String stSpinner, stSpinner2, stSpinner3;
    private PostReserve postReserve;
    private Spinner spinner;
    private Spinner spinner2;
    private Spinner spinner3;
    private Context context;
    private String selected;
    String[] from,BMD,BKT,KX,RM2;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        selected = "from";
        context = this;
        spinner = (Spinner) findViewById(R.id.spinner);
        spinner2 = (Spinner) findViewById(R.id.spinner2);
        spinner3 = (Spinner) findViewById(R.id.spinner3);
        from = getResources().getStringArray(R.array.from);
        BMD = getResources().getStringArray(R.array.BMD);
        BKT = getResources().getStringArray(R.array.BKT);
        KX = getResources().getStringArray(R.array.KX);
        RM2 = getResources().getStringArray(R.array.RM2);
        spinner.setOnItemSelectedListener(this);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(context, android.R.layout.simple_dropdown_item_1line,getSelected());
        spinner.setAdapter(adapter);
        spinner2.setAdapter(adapter);
        SharedPreferences sharedpf = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        Button btnSubmit = (Button) findViewById(R.id.btnReserv);

        //END OF SHIT

//            @Override
//            public void onClick(View v) {
//                stSpinner = spinner.getSelectedItem().toString();
//                stSpinner2 = spinner2.getSelectedItem().toString();
//                stSpinner3 = spinner3.getSelectedItem().toString();
//                postReserve = new PostReserve(
//                        sharedpf.getString("username","59130500001"),
//                        "2"
//                );
//                postReserve.execute("http://ebus.dreaminc.xyz/reserve/save");
//                Intent intent = new Intent();
////                intent.putExtra("stSpinner",stSpinner);
////                intent.putExtra("stSpinner2",stSpinner2);
////                intent.putExtra("stSpinner3",stSpinner3);
//                setResult(RESULT_OK,intent);
//                finish();
//            }
//        });
//    }

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//        changeValue(parent.getItemAtPosition(position).toString());
        selected = parent.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public String[] getSelected(){
        if (selected.equals("BMD")){
            return BMD;
        }else if (selected.equals("BKT")){
            return BKT;
        }else if (selected.equals("KX")){
            return KX;
        }else if (selected.equals("RM2")){
            return RM2;
        }else{
            return from;
        }
    }
}
