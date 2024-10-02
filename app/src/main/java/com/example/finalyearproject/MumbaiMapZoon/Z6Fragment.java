package com.example.finalyearproject.MumbaiMapZoon;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.finalyearproject.R;
import com.example.finalyearproject.java.MapChangeJourneyActivity;
import com.example.finalyearproject.java.StationMapModel;
import com.example.finalyearproject.java.StationMapModelAdapter;
import java.util.ArrayList;
import java.util.List;

public class Z6Fragment extends Fragment implements StationMapModelAdapter.OnItemClickListener {

    private static final String TAG = "Z6Fragment";

    RecyclerView recyclerView;
    List<StationMapModel> stationList;
    SearchView StationMapNameSearch;
    StationMapModelAdapter stationAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_z1, container, false);
        recyclerView = view.findViewById(R.id.recyclerMapStationName);

        StationMapNameSearch = view.findViewById(R.id.StationMapNameSearch);
        StationMapNameSearch.clearFocus();
        StationMapNameSearch.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
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

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        loadStationData();
        return view;
    }

    private void loadStationData() {
        stationList = new ArrayList<>();
        // Add sample station data
        stationList.add(new StationMapModel("Mumbai Central"));
        stationList.add(new StationMapModel("mahalaxmi"));
        stationList.add(new StationMapModel("Lower Parel"));
        stationList.add(new StationMapModel("Prabhadevi"));
        stationList.add(new StationMapModel("Dadar"));
        stationList.add(new StationMapModel("Matunga Road"));
        // Add more stations as needed

        Log.d(TAG, "loadStationData: Station count: " + stationList.size()); // Debug log
        stationAdapter = new StationMapModelAdapter(getActivity(), stationList, this);
        recyclerView.setAdapter(stationAdapter);
    }

    @Override
    public void onItemClick(StationMapModel item) {
        // Handle item click here, for example, show details or navigate to another fragment/activity
        // You can access the clicked item's data using the 'item' parameter
        Log.d(TAG, "onItemClick: Clicked item: " + item.getStationName()); // Debug log

        // Redirect to ChangeJourneyActivity and pass the clicked station name
        Intent intent = new Intent(getActivity(), MapChangeJourneyActivity.class);
        intent.putExtra("stationName", item.getStationName());
        startActivity(intent);
    }
    private void filteredLIst(String text) {
        List<StationMapModel> filteredLIst = new ArrayList<>();
        for (StationMapModel stationMapModel : stationList){
            if (stationMapModel.getStationName().toLowerCase().contains(text.toLowerCase())){
                filteredLIst.add(stationMapModel);
            }
        }
        if (filteredLIst.isEmpty()) {
            Toast.makeText(getActivity(), "No matching stations found", Toast.LENGTH_SHORT).show();
        } else {
            stationAdapter.setFilteredLIst(filteredLIst);
        }
    }
}
