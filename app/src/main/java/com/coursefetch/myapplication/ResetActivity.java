package com.coursefetch.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ResetActivity extends AppCompatActivity {

    TextView username;
    EditText pass,repass;
    Button confirm;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset);

        username = findViewById(R.id.user_reset_text);
        pass = findViewById(R.id.pass_reset);
        repass = findViewById(R.id.repass_reset);
        confirm = findViewById(R.id.btnConfPassd);
        DB = new DBHelper(this);

        Intent intent = getIntent();
        username.setText(intent.getStringExtra("username"));

        confirm.setOnClickListener(view -> {

            String user = username.getText().toString();
            String password = pass.getText().toString();
            String repassword = repass.getText().toString();
            if (password.equals(repassword)) {


                Boolean checkpasswordupdate = DB.updatepassword(user, password);
                if (checkpasswordupdate) {
                    new Intent(getApplicationContext(), login.class);
                    startActivity(intent);
                    Toast.makeText(ResetActivity.this, "Password Updated Successfully", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(ResetActivity.this, "Password Not Updated Successfully", Toast.LENGTH_SHORT).show();
                }

            } else {
                Toast.makeText(ResetActivity.this, "Password Not Matching", Toast.LENGTH_SHORT).show();
            }
        });
    }
}