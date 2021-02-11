package com.coursefetch.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class fpassword extends AppCompatActivity {

    EditText passreset;
    Button reset;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fpassword);

        passreset = findViewById(R.id.reset);
        reset = findViewById(R.id.btnReset);
        DB = new DBHelper(this);

        reset.setOnClickListener(view -> {

            String user = passreset.getText().toString();

            Boolean checkuser = DB.checkusername(user);
            if(checkuser==true){
                Intent intent = new Intent(getApplicationContext(),ResetActivity.class);
                intent.putExtra("username",user);
                startActivity(intent);
            }else{
                Toast.makeText(fpassword.this,"User does not exist",Toast.LENGTH_SHORT).show();
            }
        });

    }
}