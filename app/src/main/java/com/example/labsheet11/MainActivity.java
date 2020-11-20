package com.example.labsheet11;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.labsheet11.Database.UserDBManagement;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button Register,Login;
    EditText UserName,Password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Register=findViewById(R.id.RegisterButton);
        Login=findViewById(R.id.LoginButton);
        UserName=findViewById(R.id.EditTextUserName);
        Password=findViewById(R.id.EditTextpassowrd);
        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1 = new Intent(getApplicationContext(),Register.class);
                startActivity(i1);
            }
        });
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckLogin();
            }
        });
    }

    public void CheckLogin(){
        Register=findViewById(R.id.RegisterButton);
        Login=findViewById(R.id.LoginButton);
        UserName=findViewById(R.id.EditTextUserName);
        Password=findViewById(R.id.EditTextpassowrd);
        UserDBManagement LoginCheckDb= new UserDBManagement(getApplicationContext());
        List Data= new ArrayList();
        Data=LoginCheckDb.CheckLoginDetails(UserName.getText().toString(),Password.getText().toString());

        if (Data.size() == 0){
            Toast.makeText(this, "Password or Username is Invalid", Toast.LENGTH_SHORT).show();
        }else if(Data.get(1).equals("Student")){
            Intent i1 = new Intent(getApplicationContext(), Student.class);
            i1.putExtra("UserName",Data.get(0).toString());
            startActivity(i1);

        }else{
            Intent i1 = new Intent(getApplicationContext(), Teacher.class);
            i1.putExtra("UserName",Data.get(0).toString());
            startActivity(i1);
        }


    }
}