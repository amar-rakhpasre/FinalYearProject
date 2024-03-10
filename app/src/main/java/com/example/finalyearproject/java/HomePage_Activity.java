package com.example.finalyearproject.java;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.example.finalyearproject.R;
import com.example.finalyearproject.databinding.ActivityHomePageBinding;

interface FragmentNavigationListener {
    void navigateTo(Fragment fragment);
}

public class HomePage_Activity extends AppCompatActivity implements FragmentNavigationListener {

    ActivityHomePageBinding binding;

    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomePageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

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
