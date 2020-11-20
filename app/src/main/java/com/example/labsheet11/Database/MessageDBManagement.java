package com.example.labsheet11.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class MessageDBManagement extends SQLiteOpenHelper {
    public static final  String DATABSE_NAME="CourseApp3.db";
    public MessageDBManagement( Context context) {
        super(context, DATABSE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {



    }
    public long SaveMessagge(String Subject,String User,String Message ){
        SQLiteDatabase DB= getWritableDatabase();
        ContentValues CV= new ContentValues();
        CV.put(MessageMaster.Message.COLUMN_NAME_MESSAGE,Message);
        CV.put(MessageMaster.Message.COLUMN_NAME_SUBJECT,Subject);
        CV.put(MessageMaster.Message.COLUMN_NAME_USER,User);

        long Execution= DB.insert(MessageMaster.Message.TABLE_NAME,null,CV);
        return Execution;

    }

    public List GetallMessaged (){
        SQLiteDatabase DB= getReadableDatabase();
        String[] Projection ={
               MessageMaster.Message.COLUMN_NAME_SUBJECT
        };
        Cursor curser=DB.query(
                MessageMaster.Message.TABLE_NAME,
                Projection,
                null,
                null,
                null,
                null,
                null
        );

        List DataRerived = new ArrayList();

        while(curser.moveToNext()){
            DataRerived.add(curser.getString(curser.getColumnIndex(MessageMaster.Message.COLUMN_NAME_SUBJECT)));
        }

        return DataRerived;
    }

    public List GetMessageByID (String id){

        SQLiteDatabase DB= getReadableDatabase();
        String[] Projection ={
                MessageMaster.Message.COLUMN_NAME_SUBJECT,
                MessageMaster.Message.COLUMN_NAME_MESSAGE
        };

        String Selection= MessageMaster.Message._ID +" Like ?";
        String [] args={ id };
        Cursor curser=DB.query(
                MessageMaster.Message.TABLE_NAME,
                Projection,
                Selection,
                args,
                null,
                null,
                null
        );


        List DataRerived = new ArrayList();

        while(curser.moveToNext()){
            DataRerived.add(curser.getString(curser.getColumnIndex(MessageMaster.Message.COLUMN_NAME_SUBJECT)));
            DataRerived.add(curser.getString(curser.getColumnIndex(MessageMaster.Message.COLUMN_NAME_MESSAGE)));
        }

        return DataRerived;
    }
}
