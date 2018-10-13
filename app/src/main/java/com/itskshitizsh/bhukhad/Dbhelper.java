package com.itskshitizsh.bhukhad;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Dbhelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "Cart.db";
    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + DbContract.Dbentry.TABLE_NAME + " (" +
                    DbContract.Dbentry.COLUMN_NAME_PRODUCT + " TEXT ," +
                    DbContract.Dbentry.COLUMN_NAME_CANTEEN + " TEXT," +
                    DbContract.Dbentry.COLUMN_NAME_PRICE + "TEXT," +
                    DbContract.Dbentry.COLUMN_NAME_QUANTITY + " INTEGER)";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + DbContract.Dbentry.TABLE_NAME;

    public Dbhelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }

    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }
}
