package com.example.finalyearproject.java;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.finalyearproject.My_Booking_Opreation.MyBookingAdapter;
import com.example.finalyearproject.My_Booking_Opreation.MyBookingModel;
import com.example.finalyearproject.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MyBookingFragment extends Fragment {

    private RecyclerView recyclerTrainTicket;
     RelativeLayout relativeLayout;
    private List<MyBookingModel> myBookingModelList;
    private DatabaseReference databaseReference;
    private MyBookingAdapter myBookingAdapter;
    private SearchView TrainTicketeSearch;

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_my_booking, container, false);

        recyclerTrainTicket = rootView.findViewById(R.id.recyclerTicketName);
        relativeLayout = rootView.findViewById(R.id.relativeLayout);
        TrainTicketeSearch = rootView.findViewById(R.id.TicketNameSearch);

        databaseReference = FirebaseDatabase.getInstance().getReference().child("User_NormalTickets");
        myBookingModelList = new ArrayList<>();
        myBookingAdapter = new MyBookingAdapter(myBookingModelList, getContext());

        recyclerTrainTicket.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerTrainTicket.setAdapter(myBookingAdapter);

        TrainTicketeSearch.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterList(newText);
                return true;
            }
        });

        fetchMyBookingModelData();

        return rootView;
    }

    private void fetchMyBookingModelData() {
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                myBookingModelList.clear();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    MyBookingModel myBookingModel = snapshot.getValue(MyBookingModel.class);
                    if (myBookingModel != null) {
                        myBookingModelList.add(myBookingModel);
                    }
                }
                myBookingAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // Handle database error
                Toast.makeText(getActivity(), "Failed to fetch booking data: " + databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void filterList(String text) {
        List<MyBookingModel> filteredList = new ArrayList<>();
        for (MyBookingModel booking : myBookingModelList) {
            if (booking.getTicketTo().toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(booking);
            }
        }
        if (filteredList.isEmpty()) {
            Toast.makeText(getActivity(), "No matching bookings found", Toast.LENGTH_SHORT).show();
        }
        myBookingAdapter.setFilteredList(filteredList);
    }
}
