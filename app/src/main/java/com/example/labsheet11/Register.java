
package com.example.labsheet11;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.labsheet11.Database.UserDBManagement;

public class Register extends AppCompatActivity {

    EditText UserName,Password;
    CheckBox Student, Teacher;
    Button Register;
    String Type;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Register=findViewById(R.id.RegisterButton1);


        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddUsertoDB();
            }
        });

    }
    public  void AddUsertoDB(){
        UserName=findViewById(R.id.EditTextUsername);
        Password=findViewById(R.id.EditTextpassword);
        Student=findViewById(R.id.StudentCheckbox);
        Teacher=findViewById(R.id.TeacherCheckBox);
        if(Student.isChecked()== true){
            Type="Student";

        }else{
            Type="Teacher";
        }
        UserDBManagement UserDB = new UserDBManagement(getApplicationContext());
        long exec=UserDB.AddUser(UserName.getText().toString(),Password.getText().toString(),Type);
        if(exec > 0){
            Toast.makeText(this, "User Added", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Fail", Toast.LENGTH_SHORT).show();
        }

    }
}