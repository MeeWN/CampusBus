package com.example.mee.home.core.Model;

import android.os.AsyncTask;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Patric on 5/22/2017.
 */

public class Report  extends AsyncTask<String, Void, Boolean> {
    private String id;
    private String report;

    public Report(String id,String report){
        this.id = id;
        this.report = report;
    }
    @Override
    protected Boolean doInBackground(String... urlIn) {
        boolean process =false;
        String url = urlIn[0];
        HttpClient client = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost(url);

        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("PASSENGER_ID", id));
        params.add(new BasicNameValuePair("REPORT", report));


        try {
            httpPost.setEntity(new UrlEncodedFormEntity(params));
            HttpResponse response = client.execute(httpPost);
            process= true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return process;
    }
}
