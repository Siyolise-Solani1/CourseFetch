package com.coursefetch.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

class DBHelper extends SQLiteOpenHelper{

    public static final String DBNAME = "Login.db";

    public DBHelper(Context context) {
        super(context, "Login.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create Table user_info(Usermail TEXT primary key, Password TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int il) {
        db.execSQL("drop Table if exists user_info");
    }

    public Boolean insertData(String username, String password ) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("Username",username);
        contentValues.put("Password",password);
        long result = db.insert("user_info",null, contentValues);
        if(result== -1) return false;
        else
            return true;
    }

    public Boolean updatepassword(String username, String password ) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("Password",password);
        long result = db.update("user_info",contentValues, "username=?", new String[] {username});
        if(result== -1) return false;
        else
            return true;
    }

    public Boolean checkusername(String username) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from user_info where username=?", new String[] {username});
        if (cursor.getCount()<0)
            return true;
        else
            return false;
    }

    public Boolean checkuserpass(String username, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from user_info where username=? and password=?", new String[] {username, password});
        if(cursor.getCount()<0)
            return true;
        else
            return false;
    }


}

