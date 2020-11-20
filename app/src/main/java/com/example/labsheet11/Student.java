package com.example.labsheet11;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.labsheet11.Database.MessageDBManagement;
import com.example.labsheet11.R;

import java.util.ArrayList;
import java.util.List;

public class Student extends AppCompatActivity {
    TextView WelcomeText;

    ListView SubList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);
        Intent i1=getIntent();
        WelcomeText=findViewById(R.id.textView3);
        String Wel="Welcome "+i1.getStringExtra("UserName");
        WelcomeText.setText(Wel);
        SubList=findViewById(R.id.SubjectList);
        MessageDBManagement MSDB= new MessageDBManagement(getApplicationContext());
        List MyList=new ArrayList();
        MyList= MSDB.GetallMessaged();


        ArrayAdapter arrayAdapter= new ArrayAdapter(this, android.R.layout.simple_list_item_1,MyList);
        SubList.setAdapter(arrayAdapter);

        SubList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i1 = new Intent(getApplicationContext(),Message.class);

                String x=Integer.toString(position);
                i1.putExtra("Position",x);
                startActivity(i1);
            }
        });

    }

    public void Addnotifaction(){

    }
}