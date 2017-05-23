package com.example.mee.home;

import android.accounts.NetworkErrorException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mee.home.core.Model.Auth;
import com.example.mee.home.core.UserController;

public class Login extends AppCompatActivity {
    private EditText username;
    private EditText password;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Log.d("Info ","ButtonClicked");
                UserController controller = new UserController(
                        username.getText().toString(),
                        password.getText().toString()
                );
                if (controller.checkLogin()) {
                    controller.loadUserData();
                    SharedPreferences sharedpf = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
                    SharedPreferences.Editor sharedpfEditor = sharedpf.edit();
                    sharedpfEditor.putString("username", controller.getRealUsername());
                    sharedpfEditor.putString("name", controller.getName());
                    sharedpfEditor.putString("facuty", controller.getFacuty());
                    sharedpfEditor.commit();
                    AlertDialog.Builder builder = new AlertDialog.Builder(Login.this);
                    builder.setMessage("Login Pass :)");
                    builder.show();
                    Intent mainIntent = new Intent(Login.this, MainActivity.class);
                    mainIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivityForResult(mainIntent, 1);

                } else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(Login.this);
                       builder.setMessage("ID or Password is Invalid");
                       builder.show();

                }
            }
        });
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }
  /*  public void cancel() {
        AlertDialog.Builder builder = new AlertDialog.Builder(Login.this);
        builder.setMessage("รหัสนะกศึกษาหรือPasswordผิดพลาด");
        builder.show();
    }*/
}



