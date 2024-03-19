package com.example.finalyearproject.java;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.finalyearproject.R;
import com.example.finalyearproject.databinding.ActivityLoginBinding;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class Login_Activity extends AppCompatActivity {
    private static final String TAG = "Login_Activity";

    private ActivityLoginBinding binding;
    private FirebaseAuth firebaseAuth;
    private FirebaseFirestore firebaseFirestore;
    private ProgressDialog progressDialog;
    private Intent nextHomepage;
    private Intent nextResetPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseFirestore = FirebaseFirestore.getInstance();
        progressDialog = new ProgressDialog(this);
        nextHomepage = new Intent(Login_Activity.this, HomePage_Activity.class);
        nextResetPassword = new Intent(Login_Activity.this, ForgotPassword_Activity.class);

        binding.login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginUser();
            }
        });

        binding.forgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(nextResetPassword);
                finish();
            }
        });

        binding.goToSignUpActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Login_Activity.this, Register_Activity.class));
                finish();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        // Check if user is already logged in
        FirebaseUser currentUser = firebaseAuth.getCurrentUser();
        if (currentUser != null) {
            startActivity(nextHomepage);
            finish(); // Prevent going back to the login activity using the back button
        }
    }

    private void loginUser() {
        String email = binding.emailAddress.getText().toString().trim();
        String password = binding.password.getText().toString();
        progressDialog.setMessage("Logging in...");
        progressDialog.show();

        firebaseAuth.signInWithEmailAndPassword(email, password)
                .addOnSuccessListener(this, authResult -> {
                    progressDialog.dismiss();
                    Toast.makeText(Login_Activity.this, "Login successful", Toast.LENGTH_SHORT).show();
                    checkUser(authResult.getUser().getUid());
                    startActivity(nextHomepage);
                    finish();
                })
                .addOnFailureListener(this, e -> {
                    progressDialog.dismiss();
                    Toast.makeText(Login_Activity.this, "Login failed: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                });
    }

    private void checkUser(String uid) {
        DocumentReference df = firebaseFirestore.collection("Users").document(uid);
        df.get().addOnSuccessListener(this, documentSnapshot -> {
            if (documentSnapshot.exists() && documentSnapshot.getString("isUser") != null) {
                startActivity(nextHomepage);
                finish();
            }
        }).addOnFailureListener(this, e -> {
            Log.e(TAG, "Error checking user: " + e.getMessage());
        });
    }
}
