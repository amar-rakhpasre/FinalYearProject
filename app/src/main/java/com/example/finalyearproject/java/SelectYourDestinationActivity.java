package com.example.finalyearproject.java;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.finalyearproject.R;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SelectYourDestinationActivity  {
//    private RecyclerView recyclerView;
//    private DatabaseReference databaseRef;
//    private StationMapModelAdapter adapter;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_select_your_destination);
//
//        recyclerView = findViewById(R.id.recyclerSlectedStationName);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//
//        databaseRef = FirebaseDatabase.getInstance().getReference().child("MumbaiMapZoon");
//        FirebaseRecyclerOptions<StationMapModel> options = new FirebaseRecyclerOptions.Builder<StationMapModel>()
//                .setQuery(databaseRef, StationMapModel.class)
//                .build();
//
//        adapter = new StationMapModelAdapter(options, this); // Pass the activity as the listener
//        recyclerView.setAdapter(adapter);
//    }
//
//    @Override
//    protected void onStart() {
//        super.onStart();
//        adapter.startListening();
//    }
//
//    @Override
//    protected void onStop() {
//        super.onStop();
//        adapter.stopListening();
//    }
//
//    // Implement the onItemClick method from the adapter's listener interface
//    @Override
//    public void onItemClick(StationMapModel item) {
//        // Handle item click, for example, start a new activity with item details
//        Intent intent = new Intent(this, ChangeJourneyDetileActivity.class);
//        intent.putExtra("stationName", item.getStationName());
//        startActivity(intent);
//    }
}
