package com.example.mee.home.core;

import android.provider.BaseColumns;

/**
 * Created by aftei on 06-May-17.
 */

public class Timetable {
    private int id;
    private String from;
    private String to;
    private String date;
    public static final String DATABASE_NAME = "ebus.db";
    public static final int DATABASE_VERSION = 1;
    public static final String TABLE = "TIME_TABLE";

    public Timetable() {
    }

    public Timetable(int id, String from, String to, String date) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.date = date;
    }

    public class Column {
        public static final String ID = BaseColumns._ID;
        public static final String from = "from";
        public static final String to = "to";
        public static final String date = "date";
    }


}
