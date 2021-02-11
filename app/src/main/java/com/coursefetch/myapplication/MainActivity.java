package com.coursefetch.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

class Registration extends AppCompatActivity {

    EditText username, password, confirm_password;
    TextView forgotpass;
    Button signUp, signIn;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.username);
        password = findViewById(R.id.userPass);
        confirm_password = findViewById(R.id.userConfPass);
        signUp = findViewById(R.id.btnSignUp);
        signIn = findViewById(R.id.btnSignIn);
        forgotpass = findViewById(R.id.fgtpass);
        DB = new DBHelper(this);

        signUp.setOnClickListener(v -> {
            String user = username.getText().toString();
            String pass = password.getText().toString();
            String conf_pass = confirm_password.getText().toString();

                if(user.equals("")||pass.equals("")||conf_pass.equals(""))
                   Toast.makeText(Registration.this,"Please enter all fields", Toast.LENGTH_SHORT).show();
                else {
                    if (pass.equals(conf_pass)) {
                        Boolean checkuser = DB.checkusername(user);
                        if (!checkuser) {
                            Boolean insert = DB.insertData(user, pass);
                            if (insert) {
                                Toast.makeText(Registration.this,"Registered Successfully", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(),HomeActivity.class);
                                startActivity(intent);
                            } else {
                                Toast.makeText(Registration.this,"Registration failed", Toast.LENGTH_SHORT).show();
                            }
                        }else {
                            Toast.makeText(Registration.this,"User already exists! please sign in",Toast.LENGTH_SHORT).show();
                        }
                    }else {
                        Toast.makeText(Registration.this, "Password not matching", Toast.LENGTH_SHORT).show();
                    }
                }
        });

        signIn.setOnClickListener(v -> {

            Intent intent = new Intent (getApplicationContext(), login.class);
            startActivity(intent);
        });

        forgotpass.setOnClickListener(v -> {

            Intent intent = new Intent (getApplicationContext(), fpassword.class);
            startActivity(intent);
        });
    }
}