package com.example.finalyearproject.java;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.example.finalyearproject.R;

public class FastBookingFragment extends Fragment {
    RelativeLayout RelativeLayout;

    public FastBookingFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fast_booking, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Find image views
        RelativeLayout westernLineLayout = view.findViewById(R.id.westernLineStationImage);
        RelativeLayout centralLineLayout = view.findViewById(R.id.centralLineStationImage);
        RelativeLayout harbourLineLayout = view.findViewById(R.id.harbourLineStationImage);

// Set click listeners
        westernLineLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToActivity(WesternLineStationActivity.class);
            }
        });

        centralLineLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToActivity(CentralLineStationActivity.class);
            }
        });

        harbourLineLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToActivity(HarbourLineStationActivity.class);
            }
        });
    }

        private void navigateToActivity(Class<?> cls) {
        Intent intent = new Intent(getActivity(), cls);
        startActivity(intent);
    }

}
