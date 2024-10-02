package com.example.finalyearproject.java;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.finalyearproject.R;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class ProfileFragment extends Fragment {

    TextView profileName, profileEmail, profileNumber, profilePassword;
    TextView titleName;
    Button  LogoutButton;

    
    @SuppressLint("MissingInflatedId")
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_profile, container, false);

        profileName = root.findViewById(R.id.profileName);
        profileEmail = root.findViewById(R.id.profileEmail);
        profileNumber = root.findViewById(R.id.profileNumber);
        profilePassword = root.findViewById(R.id.profilePassword);
        titleName = root.findViewById(R.id.titleName);

//        editProfile = root.findViewById(R.id.editProfile);
        LogoutButton = root.findViewById(R.id.LogoutButton);

        showAllUserData();

//        editProfile.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(getContext(), "Under development", Toast.LENGTH_SHORT).show();
//                passUserData();
//            }
//        });

        // Set click listener for logout button
        LogoutButton.setOnClickListener(v -> {
            // Handle logout button click, e.g., sign out the user
            FirebaseAuth.getInstance().signOut();
            startActivity(new Intent(requireContext(), Login_Activity.class));
            requireActivity().finish(); // Close the current activity
        });

        return root;
    }

    public void showAllUserData(){
        // Access data from parent Activity or ViewModel as needed
        // For example:
         String nameUser = getActivity().getIntent().getStringExtra("name");
         String emailUser = getActivity().getIntent().getStringExtra("email");
         String usernameNumber = getActivity().getIntent().getStringExtra("number");
         String passwordUser = getActivity().getIntent().getStringExtra("password");

//        // For demonstration purposes, let's assume you have received data from the parent Activity
//
//        String nameUser = "John Doe";
//        String emailUser = "johndoe@example.com";
//        String usernameNumber = "6969696969";
//        String passwordUser = "password123";

        titleName.setText(nameUser);
        profileName.setText(nameUser);
        profileEmail.setText(emailUser);
        profileNumber.setText(usernameNumber);
        profilePassword.setText(passwordUser);
    }

    public void passUserData(){
        String userId = profileName.getText().toString().trim();

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("users");
        Query checkUserDatabase = reference.orderByChild("username").equalTo(userId);

        checkUserDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()){
                    String nameFromDB = snapshot.child(userId).child("name").getValue(String.class);
                    String emailFromDB = snapshot.child(userId).child("email").getValue(String.class);
                    String usernameFromDB = snapshot.child(userId).child("username").getValue(String.class);
                    String passwordFromDB = snapshot.child(userId).child("password").getValue(String.class);

                    Intent intent = new Intent(getActivity(), ProfileFragment.class);
                    intent.putExtra("name", nameFromDB);
                    intent.putExtra("email", emailFromDB);
                    intent.putExtra("username", usernameFromDB);
                    intent.putExtra("password", passwordFromDB);
                    startActivity(intent);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Handle onCancelled event if needed
            }
        });
    }
}
