package com.example.mee.home.core;

import android.content.ContentValues;
import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.Date;

/**
 * Created by aftei on 06-May-17.
 */

public class DBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "ebus.db";
    public static final String TABLE_NAME = "TIME_TABLE";
    public static final String ID = "ID";
    public static final String FROM = "FROM";
    public static final String TO = "TO";
    public static final String DATE = "DATE";


    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public DBHelper(Context context){
        super(context,DATABASE_NAME,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_TIME_TABLE = "CREATE TABLE TIME_TABLE ( id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "FROM TEXT, TO TEXT, DATETIME TEXT)";

        db.execSQL(CREATE_TIME_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        String DROUP_TIME_TABLE = "DROP TABLE IF EXISTS TIME_TABLE";

        db.execSQL(DROUP_TIME_TABLE);

        onCreate(db);
    }

    public boolean insert(String from, String to, String date){
        boolean sucess = false;
        SQLiteDatabase db =this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(FROM,from);
        cv.put(TO,to);
        cv.put(DATE,date);
        db.insert("TIME_TABLE",null,cv);
        sucess = true;
        return sucess;
    }
}
