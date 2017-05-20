package com.example.mee.home.core.Model;

import android.os.AsyncTask;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nutt on 5/20/2017.
 */

public class Cancelation extends AsyncTask<String, Void, Boolean> {
    private String id;
    private int status;

    public Cancelation(String id ) throws IOException {
        this.id = id;

    }
    @Override
    protected Boolean doInBackground(String... urlIn) {
        try{
            HttpGet httpget = new HttpGet(urlIn[0]+"/"+id);
            HttpClient httpclient = new DefaultHttpClient();
            HttpResponse response = httpclient.execute(httpget);
            status = response.getStatusLine().getStatusCode();

        }catch (Exception e){
            e.printStackTrace();
        }
        if (status == 200){
            return true;
        }else{
            return false;
        }
    }
}
