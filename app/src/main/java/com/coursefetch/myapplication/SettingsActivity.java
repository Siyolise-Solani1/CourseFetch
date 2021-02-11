package com.coursefetch.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SettingsActivity extends AppCompatActivity {

    Button myprofile,new_pass,notifications,themes;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        myprofile = findViewById(R.id.btnprofile);
        new_pass = findViewById(R.id.btnnewpass);
        notifications = findViewById(R.id.btnotifications);
        themes = findViewById(R.id.btntheme);
        DB = new DBHelper(this);

        myprofile.setOnClickListener(v -> {
            openProfileActivity();

        });
    }
    public void openProfileActivity(){
        Intent intent = new Intent(this, ProfileActivity.class);
        startActivity(intent);
    }
}