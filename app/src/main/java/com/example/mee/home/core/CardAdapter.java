package com.example.mee.home.core;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.TextView;

import com.example.mee.home.R;

import org.json.JSONArray;

/**
 * Created by aftei on 5/1/2017.
 */

public class CardAdapter extends RecyclerView.Adapter {
    Context mContext;
    JSONArray jArray;
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView depart, arrive ,time;

        public MyViewHolder(View view) {
            super(view);
            depart = (TextView) view.findViewById(R.id.textDeparture);
            arrive = (TextView) view.findViewById(R.id.textArrive);
            time = (TextView) view.findViewById(R.id.textTime);

        }
    }
    public CardAdapter(Context mContext, JSONArray data){
            this.mContext = mContext;
            this.jArray= data;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        TextView v =(TextView) LayoutInflater.from(parent.getContext()).
                inflate(R.layout.card_reservation,parent,false);
        MyViewHolder viewHolder = new MyViewHolder(v);
        return  viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        holder.depart.setText();
        
    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
