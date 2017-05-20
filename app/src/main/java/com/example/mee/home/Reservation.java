package com.example.mee.home;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.icu.text.IDNA;
import android.icu.text.IDNA.Info;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import com.example.mee.home.core.Model.PostReserve;
import java.io.Serializable;
import java.util.ArrayList;
import static android.R.attr.value;
//import static com.example.mee.home.R.id.spinner;


public class Reservation extends AppCompatActivity {
    private String routeId;
    private String selectRoute;
    private String selectTime;
    private String stSpinner, stSpinner2, stSpinner3;
    private PostReserve postReserve;
    private SharedPreferences sharedpf;
    private Spinner spinner;
    private Spinner spinner2;
    private Spinner spinner3;
    private Spinner spinner4;
    private Spinner spinner5;
    private Spinner spinner6;
    private Spinner spinner7;
    private Spinner spinner8;
    private Context context;
    private String selected;
    String[] from, BMD, BKT, KX, RM2;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation);
        sharedpf = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        Spinner[] spinners = new Spinner[8];
        final Spinner spinner1 = (Spinner) findViewById(R.id.spinner1);
        final Spinner spinner2 = (Spinner) findViewById(R.id.spinner2);
        final Spinner spinner3 = (Spinner) findViewById(R.id.spinner3);
        final Spinner spinner4 = (Spinner) findViewById(R.id.spinner4);
        final Spinner spinner5 = (Spinner) findViewById(R.id.spinner5);
        final Spinner spinner6 = (Spinner) findViewById(R.id.spinner6);
        final Spinner spinner7 = (Spinner) findViewById(R.id.spinner7);
        final Spinner spinner8 = (Spinner) findViewById(R.id.spinner8);
        String[] bmd_bkt = new String[]{"00:00", "07:15", "07:30", "08:00", "08:30", "09:00", "09:30", "10:00", "11:00", "12:00", "12:30",
                "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00"};
        String[] bkt_bmd = new String[]{"00:00", "07:30", "08:00", "08:30", "09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00",
                "16:30", "17:00", "17:30", "18:30", "19:00", "19:30", "20:00", "20:30"};
        String[] rm2_bkt = new String[]{"00:00", "08:00", "08:30", "09:00"};
        String[] bkt_rm2 = new String[]{"00:00", "17:00", "18:00"};
        String[] kx_bkt = new String[]{"00:00", "08:00", "08:30", "11:20", "12:00", "12:50", "14:50", "15:20", "16:10"};
        String[] bkt_kx = new String[]{"00:00", "09:30", "09:50", "10:15", "14:00", "15:00", "17:15", "17:50", "18:30"};
        String[] bmd_kx = new String[]{"00:00"};
        String[] kx_bmd = new String[]{"00:00"};

        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, bmd_bkt);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, bkt_bmd);
        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, rm2_bkt);
        ArrayAdapter<String> adapter4 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, bkt_rm2);
        ArrayAdapter<String> adapter5 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, kx_bkt);
        ArrayAdapter<String> adapter6 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, bkt_kx);
        ArrayAdapter<String> adapter7 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, bmd_kx);
        ArrayAdapter<String> adapter8 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, kx_bmd);
        spinner1.setAdapter(adapter1);
        spinner2.setAdapter(adapter2);
        spinner3.setAdapter(adapter3);
        spinner4.setAdapter(adapter4);
        spinner5.setAdapter(adapter5);
        spinner6.setAdapter(adapter6);
        spinner7.setAdapter(adapter7);
        spinner8.setAdapter(adapter8);

        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                String name = spinner1.getSelectedItem().toString();
                if (name != "00:00") {
                    spinner1.setEnabled(false);
                    spinner2.setEnabled(false);
                    spinner3.setEnabled(false);
                    spinner4.setEnabled(false);
                    spinner5.setEnabled(false);
                    spinner6.setEnabled(false);
                    spinner7.setEnabled(false);
                    spinner8.setEnabled(false);
                    selectRoute = "1";
                    selectTime = name;
                    findRoute();
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });

        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                String name = spinner2.getSelectedItem().toString();
                if (name != "00:00") {
                    spinner1.setEnabled(false);
                    spinner2.setEnabled(false);
                    spinner3.setEnabled(false);
                    spinner4.setEnabled(false);
                    spinner5.setEnabled(false);
                    spinner6.setEnabled(false);
                    spinner7.setEnabled(false);
                    spinner8.setEnabled(false);
                    selectRoute = "2";
                    selectTime = name;
                    findRoute();
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });
        spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                String name = spinner3.getSelectedItem().toString();
                if (name != "00:00") {
                    spinner1.setEnabled(false);
                    spinner2.setEnabled(false);
                    spinner3.setEnabled(false);
                    spinner4.setEnabled(false);
                    spinner5.setEnabled(false);
                    spinner6.setEnabled(false);
                    spinner7.setEnabled(false);
                    spinner8.setEnabled(false);
                    selectRoute = "3";
                    selectTime = name;
                    findRoute();
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });
        spinner4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                String name = spinner4.getSelectedItem().toString();
                if (name != "00:00") {
                    spinner1.setEnabled(false);
                    spinner2.setEnabled(false);
                    spinner3.setEnabled(false);
                    spinner4.setEnabled(false);
                    spinner5.setEnabled(false);
                    spinner6.setEnabled(false);
                    spinner7.setEnabled(false);
                    spinner8.setEnabled(false);
                    selectRoute = "4";
                    selectTime = name;
                    findRoute();
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });
        spinner5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                String name = spinner5.getSelectedItem().toString();
                if (name != "00:00") {
                    spinner1.setEnabled(false);
                    spinner2.setEnabled(false);
                    spinner3.setEnabled(false);
                    spinner4.setEnabled(false);
                    spinner5.setEnabled(false);
                    spinner6.setEnabled(false);
                    spinner7.setEnabled(false);
                    spinner8.setEnabled(false);
                    selectRoute = "5";
                    selectTime = name;
                    findRoute();
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });
        spinner6.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                String name = spinner6.getSelectedItem().toString();
                if (name != "00:00") {
                    spinner1.setEnabled(false);
                    spinner2.setEnabled(false);
                    spinner3.setEnabled(false);
                    spinner4.setEnabled(false);
                    spinner5.setEnabled(false);
                    spinner6.setEnabled(false);
                    spinner7.setEnabled(false);
                    spinner8.setEnabled(false);
                    selectRoute = "6";
                    selectTime = name;
                    findRoute();
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });
        spinner7.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                String name = spinner7.getSelectedItem().toString();
                if (name != "00:00") {
                    spinner1.setEnabled(false);
                    spinner2.setEnabled(false);
                    spinner3.setEnabled(false);
                    spinner4.setEnabled(false);
                    spinner5.setEnabled(false);
                    spinner6.setEnabled(false);
                    spinner7.setEnabled(false);
                    spinner8.setEnabled(false);
                    selectRoute = "7";
                    selectTime = name;
                    findRoute();
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });
        spinner8.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                String name = spinner8.getSelectedItem().toString();
                if (name != "00:00") {
                    spinner1.setEnabled(false);
                    spinner2.setEnabled(false);
                    spinner3.setEnabled(false);
                    spinner4.setEnabled(false);
                    spinner5.setEnabled(false);
                    spinner6.setEnabled(false);
                    spinner7.setEnabled(false);
                    spinner8.setEnabled(false);
                    selectRoute = "8";
                    selectTime = name;
                    findRoute();
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });
    }
        public void findRoute(){
            if (this.selectTime != null) {
                if (selectRoute.equals("1") && selectTime.equals("07:15")) {
                    routeId = "1";
                    reserve();
                } else if (selectRoute.equals("1") && selectTime.equals("07:30")) {
                    routeId = "36";
                    reserve();
                } else if (selectRoute.equals("1") && selectTime.equals("20:00")) {
                    routeId = "32";
                    reserve();
                } else if (selectRoute.equals("1") && selectTime.equals("16:00")) {
                    routeId = "64";
                    reserve();
                } else if (selectRoute.equals("1") && selectTime.equals("19:00")) {
                    routeId = "30";
                    reserve();
                } else if (selectRoute.equals("1") && selectTime.equals("12:00")) {
                    routeId = "50";
                    reserve();
                } else if (selectRoute.equals("1") && selectTime.equals("18:00")) {
                    routeId = "28";
                    reserve();
                } else if (selectRoute.equals("1") && selectTime.equals("12:30")) {
                    routeId = "53";
                    reserve();
                } else if (selectRoute.equals("1") && selectTime.equals("14:00")) {
                    routeId = "57";
                    reserve();
                } else if (selectRoute.equals("1") && selectTime.equals("15:00")) {
                    routeId = "61";
                    reserve();
                } else if (selectRoute.equals("1") && selectTime.equals("17:00")) {
                    routeId = "24";
                    reserve();
                } else if (selectRoute.equals("1") && selectTime.equals("07:15")) {
                    routeId = "1";
                    reserve();
                } else if (selectRoute.equals("1") && selectTime.equals("13:00")) {
                    routeId = "56";
                    reserve();
                } else if (selectRoute.equals("1") && selectTime.equals("12:00")) {
                    routeId = "72";
                    reserve();
                } else if (selectRoute.equals("1") && selectTime.equals("11:00")) {
                    routeId = "10";
                } else if (selectRoute.equals("1") && selectTime.equals("08:30")) {
                    routeId = "40";
                    reserve();
                } else if (selectRoute.equals("1") && selectTime.equals("10:00")) {
                    routeId = "8";
                    reserve();
                } else if (selectRoute.equals("1") && selectTime.equals("08:30")) {
                    routeId = "41";
                    reserve();
                } else if (selectRoute.equals("1") && selectTime.equals("09:30")) {
                    routeId = "6";
                    reserve();
                } else if (selectRoute.equals("1") && selectTime.equals("09:00")) {
                    routeId = "5";
                    reserve();
                } else if (selectRoute.equals("1") && selectTime.equals("08:30")) {
                    routeId = "4";
                    reserve();
                } else if (selectRoute.equals("1") && selectTime.equals("08:00")) {
                    routeId = "3";
                    reserve();
                } else if (selectRoute.equals("2") && selectTime.equals("16:30")) {
                    routeId = "23";
                    reserve();
                } else if (selectRoute.equals("2") && selectTime.equals("12:00")) {
                    routeId = "73";
                    reserve();
                } else if (selectRoute.equals("2") && selectTime.equals("20:30")) {
                    routeId = "33";
                    reserve();
                } else if (selectRoute.equals("2") && selectTime.equals("16:00")) {
                    routeId = "20";
                    reserve();
                } else if (selectRoute.equals("2") && selectTime.equals("11:00")) {
                    routeId = "49";
                    reserve();
                } else if (selectRoute.equals("2") && selectTime.equals("12:00")) {
                    routeId = "51";
                    reserve();
                } else if (selectRoute.equals("2") && selectTime.equals("08:00")) {
                    routeId = "37";
                    reserve();
                } else if (selectRoute.equals("2") && selectTime.equals("13:00")) {
                    routeId = "55";
                    reserve();
                } else if (selectRoute.equals("2") && selectTime.equals("14:00")) {
                    routeId = "58";
                    reserve();
                } else if (selectRoute.equals("2") && selectTime.equals("15:00")) {
                    routeId = "62";
                    reserve();
                } else if (selectRoute.equals("2") && selectTime.equals("17:30")) {
                    routeId = "26";
                    reserve();
                } else if (selectRoute.equals("2") && selectTime.equals("07:30")) {
                    routeId = "2";
                    reserve();
                } else if (selectRoute.equals("2") && selectTime.equals("18:00")) {
                    routeId = "68";
                    reserve();
                } else if (selectRoute.equals("2") && selectTime.equals("16:00")) {
                    routeId = "20";
                    reserve();
                } else if (selectRoute.equals("2") && selectTime.equals("16:30")) {
                    routeId = "23";
                    reserve();
                } else if (selectRoute.equals("2") && selectTime.equals("20:00")) {
                    routeId = "71";
                    reserve();
                } else if (selectRoute.equals("2") && selectTime.equals("17:00")) {
                    routeId = "66";
                    reserve();
                } else if (selectRoute.equals("2") && selectTime.equals("19:30")) {
                    routeId = "31";
                    reserve();
                } else if (selectRoute.equals("2") && selectTime.equals("20:30")) {
                    routeId = "33";
                    reserve();
                } else if (selectRoute.equals("2") && selectTime.equals("08:30")) {
                    routeId = "42";
                    reserve();
                } else if (selectRoute.equals("3") && selectTime.equals("08:00")) {
                    routeId = "38";
                    reserve();
                } else if (selectRoute.equals("3") && selectTime.equals("09:00")) {
                    routeId = "46";
                    reserve();
                } else if (selectRoute.equals("3") && selectTime.equals("08:30")) {
                    routeId = "44";
                    reserve();
                } else if (selectRoute.equals("4") && selectTime.equals("18:00")) {
                    routeId = "69";
                    reserve();
                } else if (selectRoute.equals("4") && selectTime.equals("17:00")) {
                    routeId = "67";
                    reserve();
                } else if (selectRoute.equals("5") && selectTime.equals("12:00")) {
                    routeId = "52";
                    reserve();
                } else if (selectRoute.equals("5") && selectTime.equals("08:00")) {
                    routeId = "39";
                    reserve();
                } else if (selectRoute.equals("5") && selectTime.equals("16:10")) {
                    routeId = "22";
                    reserve();
                } else if (selectRoute.equals("5") && selectTime.equals("11:20")) {
                    routeId = "11";
                    reserve();
                } else if (selectRoute.equals("5") && selectTime.equals("14:50")) {
                    routeId = "60";
                    reserve();
                } else if (selectRoute.equals("5") && selectTime.equals("08:30")) {
                    routeId = "43";
                    reserve();
                } else if (selectRoute.equals("5") && selectTime.equals("16:10")) {
                    routeId = "22";
                    reserve();
                } else if (selectRoute.equals("5") && selectTime.equals("15:20")) {
                    routeId = "65";
                    reserve();
                } else if (selectRoute.equals("6") && selectTime.equals("10:15")) {
                    routeId = "9";
                    reserve();
                } else if (selectRoute.equals("6") && selectTime.equals("09:50")) {
                    routeId = "7";
                    reserve();
                } else if (selectRoute.equals("6") && selectTime.equals("17:15")) {
                    routeId = "25";
                    reserve();
                } else if (selectRoute.equals("6") && selectTime.equals("15:00")) {
                    routeId = "63";
                    reserve();
                } else if (selectRoute.equals("6") && selectTime.equals("17:50")) {
                    routeId = "27";
                    reserve();
                } else if (selectRoute.equals("6") && selectTime.equals("14:00")) {
                    routeId = "59";
                    reserve();
                } else if (selectRoute.equals("6") && selectTime.equals("18:30")) {
                    routeId = "29";
                    reserve();
                } else if (selectRoute.equals("6") && selectTime.equals("09:30")) {
                    routeId = "47";
                    reserve();
                }
            }
        }

        public void reserve() {
            postReserve = new PostReserve(sharedpf.getString("username", "59130500001"), routeId);
            postReserve.execute("http://ebus.dreaminc.xyz/reserve/save");
        }
    }//On Create
//Class





     /*   if(spinner.isSelected()==true){
            spinner.setEnabled(false);
            spinner2.setEnabled(false);
            spinner3.setEnabled(false);
            spinner4.setEnabled(false);
            spinner5.setEnabled(false);
            spinner6.setEnabled(false);
        }
    }*/







       /*      Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
           setSupportActionBar(toolbar);
           selected = "from";
           context = this;*/




      /*  from = getResources().getStringArray(R.array.from);
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
}*/
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




  /* @Override
   public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
      changeValue(parent.getItemAtPosition(position).toString());
        selected = parent.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }*/

    /*public String[] getSelected(){
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
    }*/


