package com.example.mee.home.core;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mee.home.R;
import com.example.mee.home.ReservationDialog;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by aftei on 5/1/2017.
 */

    /*Activity activity =(Activity) v.getContext();
            ReservationDialog reservationDialog = new ReservationDialog();
            reservationDialog.show(activity.getFragmentManager(),"dialog");*/
public class CardAdapter extends RecyclerView
        .Adapter<CardAdapter
        .DataObjectHolder> {
    private JSONArray mDataset;
    private static MyOnclickListener myOnclickListener;

    public static class DataObjectHolder extends RecyclerView.ViewHolder
            implements View
            .OnClickListener {
        TextView textDeparture;
        TextView textArrive;

        public DataObjectHolder(View itemView) {
            super(itemView);
            textDeparture = (TextView) itemView.findViewById(R.id.textDeparture);
            textArrive = (TextView) itemView.findViewById(R.id.textArrive);
            itemView.setOnClickListener(this);
        }
        @Override
        public void onClick(View v) {
            myOnclickListener.onClick(v);
        }
    }



    public CardAdapter(JSONArray myDataset) {
        mDataset = myDataset;
    }

    @Override
    public DataObjectHolder onCreateViewHolder(ViewGroup parent,
                                               int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_reservation, parent, false);

        DataObjectHolder dataObjectHolder = new DataObjectHolder(view);
        return dataObjectHolder;
    }

    @Override
    // OnCreate Each Card
    public void onBindViewHolder(DataObjectHolder holder, final int position) {
        try{
            holder.textArrive.setText(mDataset.getJSONObject(position).getString("ARRIVE"));
            holder.textDeparture.setText(mDataset.getJSONObject(position).getString("DEPART"));
            myOnclickListener =new MyOnclickListener() {
                @Override
                public void onClick(View v) {
                    try{
                        Activity activity =(Activity) v.getContext();
                        ReservationDialog reservationDialog = new ReservationDialog(mDataset.getJSONObject(position));
                        reservationDialog.show(activity.getFragmentManager(),"dialog");
                    }catch (JSONException e){
                        e.printStackTrace();
                    }
                }
            };
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void addItem(JSONObject dataObj, int index) {
        mDataset.put(dataObj);
    }

    @Override
    public int getItemCount() {
        return mDataset.length();
    }

    public interface MyOnclickListener{
        public void onClick(View v);

    }

}
