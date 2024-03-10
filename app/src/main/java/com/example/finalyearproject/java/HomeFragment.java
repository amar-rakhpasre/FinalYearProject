package com.example.finalyearproject.java;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.finalyearproject.R;

public class HomeFragment extends Fragment {

    CardView HomeUsingMap;
    CardView HomeFastBooking;
    CardView HomePlatformTicket;
    CardView HomeMyBooking;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        HomeUsingMap = view.findViewById(R.id.HomeUsingMap);
        HomeFastBooking = view.findViewById(R.id.HomeFastBooking);
        HomePlatformTicket = view.findViewById(R.id.HomePlatformTicket);
        HomeMyBooking = view.findViewById(R.id.HomeMyBooking);

        // Set click listener for HomeUsingMap
        HomeUsingMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create an instance of the fragment to navigate to
                Fragment homeUsingMapFragment = new UsingMapFragment();

                // Navigate to the new fragment
                navigateToFragment(homeUsingMapFragment);
            }
        });

        // Set click listener for HomeFastBooking
        HomeFastBooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create an instance of the fragment to navigate to
                Fragment fastBookingFragment = new FastBookingFragment();

                // Navigate to the new fragment
                navigateToFragment(fastBookingFragment);
            }
        });

        // Set click listener for HomePlatformTicket
        HomePlatformTicket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create an instance of the fragment to navigate to
                Fragment platformTicketFragment = new PlatformTicketFragment();

                // Navigate to the new fragment
                navigateToFragment(platformTicketFragment);
            }
        });

        // Set click listener for HomeMyBooking
        HomeMyBooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create an instance of the fragment to navigate to
                Fragment bookingHistoryFragment = new MyBookingFragment();

                // Navigate to the new fragment
                navigateToFragment(bookingHistoryFragment);
            }
        });

        // Return the inflated view
        return view;
    }

    // Method to navigate to a new fragment
    private void navigateToFragment(Fragment fragment) {
        // Get the FragmentManager
        FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();

        // Start a fragment transaction
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        // Replace the current fragment with the new one
        fragmentTransaction.replace(R.id.frame_layout, fragment);

        // Add the transaction to the back stack
        fragmentTransaction.addToBackStack(null);

        // Commit the transaction
        fragmentTransaction.commit();
    }
}

