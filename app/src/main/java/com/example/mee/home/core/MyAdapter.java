package com.example.mee.home.core;

import android.app.Activity;
import android.app.Fragment;
import android.app.NotificationManager;
import android.graphics.BitmapFactory;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.CountDownTimer;
import android.support.v7.app.NotificationCompat;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.mee.home.Notification;
import com.example.mee.home.R;
import com.example.mee.home.ReservationDialog;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import static android.content.Context.NOTIFICATION_SERVICE;

/**
 * Created by M'ee on 5/22/2017.
 */

/*public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private String[] mDataset;
  //  private JSONArray mDataset;
    private JSONObject eachCard;
    private ReservationDialog reservationDialog;
    private static String time;
    private static ReservationDialog rd;
    private static Fragment fragment;
    private static MyAdapter.MyOnClickListener myOnClickListener;
    public static MyAdapter.NotiSystem notiSystem;
    static Uri uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
    private static final String FORMAT = "%02d:%02d:%02d";
    static long curTime;
    Notification noti = new Notification();

    public static class DataObjectHolder extends RecyclerView.ViewHolder
            implements View
            .OnClickListener {
        TextView textDeparture;
        TextView textArrive;
        TextView textTime;
        ImageButton cancleButton;


        public DataObjectHolder(View itemView) {
            super(itemView);
            textDeparture = (TextView) itemView.findViewById(R.id.textDeparture);
            textArrive = (TextView) itemView.findViewById(R.id.textArrive);
            textTime = (TextView) itemView.findViewById(R.id.textTime);
            cancleButton = (ImageButton) itemView.findViewById(R.id.cancelButton);
            time = "20:15:00";
            itemView.setOnClickListener(this);
            fragment = new Fragment();

        }

        @Override
        public void onClick(View v) {
            try {
                myOnClickListener.onClick(v);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView mTextView;
        public ViewHolder(TextView v) {
            super(v);
            mTextView = v;
        }
    }
    public MyAdapter(String[] myDataset) {
        mDataset = myDataset;
    }
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
        try {
            //Countdown
            new CountDownTimer(curTime, 1000) { // adjust the milli seconds here
                public void onTick(long millisUntilFinished) {
                    curTime = millisUntilFinished;
                    holder.textTime.setText(String.format(FORMAT,
                            TimeUnit.MILLISECONDS.toHours(millisUntilFinished),
                            TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished) - TimeUnit.HOURS.toMinutes(
                                    TimeUnit.MILLISECONDS.toHours(millisUntilFinished)),
                            TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) - TimeUnit.MINUTES.toSeconds(
                                    TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished))));
                    if (millisUntilFinished >= 3599000 && millisUntilFinished <= 3601000 && Notification.stHour == true) {
                        notiSystem.showNotification("อีก 1 ชม.รถจะออกจากสถานี", holder.itemView);
                    }
                    if (millisUntilFinished >= 1799000 && millisUntilFinished <= 1801000 && Notification.stMin30 == true) {
                        notiSystem.showNotification("อีก 30 นาทีรถจะออกจากสถานี", holder.itemView);
                    }
                    if (millisUntilFinished >= 899000 && millisUntilFinished <= 901000 && Notification.stMin15 == true) {
                        notiSystem.showNotification("อีก 15 นาทีรถจะออกจากสถานี", holder.itemView);
                    }
                    if (millisUntilFinished >= 299000 && millisUntilFinished <= 301000 && Notification.stMin5 == true) {
                        notiSystem.showNotification("อีก 5 นาทีรถจะออกจากสถานี", holder.itemView);
                    }

                }

                //Finish countdown
                public void onFinish() {
                    holder.textTime.setText("00:00");
                }
            }.start();
            /*END COUNTDOWN*/
    /*        eachCard = mDataset.getJSONObject(position);
//            holder.cancleButton.setOnClickListener((new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    try {
//                        Cancelation cancelation = new Cancelation(eachCard.getString("id"));
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                }
//            }));
            reservationDialog = new ReservationDialog(position);
            myOnClickListener = new MyAdapter.MyOnClickListener() {
                @Override
                public void onClick(View v) throws JSONException {
                    Activity activity = (Activity) v.getContext();
                    int x = position;
                    reservationDialog.show(activity.getFragmentManager(),"Dialog");
                }
            };
            holder.textArrive.setText(mDataset.getJSONObject(position).getString("ARRIVE"));
            holder.textDeparture.setText(mDataset.getJSONObject(position).getString("DEPART"));
            final String[] temp = mDataset.getJSONObject(position).getString("DATETIME").split(":");
            temp[0] = temp[0];
            temp[1] = temp[1];
            // temp[2]=temp[2];
            int hour = Integer.parseInt(temp[0]);
            int minute = Integer.parseInt(temp[1]);
            Date date = new Date();
            final Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.set(Calendar.HOUR_OF_DAY, hour);
            calendar.set(Calendar.MINUTE, minute);
            curTime = calendar.getTimeInMillis() - new Date().getTime();

            notiSystem = new MyAdapter.NotiSystem() {
                @Override
                public void showNotification(String text, View v) {
                    android.app.Notification notification = new NotificationCompat.Builder(v.getContext()) // this is context
                            .setSmallIcon(R.drawable.bus_vehicle)
                            .setLargeIcon(BitmapFactory.decodeResource(v.getContext().getResources(),
                                    R.drawable.logo))
                            .setContentTitle("CampusBus")
                            .setContentText(text)
                            .setSound(uri)
                            .setAutoCancel(true)
                            .build();

                    NotificationManager notificationManager = (NotificationManager) v.getContext().getSystemService(NOTIFICATION_SERVICE);
                    notificationManager.notify(1000, notification);
                }
            };

        } catch (Exception e) {
            e.printStackTrace();
        }
        holder.mTextView.setText(mDataset[position]);

    }

    @Override
    public int getItemCount() {
        return mDataset.length();
    }
    public static void onItemClick(int position, View v) {
        rd.show(fragment.getFragmentManager(), "gg");
    }

    /*-----Interface-----*/
  /*  public interface MyOnClickListener {
        public void onClick(View v) throws JSONException;

    }

    public interface NotiSystem {
        public void showNotification(String text, View v);
    }

}*/