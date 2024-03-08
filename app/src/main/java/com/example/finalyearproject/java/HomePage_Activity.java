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

public class HomePage_Activity extends AppCompatActivity  {

    ActivityHomePageBinding binding;
    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomePageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        replaceFragment(new HomeFragment());
        binding.bottomNavigationView.setBackground(null);

        binding.bottomNavigationView.setOnItemSelectedListener(item -> {
            int itemId = item.getItemId(); // Get the ID once

            if (itemId == R.id.navHome) {
                replaceFragment(new HomeFragment());
            } else if (itemId == R.id.navBooking) {
                replaceFragment(new MyBookingFragment());
            } else if (itemId == R.id.navVoiceCommand) {
                replaceFragment(new VoiceCommandFragment());
            } else if (itemId == R.id.navInBox) {
                replaceFragment(new InboxFragment());
            } else if (itemId == R.id.navProfile) {
                replaceFragment(new ProfileFragment());
            }
            return true;
        });

    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.commit();
    }
}
