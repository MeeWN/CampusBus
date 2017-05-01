package com.example.mee.home.core;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mee.home.R;

/**
 * Created by aftei on 5/1/2017.
 */

public class CardAdapter extends RecyclerView.Adapter {
    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView depart, arrive;

        public MyViewHolder(View view) {
            super(view);
            depart = (TextView) view.findViewById(R.id.textDeparture);
            arrive = (TextView) view.findViewById(R.id.textArrive);

        }
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
