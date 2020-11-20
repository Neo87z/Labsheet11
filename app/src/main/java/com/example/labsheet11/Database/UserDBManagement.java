package com.example.labsheet11.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class UserDBManagement extends SQLiteOpenHelper {

    public static final  String DATABSE_NAME="CourseApp3.db";
    public UserDBManagement( Context context) {
        super(context, DATABSE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String Query=
                "CREATE TABLE " + UserMaster.User.TABLE_NAME + " ("+
                        UserMaster.User._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                        UserMaster.User.COLUMN_NAME_USER + " TEXT," +
                        UserMaster.User.COLUMN_NAME_PASSWORD + " TEXT," +
                        UserMaster.User.COLUMN_NAME_TYPE + " TEXT)";
        db.execSQL(Query);
        String Quer2=
                "CREATE TABLE " + MessageMaster.Message.TABLE_NAME + " ("+
                        MessageMaster.Message._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                        MessageMaster.Message.COLUMN_NAME_USER + " TEXT," +
                        MessageMaster.Message.COLUMN_NAME_SUBJECT + " TEXT," +
                        MessageMaster.Message.COLUMN_NAME_MESSAGE + " TEXT)";
        db.execSQL(Quer2);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {


    }
    public long AddUser(String UserName, String Password, String Type){
        SQLiteDatabase DB= getWritableDatabase();
        ContentValues CV= new ContentValues();
        CV.put(UserMaster.User.COLUMN_NAME_USER,UserName);
        CV.put(UserMaster.User.COLUMN_NAME_PASSWORD,Password);
        CV.put(UserMaster.User.COLUMN_NAME_TYPE,Type);

        long Execution=DB.insert(UserMaster.User.TABLE_NAME,null,CV);
        return Execution;

    }

    public List CheckLoginDetails(String Username,String Password){
        SQLiteDatabase DB= getReadableDatabase();
        String[] Projection ={
                UserMaster.User.COLUMN_NAME_USER,
                UserMaster.User.COLUMN_NAME_PASSWORD,
                UserMaster.User.COLUMN_NAME_TYPE
        };

        String Selection= UserMaster.User.COLUMN_NAME_USER +" Like ?";
        String [] args={ Username };
        Cursor curser=DB.query(
                UserMaster.User.TABLE_NAME,
                Projection,
                Selection,
                args,
                null,
                null,
                null
        );

        List DataRerived = new ArrayList();
        String UserType;

        String Pssword;
        while(curser.moveToNext()){
            Pssword=curser.getString(curser.getColumnIndexOrThrow(UserMaster.User.COLUMN_NAME_PASSWORD));
            if (Pssword.equals(Password)){
                UserType=curser.getString(curser.getColumnIndexOrThrow(UserMaster.User.COLUMN_NAME_TYPE));
                DataRerived.add(Username);
                DataRerived.add(UserType);
                break;
            }

        }
        return DataRerived;
    }

}
