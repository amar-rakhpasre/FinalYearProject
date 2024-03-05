package com.example.finalyearproject.java;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.finalyearproject.R;

public class WallcomeActivity01 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wallcome01);

        Intent nextLog = new Intent(WallcomeActivity01.this, Login_Activity.class);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                startActivity(nextLog);
                finish();
            }
        },4000);

    }
}