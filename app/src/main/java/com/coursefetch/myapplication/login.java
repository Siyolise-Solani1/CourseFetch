package com.coursefetch.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class login extends AppCompatActivity {

    EditText email, password;
    Button btnlogin;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = findViewById(R.id.username1);
        password = findViewById(R.id.password1);
        btnlogin = findViewById(R.id.btnLogin1);
        DB = new DBHelper(this);

        btnlogin.setOnClickListener(v -> {

            String user = email.getText().toString();
            String pass = password.getText().toString();

            if(user.equals("")||pass.equals(""))
                Toast.makeText(login.this,"Please enter all fields", Toast.LENGTH_SHORT).show();
            else {
                Boolean checkuserpass = DB.checkuserpass(user,pass);
                if (checkuserpass == true) {
                    Toast.makeText(login.this,"Sign in Successful", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(),login.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(login.this,"Invalid credentials", Toast.LENGTH_SHORT).show();
                        }

                    }
        });
    }
}