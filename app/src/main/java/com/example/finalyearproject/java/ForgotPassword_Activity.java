package com.example.finalyearproject.java;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.finalyearproject.databinding.ActivityForgotPasswordBinding;
import com.example.finalyearproject.databinding.ActivityLoginBinding;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;

public class ForgotPassword_Activity extends AppCompatActivity {

    ActivityForgotPasswordBinding binding;

    ProgressDialog progressDialog;
    FirebaseAuth firebaseAuth;
    Intent nextLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityForgotPasswordBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        firebaseAuth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(this);
        nextLogin = new Intent(ForgotPassword_Activity.this, Login_Activity.class);

        binding.ResetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String password = binding.password.getText().toString().trim();
                if (password.isEmpty()) {
                    Toast.makeText(ForgotPassword_Activity.this, "Please enter your email address", Toast.LENGTH_SHORT).show();
                    return;
                }

                progressDialog.setTitle("Sending Email");
                progressDialog.show();
                firebaseAuth.sendPasswordResetEmail(password)
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                progressDialog.cancel();
                                Toast.makeText(ForgotPassword_Activity.this, "Email Sent.", Toast.LENGTH_SHORT).show();
                                startActivity(nextLogin);
                                finish();

                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                progressDialog.dismiss();
                                Toast.makeText(ForgotPassword_Activity.this, "Failed to send password reset email: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });

        binding.goToLoginActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ForgotPassword_Activity.this, Login_Activity.class));
                finish();
            }
        });
    }

}
