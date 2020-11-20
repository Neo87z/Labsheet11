package com.example.labsheet11;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.example.labsheet11.Database.MessageDBManagement;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class Message extends AppCompatActivity {

    TextView Subject;
    EditText Message;
    String Pos;
    int pos1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
        Subject=findViewById(R.id.Subject);
        Message=findViewById(R.id.MessageView);
        Intent i1=getIntent();
        Pos=i1.getStringExtra("Position").toString();
        pos1=Integer.parseInt(Pos);
        pos1++;
        Pos=Integer.toString(pos1);
        MessageDBManagement MSDB = new MessageDBManagement(getApplicationContext());
        List MyMessage= new ArrayList();
        MyMessage= MSDB.GetMessageByID(Pos);
        Subject.setText(MyMessage.get(0).toString());
        Message.setText(MyMessage.get(1).toString());




    }
}