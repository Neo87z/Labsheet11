package com.example.labsheet11;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.labsheet11.Database.MessageDBManagement;
import com.example.labsheet11.Database.UserMaster;

public class Teacher extends AppCompatActivity {

    TextView WelcomeText;
    EditText Subject,Message;
    Button Save;
    String User;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher);
        Intent i1=getIntent();
        User= i1.getStringExtra("UserName");
        String Wel="Welcome "+i1.getStringExtra("UserName");
        WelcomeText=findViewById(R.id.WelcomeString);
        WelcomeText.setText(Wel);
        Subject=findViewById(R.id.EditTextSubject);
        Message=findViewById(R.id.EditTextMessage);
        Save=findViewById(R.id.button4);

        Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Subject=findViewById(R.id.EditTextSubject);
                Message=findViewById(R.id.EditTextMessage);
                MessageDBManagement MSDB= new MessageDBManagement(getApplicationContext());
                long Exe=MSDB.SaveMessagge(Subject.getText().toString(),User,Message.getText().toString());
                if(Exe > 0 ){
                    Toast.makeText(Teacher.this, "Message Saved", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(Teacher.this, "Error", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}