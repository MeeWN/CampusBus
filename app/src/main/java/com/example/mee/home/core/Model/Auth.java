package com.example.mee.home.core.Model;

import android.os.AsyncTask;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import java.io.IOException;


public class Auth extends AsyncTask<String, Integer, Boolean> {
    private JSONArray json;
    private String url;
    private JSONObject jsonobj;
    private String password;

    public Auth(String url) {
        this.url = url;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

    }

    @Override
    protected Boolean doInBackground(String... urls) {
        try {

            //------------------>>
            HttpGet httpget = new HttpGet(url);
            HttpClient httpclient = new DefaultHttpClient();
            HttpResponse response = httpclient.execute(httpget);
            int status = response.getStatusLine().getStatusCode();

            if (status == 200) {
                HttpEntity entity = response.getEntity();
                String data = EntityUtils.toString(entity);
                this.json = new JSONArray(data);
                jsonobj = new JSONObject(json.get(0).toString());
                this.password = jsonobj.getString("password");
                return true;
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return false;
    }

    protected void onPostExecute(Boolean result) {

    }

    public JSONObject getJson() {
        return jsonobj;
    }

    public void setJson(JSONArray json) {
        this.json = json;
    }
    public String getPassword(){return this.password;}
}



