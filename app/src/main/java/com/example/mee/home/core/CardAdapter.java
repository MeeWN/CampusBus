package com.example.mee.home.core;

import android.app.Activity;
import android.os.CountDownTimer;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.mee.home.R;
import com.example.mee.home.ReservationDialog;
import org.json.JSONArray;
import org.json.JSONObject;
import org.w3c.dom.Text;

import android.app.Fragment;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

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
    private  JSONObject eachCard;
    private static  String time;
    private static ReservationDialog rd;
    private static Fragment fragment;
    private static MyOnClickListener myOnClickListener;
    private static final String FORMAT = "%02d:%02d:%02d";

    public static class DataObjectHolder extends RecyclerView.ViewHolder
            implements View
            .OnClickListener {
        TextView textDeparture;
        TextView textArrive;
        TextView textTime;

        public DataObjectHolder(View itemView) {
            super(itemView);
            textDeparture = (TextView) itemView.findViewById(R.id.textDeparture);
            textArrive = (TextView) itemView.findViewById(R.id.textArrive);
            textTime = (TextView) itemView.findViewById(R.id.textTime);
            time = "20:15:00";
            itemView.setOnClickListener(this);
            fragment = new Fragment();

        }
        @Override
        public void onClick(View v) {
            myOnClickListener.onClick();
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
    public void onBindViewHolder(final DataObjectHolder holder, final int position) {
        try{
            eachCard = mDataset.getJSONObject(position);
            holder.textArrive.setText(mDataset.getJSONObject(position).getString("ARRIVE"));
            holder.textDeparture.setText(mDataset.getJSONObject(position).getString("DEPART"));
            //holder.textTime.setText();
            final String[] temp= eachCard.getString("DATETIME").split(":");
            temp[0]=temp[0];
            temp[1]=temp[1];
           // temp[2]=temp[2];
            int hour=Integer.parseInt(temp[0]);
            int minute=Integer.parseInt(temp[1]);
            Date date = new Date();
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.set(Calendar.HOUR_OF_DAY,  hour);
            calendar.set(Calendar.MINUTE, minute);
            final long curTime =  calendar.getTimeInMillis()-new Date().getTime();

            new CountDownTimer(curTime, 1000) { // adjust the milli seconds here

                public void onTick(long millisUntilFinished) {

                    holder.textTime.setText(String.format(FORMAT,
                            TimeUnit.MILLISECONDS.toHours(millisUntilFinished),
                            TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished) - TimeUnit.HOURS.toMinutes(
                                    TimeUnit.MILLISECONDS.toHours(millisUntilFinished)),
                            TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) - TimeUnit.MINUTES.toSeconds(
                                    TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished))));
                }

                public void onFinish() {
                    holder.textTime.setText("00:00");
                }
            }.start();
            myOnClickListener =new MyOnClickListener() {
                @Override
                public void onClick() {
                    try{
                        rd = new ReservationDialog(mDataset.getJSONObject(position));
                        rd.show(fragment.getFragmentManager(),"gg");
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            };


            rd = new ReservationDialog(eachCard);
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


        public static void onItemClick(int position, View v){
            rd.show(fragment.getFragmentManager(),"gg");
        }

        public interface MyOnClickListener{
            public void onClick();
    }


}
