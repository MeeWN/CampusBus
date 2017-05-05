package com.example.mee.home.core;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by aftei on 06-May-17.
 */

public class DBHelper extends SQLiteOpenHelper {


    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public DBHelper(Context context){
        super(context,"ebus.db",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_TIME_TABLE = "CREATE TABLE TIME_TABLE ( id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "ROUTE_ID INTEGER, BUS_ID INTEGER, DATETIME TIME)";

        db.execSQL(CREATE_TIME_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        String DROUP_TIME_TABLE = "DROP TABLE IF EXISTS TIME_TABLE";

        db.execSQL(DROUP_TIME_TABLE);

        onCreate(db);
    }
}
