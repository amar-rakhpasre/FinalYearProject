package com.example.finalyearproject.java;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.finalyearproject.R;
import com.example.finalyearproject.SudoOperation.SudoActivity;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Objects;

public class Login_Activity extends AppCompatActivity {

    EditText loginUserEmail, loginPassword;
    Button loginButton;
    TextView signupRedirectText, forgotPassword;

    FirebaseAuth firebaseAuth;
    FirebaseFirestore  firebaseFirestore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginUserEmail = findViewById(R.id.emailAddress);
        loginPassword = findViewById(R.id.password);
        loginButton = findViewById(R.id.login);
        signupRedirectText = findViewById(R.id.goToSignUpActivity);
        forgotPassword = findViewById(R.id.forgotPassword);

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseFirestore = FirebaseFirestore.getInstance();

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!validateUsername() | !validatePassword()) {

                } else {
                    checkUser();
                }
            }
        });


        // Set up touch listener for non-text box views to hide keyboard
        findViewById(R.id.Login_screen).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                hideKeyboard(view); // Hide keyboard when user taps outside EditText fields
                return false;
            }
        });

        signupRedirectText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login_Activity.this, Register_Activity.class);
                startActivity(intent);
            }
        });

        forgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login_Activity.this, ForgotPassword_Activity.class);
                startActivity(intent);
            }
        });

    }

    public Boolean validateUsername() {
        String val = loginUserEmail.getText().toString();
        if (val.isEmpty()) {
            loginUserEmail.setError("Username cannot be empty");
            return false;
        } else {
            loginUserEmail.setError(null);
            return true;
        }
    }

    public Boolean validatePassword(){
        String val = loginPassword.getText().toString();
        if (val.isEmpty()) {
            loginPassword.setError("Password cannot be empty");
            return false;
        } else {
            loginPassword.setError(null);
            return true;
        }
    }


    public void loginUser() {
        String userEmail = loginUserEmail.getText().toString().trim();
        String userPassword = loginPassword.getText().toString().trim();

        if (!validateUsername() || !validatePassword()) {
            return;
        }

        ProgressDialog progressDialog = new ProgressDialog(Login_Activity.this);
        progressDialog.setMessage("Logging in...");
        progressDialog.setCancelable(false);
        progressDialog.show();

        firebaseAuth.signInWithEmailAndPassword(userEmail, userPassword)
                .addOnSuccessListener(authResult -> {
                    FirebaseUser currentUser = firebaseAuth.getCurrentUser();
                    if (currentUser != null) {
                        DatabaseReference usersRef = FirebaseDatabase.getInstance().getReference("users").child(currentUser.getUid());
                        usersRef.addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot snapshot) {
                                progressDialog.dismiss();
                                if (snapshot.exists()) {
                                    UserModel user = snapshot.getValue(UserModel.class);
                                    Log.d("UserModel", "isAdmin: " + user.getIsAdmin()); // Debug log
                                    if (user != null && user.getPassword().equals(userPassword)) {
                                        loginUserEmail.setError(null);

                                        Intent intent;
                                        Integer isAdmin = snapshot.child("isAdmin").getValue(Integer.class);
                                        if (isAdmin != null && isAdmin == 1) {
                                            // Admin user, redirect to SudoActivity
                                            intent = new Intent(Login_Activity.this, SudoActivity.class);
                                        } else {
                                            // Regular user, redirect to HomePage_Activity
                                            intent = new Intent(Login_Activity.this, HomePage_Activity.class);
                                            // Pass user data to the next activity if needed
                                            intent.putExtra("name", user.getName());
                                            intent.putExtra("email", user.getEmail());
                                            intent.putExtra("number", user.getNumber());
                                            intent.putExtra("password", user.getPassword());
                                        }

                                        Toast.makeText(Login_Activity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                                        startActivity(intent);
                                        finish(); // Finish the current activity
                                    } else {
                                        // Incorrect password
                                        loginPassword.setError("Invalid Credentials");
                                        loginPassword.requestFocus();
                                    }
                                } else {
                                    // User does not exist
                                    loginUserEmail.setError("User does not exist");
                                    loginUserEmail.requestFocus();
                                }
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError error) {
                                progressDialog.dismiss();
                                Toast.makeText(Login_Activity.this, "Database Error: " + error.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                })
                .addOnFailureListener(e -> {
                    progressDialog.dismiss();
                    Toast.makeText(Login_Activity.this, "Login failed. " + e.getMessage(), Toast.LENGTH_SHORT).show();
                });
    }


    public void checkUser() {
        // Move the code from checkUser() method here if you still need to check additional user information before login
        loginUser();
    }


    private void hideKeyboard(View view) {
        InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        IBinder windowToken = view.getWindowToken();
        if (windowToken != null) {
            imm.hideSoftInputFromWindow(windowToken, 0);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser currentUser = firebaseAuth.getCurrentUser();
        if (currentUser != null) {
            DatabaseReference usersRef = FirebaseDatabase.getInstance().getReference("users").child(currentUser.getUid());
            usersRef.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    if (snapshot.exists()) {
                        UserModel user = snapshot.getValue(UserModel.class);
                        if (user != null) {
                            if (user.getIsAdmin() == 1) {
                                // Admin user, redirect to SudoActivity
                                Toast.makeText(Login_Activity.this, "You're already Login", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(Login_Activity.this, SudoActivity.class);
                                startActivity(intent);
                            } else {
                                // Regular user, redirect to HomePage_Activity
                                Toast.makeText(Login_Activity.this, "You're already Login", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(Login_Activity.this, HomePage_Activity.class);
                                intent.putExtra("name", user.getName());
                                intent.putExtra("email", user.getEmail());
                                intent.putExtra("number", user.getNumber());
                                intent.putExtra("password", user.getPassword());
                                startActivity(intent);
                            }
                            finish(); // Finish the current activity
                        } else {
                            // User data not found, handle the error
                            Toast.makeText(Login_Activity.this, "User data not found", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        // Snapshot doesn't exist, handle the error
                        Toast.makeText(Login_Activity.this, "User data snapshot does not exist", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                    // Handle database error if needed
                    Toast.makeText(Login_Activity.this, "Database Error: " + error.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

}