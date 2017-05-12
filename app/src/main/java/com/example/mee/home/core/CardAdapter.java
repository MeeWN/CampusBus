package com.example.mee.home.core;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.example.mee.home.R;
import com.example.mee.home.ReservationDialog;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created by aftei on 5/1/2017.
 */

// Provide a reference to the views for each data item
// Complex data items may need more than one view per item, and
// you provide access to all the views for a data item in a view holder
//public static class ViewHolder extends RecyclerView.ViewHolder {
//    // each data item is just a string in this case
//    public TextView mTextView;
//    public ViewHolder(TextView v) {
//        super(v);
//        mTextView = v;
//    }
//}
//
//    // Provide a suitable constructor (depends on the kind of dataset)
//    public MyAdapter(String[] myDataset) {
//        mDataset = myDataset;
//    }
//
//    // Create new views (invoked by the layout manager)
//    @Override
//    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,int viewType) {
//        // create a new view
//        TextView v = (TextView) LayoutInflater.from(parent.getContext())
//                .inflate(R.layout.card_reservation, parent, false);
//        // set the view's size, margins, paddings and layout parameters
//        ViewHolder vh = new ViewHolder(v);
//        return vh;
//    }
//
//    // Replace the contents of a view (invoked by the layout manager)
//    @Override
//    public void onBindViewHolder(ViewHolder holder, int position) {
//        // - get element from your dataset at this position
//        // - replace the contents of the view with that element
//        holder.mTextView.setText(mDataset[position]);
//
//    }
//
//    // Return the size of your dataset (invoked by the layout manager)
//    @Override
//    public int getItemCount() {
//        return mDataset.length;
//    }
//}
    /*Activity activity =(Activity) v.getContext();
            ReservationDialog reservationDialog = new ReservationDialog();
            reservationDialog.show(activity.getFragmentManager(),"dialog");*/
public class CardAdapter extends RecyclerView
        .Adapter<CardAdapter
        .DataObjectHolder> {
    private JSONArray mDataset;

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
            Activity activity =(Activity) v.getContext();

            ReservationDialog reservationDialog = new ReservationDialog();
            reservationDialog.show(activity.getFragmentManager(),"dialog");
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
    public void onBindViewHolder(DataObjectHolder holder, int position) {
        try{
            holder.textArrive.setText(mDataset.getJSONObject(position).getString("ARRIVE"));
            holder.textDeparture.setText(mDataset.getJSONObject(position).getString("DEPART"));
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


}
