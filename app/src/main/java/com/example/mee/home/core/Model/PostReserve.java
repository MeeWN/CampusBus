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




public class PostReserve extends AsyncTask<String, Void, Boolean> {
    private String routeId,time,stdId;

    public PostReserve(String stdId,String routeId ){
        this.stdId = stdId;
        this.routeId = routeId ;

    }
    @Override
    protected Boolean doInBackground(String... urlIn) {
        boolean process = false;
        String url = urlIn[0];
        HttpClient client = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost(url);

        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("PASSENGER_ID", stdId));
        params.add(new BasicNameValuePair("TIMETABLE_ID", routeId));

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
