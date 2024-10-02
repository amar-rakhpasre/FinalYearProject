package com.example.finalyearproject.SudoOperation;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.finalyearproject.R;
import com.example.finalyearproject.java.Login_Activity;
import com.google.firebase.auth.FirebaseAuth;

public class SudoActivity extends AppCompatActivity {
    private ImageView addSchedule; // Declare the ImageView
    private Button LogoutButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sudo);

        // Initialize the ImageView
        addSchedule = findViewById(R.id.addSchedule);
        LogoutButton = findViewById(R.id.LogoutBTN);

        // Set OnClickListener for the ImageView
        addSchedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle the click event for addSchedule ImageView
                Intent intent = new Intent(SudoActivity.this, UploadSchedule.class);
                startActivity(intent);
            }
        });

        LogoutButton.setOnClickListener(v -> {
            // Handle logout button click, e.g., sign out the user
            FirebaseAuth.getInstance().signOut();
            Intent intent = new Intent(SudoActivity.this, Login_Activity.class);
            startActivity(intent);
        });
    }
}
