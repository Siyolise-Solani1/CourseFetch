package com.coursefetch.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

public class HomeActivity extends AppCompatActivity {

    Button courses, fund, jobs, signOut;
    ImageView home,messages,settings,profile;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        courses = findViewById(R.id.btncourse);
        fund = findViewById(R.id.btnfunds);
        jobs = findViewById(R.id.btnjobs);
        signOut = findViewById(R.id.btnSignOut);
        home = findViewById(R.id.homeicon);
        messages = findViewById(R.id.mailbox);
        settings = findViewById(R.id.settingsicon);
        profile = findViewById(R.id.userimg);
        DB = new DBHelper(this);

        courses.setOnClickListener(view ->{

        });

        fund.setOnClickListener(view ->{
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_VIEW);
            intent.addCategory(Intent.CATEGORY_BROWSABLE);
            intent.setData(Uri.parse("http://www.zabursaries.co.za/"));
            startActivity(intent);

        });

        jobs.setOnClickListener(view ->{
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_VIEW);
            intent.addCategory(Intent.CATEGORY_BROWSABLE);
            intent.setData(Uri.parse("https://www.graduates24.com/grade12"));
            startActivity(intent);
        });

        home.setOnClickListener(view ->{
            Intent intent = new Intent(this, HomeActivity.class);
            startActivity(intent);
        });

        messages.setOnClickListener(view ->{
            Intent intent = new Intent(this, NotificationActivity.class);
            startActivity(intent);
        });

        settings.setOnClickListener(view ->{
            Intent intent = new Intent(this, SettingsActivity.class);
            startActivity(intent);
        });

        profile.setOnClickListener(view ->{
            Intent intent = new Intent(this, ProfileActivity.class);
            startActivity(intent);
        });

        signOut.setOnClickListener(view ->{
            Intent intent = new Intent(this, Registration.class);
            startActivity(intent);
        });
    }
}