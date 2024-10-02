package com.example.finalyearproject.java;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.finalyearproject.R;
import com.example.finalyearproject.databinding.ActivityHomePageBinding;

interface FragmentNavigationListener {
    void navigateTo(Fragment fragment);
}

public class HomePage_Activity extends AppCompatActivity implements FragmentNavigationListener {
    ActivityHomePageBinding binding;
    public String userName, userNumber, userEmail, userPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomePageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Get user data from intent
        // Inside onCreate or wherever you get the user data
//        if (getIntent().hasExtra("user")) {
//            UserModel user = (UserModel) getIntent().getSerializableExtra("user");
//            if (user != null) {
//                // Pass user data to ProfileFragment
////                ProfileFragment profileFragment = ProfileFragment.newInstance(user.getName(), user.getNumber(), user.getEmail(), user.getPassword());
////                navigateTo(profileFragment);
//            }
//        }

        binding.bottomNavigationView.setBackground(null);
        binding.bottomNavigationView.setOnItemSelectedListener(item -> {
            int itemId = item.getItemId(); // Get the ID once

            if (itemId == R.id.navHome) {
                navigateTo(new HomeFragment());
            } else if (itemId == R.id.navBooking) {
                navigateTo(new BookingHistoryFragment());
            } else if (itemId == R.id.navVoiceCommand) {
                navigateTo(new VoiceCommandFragment());
            } else if (itemId == R.id.navInBox) {
                navigateTo(new InboxFragment());
            } else if (itemId == R.id.navProfile) {
                // Pass user data to ProfileFragment
//                ProfileFragment profileFragment = ProfileFragment.newInstance(userName, userNumber, userEmail, userPassword);
                navigateTo(new ProfileFragment());
            }
            return true;
        });

        // Initially, replace with HomeFragment
        navigateTo(new HomeFragment());
    }

    public void navigateTo(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.commit();
    }
}
