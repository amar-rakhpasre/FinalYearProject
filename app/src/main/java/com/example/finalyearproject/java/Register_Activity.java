package com.example.finalyearproject.java;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.finalyearproject.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;

public class Register_Activity extends AppCompatActivity {

    EditText signupName, signupNumber, signupEmail, signupPassword;
    TextView goToLoginActivity;
    Button signupButton;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    FirebaseFirestore firestoreDB;
    FirebaseAuth firebaseAuth;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        signupName = findViewById(R.id.userName);
        signupEmail = findViewById(R.id.emailAddress);
        signupNumber = findViewById(R.id.phoneNumber);
        signupPassword = findViewById(R.id.password);
        signupButton = findViewById(R.id.signup);
        goToLoginActivity = findViewById(R.id.goToLoginActivity);

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("users");
        firestoreDB = FirebaseFirestore.getInstance();
        firebaseAuth = FirebaseAuth.getInstance();

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Signing up...");
        progressDialog.setCancelable(false);

        // Set up touch listener for non-text box views to hide keyboard
        findViewById(R.id.Signup_sceren).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                hideKeyboard(view); // Hide keyboard when user taps outside EditText fields
                return false;
            }
        });

        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = signupName.getText().toString().trim();
                String email = signupEmail.getText().toString().trim();
                String number = signupNumber.getText().toString().trim();
                String password = signupPassword.getText().toString();

                if (name.isEmpty() || email.isEmpty() || number.isEmpty() || password.isEmpty()) {
                    Toast.makeText(Register_Activity.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
                    return;
                }

                progressDialog.show(); // Show progress dialog

                // Register user in Firebase Authentication
                firebaseAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(Register_Activity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                progressDialog.dismiss(); // Dismiss progress dialog
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
                                    UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder()
                                            .setDisplayName(name)
                                            .build();
                                    firebaseAuth.getCurrentUser().updateProfile(profileUpdates);

                                    // Save user data to Firebase Realtime Database
                                    String userId = firebaseAuth.getCurrentUser().getUid();
                                    UserModel newUser = new UserModel(name, email, number, password);
                                    newUser.setIsUser(1); // Set isUser to 1
                                    databaseReference.child(userId).setValue(newUser);

                                    // Save user data to Firebase Firestore
                                    firestoreDB.collection("users").document(userId).set(newUser);

                                    Toast.makeText(Register_Activity.this, "You have signed up successfully!", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(Register_Activity.this, Login_Activity.class);
                                    startActivity(intent);
                                    finish(); // Finish the current activity
                                } else {
                                    // If sign in fails, display a message to the user.
                                    Toast.makeText(Register_Activity.this, "Authentication failed: " + task.getException().getMessage(),
                                            Toast.LENGTH_SHORT).show();
                                }
                            }
                        });

            }
        });

        goToLoginActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Register_Activity.this, Login_Activity.class);
                startActivity(intent);
            }
        });
    }

    private void hideKeyboard(View view) {
        InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        IBinder windowToken = view.getWindowToken();
        if (windowToken != null) {
            imm.hideSoftInputFromWindow(windowToken, 0);
        }
    }
}
