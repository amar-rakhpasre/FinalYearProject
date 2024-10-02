package com.example.finalyearproject.java;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalyearproject.R;

import java.util.ArrayList;
import java.util.List;

public class CentralLineStationActivity extends AppCompatActivity {

    RecyclerView recyclerView;
//    List<TicketModel> ticketModelList;
    List<ReturnTicketModel> returnTicketModelsList;
//    MyAdapter myAdapter;
    ReturnTicketAdapter returnTicketAdapter;
    SearchView StationNameSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_western_line_station);

        // Initialize RecyclerView
        recyclerView = findViewById(R.id.recyclerStationName);
        StationNameSearch = findViewById(R.id.StationNameSearch);
        StationNameSearch.clearFocus();
        StationNameSearch.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
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

        recyclerView.setLayoutManager(new LinearLayoutManager(this));



        // Create sample station data
//        ticketModelList = new ArrayList<>();
//        ticketModelList.add(new TicketModel("Second", "ORDINARY", 1, 0, "2024-02-17", 123456, "Churchgate Station", "3 HOUR", 10, "C.S.M.T Station", "Central Line"));
//        ticketModelList.add(new TicketModel("Second", "ORDINARY", 1, 0, "2024-02-17", 123457, "Marine Lines Station", "3 HOUR", 10, "Masjid Bunder Station", "Central Line"));
//        ticketModelList.add(new TicketModel("Second", "ORDINARY", 1, 0, "2024-02-17", 123458, "Charni Road Station", "3 HOUR", 10, "Sandhurst Road Station", "Central Line"));
//        ticketModelList.add(new TicketModel("Second", "ORDINARY", 1, 0, "2024-02-17", 123459, "Grant Road Station", "3 HOUR", 10, "Byculla Station", "Central Line"));
//        ticketModelList.add(new TicketModel("Second", "ORDINARY", 1, 0, "2024-02-17", 123459, "Grant Road Station", "3 HOUR", 10, "Chinchpokli Station", "Central Line"));
//        ticketModelList.add(new TicketModel("Second", "ORDINARY", 1, 0, "2024-02-17", 123459, "Grant Road Station", "3 HOUR", 10, "Currey Road Station", "Central Line"));
//        ticketModelList.add(new TicketModel("Second", "ORDINARY", 1, 0, "2024-02-17", 123459, "Grant Road Station", "3 HOUR", 10, "Parel Station", "Central Line"));
//        ticketModelList.add(new TicketModel("Second", "ORDINARY", 1, 0, "2024-02-17", 123459, "Grant Road Station", "3 HOUR", 10, "Dadar Station", "Central Line"));
//        ticketModelList.add(new TicketModel("Second", "ORDINARY", 1, 0, "2024-02-17", 123459, "Grant Road Station", "3 HOUR", 10, "Matunga Station", "Central Line"));
//        ticketModelList.add(new TicketModel("Second", "ORDINARY", 1, 0, "2024-02-17", 123459, "Grant Road Station", "3 HOUR", 10, "Sion Station", "Central Line"));
//        // Add more stations as needed

        returnTicketModelsList = new ArrayList<>();
        returnTicketModelsList.add(new ReturnTicketModel("Second", "ORDINARY", 1, 0, "2024-02-17", 123456, "Churchgate Station", "24 HOUR", 20, "C.S.M.T Station", "Central Line"));
        returnTicketModelsList.add(new ReturnTicketModel("Second", "ORDINARY", 1, 0, "2024-02-17", 123457, "Marine Lines Station", "24 HOUR", 20, "Masjid Bunder Station", "Central Line"));
        returnTicketModelsList.add(new ReturnTicketModel("Second", "ORDINARY", 1, 0, "2024-02-17", 123458, "Charni Road Station", "24 HOUR", 20, "Sandhurst Road Station", "Central Line"));
        returnTicketModelsList.add(new ReturnTicketModel("Second", "ORDINARY", 1, 0, "2024-02-17", 123459, "Grant Road Station", "24 HOUR", 20, "Byculla Station", "Central Line"));
        returnTicketModelsList.add(new ReturnTicketModel("Second", "ORDINARY", 1, 0, "2024-02-17", 123459, "Grant Road Station", "24 HOUR", 20, "Chinchpokli Station", "Central Line"));
        returnTicketModelsList.add(new ReturnTicketModel("Second", "ORDINARY", 1, 0, "2024-02-17", 123459, "Grant Road Station", "24 HOUR", 20, "Currey Road Station", "Central Line"));
        returnTicketModelsList.add(new ReturnTicketModel("Second", "ORDINARY", 1, 0, "2024-02-17", 123459, "Grant Road Station", "24 HOUR", 20, "Parel Station", "Central Line"));
        returnTicketModelsList.add(new ReturnTicketModel("Second", "ORDINARY", 1, 0, "2024-02-17", 123459, "Grant Road Station", "24 HOUR", 20, "Dadar Station", "Central Line"));
        returnTicketModelsList.add(new ReturnTicketModel("Second", "ORDINARY", 1, 0, "2024-02-17", 123459, "Grant Road Station", "24 HOUR", 20, "Matunga Station", "Central Line"));
        returnTicketModelsList.add(new ReturnTicketModel("Second", "ORDINARY", 1, 0, "2024-02-17", 123459, "Grant Road Station", "24 HOUR", 20, "Sion Station", "Central Line"));

        // Initialize adapter and set it to RecyclerView
//        myAdapter = new MyAdapter(this, ticketModelList);
        returnTicketAdapter = new ReturnTicketAdapter(this, returnTicketModelsList);
//        recyclerView.setAdapter(myAdapter);
        recyclerView.setAdapter(returnTicketAdapter);
    }

    private void filteredLIst(String text) {
        List<ReturnTicketModel> filteredLIst = new ArrayList<>();
        for (ReturnTicketModel returnTicketModel : returnTicketModelsList){
            if (returnTicketModel.getTicket_To().toLowerCase().contains(text.toLowerCase())){
                filteredLIst.add(returnTicketModel);
            }
        }
        if (filteredLIst.isEmpty()){
            Toast.makeText(this, "No Station Found", Toast.LENGTH_SHORT).show();
        } else {
            returnTicketAdapter.setFilteredLIst(filteredLIst);
        }
    }
}


