package com.example.finalyearproject.java;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalyearproject.R;
import com.example.finalyearproject.SudoOperation.Schedule;
import com.example.finalyearproject.SudoOperation.ScheduleAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class VoiceCommandFragment extends Fragment {

    private RecyclerView recyclerTrainSchedule;
    public RelativeLayout relativeLayout;
    private List<Schedule> scheduleList;
    private DatabaseReference databaseReference;
    private ScheduleAdapter scheduleAdapter;
    SearchView TrainScheduleSearch;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_voice_command, container, false);

        recyclerTrainSchedule = rootView.findViewById(R.id.recyclerTrainSchedule);
        relativeLayout = rootView.findViewById(R.id.relativeLayout);

        databaseReference = FirebaseDatabase.getInstance().getReference().child("Train Schedule");

        scheduleList = new ArrayList<>();
        scheduleAdapter = new ScheduleAdapter(scheduleList, getContext());
        recyclerTrainSchedule.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerTrainSchedule.setAdapter(scheduleAdapter);


        TrainScheduleSearch = rootView.findViewById(R.id.TrainScheduleSearch);
        TrainScheduleSearch.clearFocus();
        TrainScheduleSearch.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filteredLIst(newText);
                return true;
            }
        });


        fetchScheduleData();

        return rootView;
    }

    private void fetchScheduleData() {
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                scheduleList.clear();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    Schedule schedule = snapshot.getValue(Schedule.class);
                    if (schedule != null) {
                        scheduleList.add(schedule);
                    }
                }
                scheduleAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // Handle database error
            }
        });
    }

    private void filteredLIst(String text) {
        List<Schedule> filteredLIst = new ArrayList<>();
        for (Schedule schedule : scheduleList){
            if (schedule.getTo().toLowerCase().contains(text.toLowerCase())){
                filteredLIst.add(schedule);
            }
        }
        if (filteredLIst.isEmpty()) {
            Toast.makeText(getActivity(), "No matching stations found", Toast.LENGTH_SHORT).show();
        } else {
            scheduleAdapter.setFilteredLIst(filteredLIst);
        }
    }
}
