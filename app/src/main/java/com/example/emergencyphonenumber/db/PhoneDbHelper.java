package com.example.emergencyphonenumber.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by RTA on 11/26/2017.
 */

public class PhoneDbHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "phone.db";
    private static final int DATABASE_VERSION = 8;

    public static final String TABLE_NAME = "phone_number";
    public static final String COL_ID = "_id";
    public static final String COL_TITLE = "title";
    public static final String COL_NUMBER = "number";
    public static final String COL_PICTURE = "picture";

    private static final String CREATE_TABLE = "CREATE TABLE" + TABLE_NAME + "("
            + COL_ID + " INTERGER PRIMARY KEY AUTOINCREMENT, "
            + COL_TITLE + " TEXT, "
            + COL_NUMBER + " TEXT, "
            + COL_PICTURE + "TEXT) ";

    public PhoneDbHelper(Context context) { // คือคอนสรัคเจอร์ กด alt + ins
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override //กด ctrl + o
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
        insertInitialData(db);
    }

    private void insertInitialData(SQLiteDatabase db) { //สร้างmethod
        ContentValues cv = new ContentValues();
        cv.put(COL_TITLE, "แจ้งเหตุด่วนเหตุร้าย");
        cv.put(COL_NUMBER, "191");
        cv.put(COL_PICTURE, "number0001.png");
        db.insert(TABLE_NAME, null, cv);

        cv = new ContentValues();
        cv.put(COL_TITLE, "แจ้งเหตุเพลิงไหม้");
        cv.put(COL_NUMBER, "199");
        cv.put(COL_PICTURE, "number0002.png");
        db.insert(TABLE_NAME, null, cv);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
