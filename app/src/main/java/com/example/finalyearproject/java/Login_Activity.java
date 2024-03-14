package com.example.finalyearproject.java;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.finalyearproject.R;
import com.example.finalyearproject.databinding.ActivityLoginBinding;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login_Activity extends AppCompatActivity {
    ActivityLoginBinding binding;
    FirebaseAuth firebaseAuth;
    ProgressDialog progressDialog;
    Intent nextHomepage;
    Intent nextResetPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        firebaseAuth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(this);
        nextHomepage = new Intent(Login_Activity.this, HomePage_Activity.class);
        nextResetPassword = new Intent(Login_Activity.this, ForgotPassword_Activity.class);

        binding.login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Your login logic here
                loginUser();
            }
        });

        binding.forgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Forgot password logic in forgotPassword activity java
                startActivity(nextResetPassword);
            }
        });

        binding.goToSignUpActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Login_Activity.this, Register_Activity.class));
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        // Check if user is already logged in
        FirebaseUser currentUser = firebaseAuth.getCurrentUser();
        if (currentUser != null) {
            // User is already logged in, skip login activity and go to the homepage
            startActivity(nextHomepage);
            finish(); // Prevent going back to the login activity using the back button
        }
    }

    private void loginUser() {
        String email = binding.emailAddress.getText().toString().trim();
        String password = binding.password.getText().toString();
        progressDialog.show();
        firebaseAuth.signInWithEmailAndPassword(email, password)
                .addOnSuccessListener(authResult -> {
                    progressDialog.cancel();
                    Toast.makeText(Login_Activity.this, "Login successful", Toast.LENGTH_SHORT).show();
                    startActivity(nextHomepage);
                    finish(); // Prevent going back to the login activity using the back button
                })
                .addOnFailureListener(e -> {
                    progressDialog.cancel();
                    Toast.makeText(Login_Activity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                });
    }
}
