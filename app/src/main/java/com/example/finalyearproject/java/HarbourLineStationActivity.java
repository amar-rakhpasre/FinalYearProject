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

public class HarbourLineStationActivity extends AppCompatActivity {

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



//        // Create sample station data
//        ticketModelList = new ArrayList<>();
//        ticketModelList.add(new TicketModel("Second", "ORDINARY", 1, 0, "2024-02-17", 123456, "Churchgate Station", "3 HOUR", 10, "(CSMT) Station", "Harbor Line"));
//        ticketModelList.add(new TicketModel("Second", "ORDINARY", 1, 0, "2024-02-17", 123457, "Marine Lines Station", "3 HOUR", 10, "Masjid Bunder Station", "Harbor Line"));
//        ticketModelList.add(new TicketModel("Second", "ORDINARY", 1, 0, "2024-02-17", 123458, "Charni Road Station", "3 HOUR", 10, "Sandhurst Road Station", "Harbor Line"));
//        ticketModelList.add(new TicketModel("Second", "ORDINARY", 1, 0, "2024-02-17", 123459, "Grant Road Station", "3 HOUR", 10, "Dockyard Road Station", "Harbor Line"));
//        ticketModelList.add(new TicketModel("Second", "ORDINARY", 1, 0, "2024-02-17", 123459, "Grant Road Station", "3 HOUR", 10, "Reay Road Station", "Harbor Line"));
//        ticketModelList.add(new TicketModel("Second", "ORDINARY", 1, 0, "2024-02-17", 123459, "Grant Road Station", "3 HOUR", 10, "Cotton Green Station", "Harbor Line"));
//        ticketModelList.add(new TicketModel("Second", "ORDINARY", 1, 0, "2024-02-17", 123459, "Grant Road Station", "3 HOUR", 10, "Sewri Station", "Harbor Line"));
//        ticketModelList.add(new TicketModel("Second", "ORDINARY", 1, 0, "2024-02-17", 123459, "Grant Road Station", "3 HOUR", 10, "Wadala Station", "Harbor Line"));
//        ticketModelList.add(new TicketModel("Second", "ORDINARY", 1, 0, "2024-02-17", 123459, "Grant Road Station", "3 HOUR", 10, "(GTBN) Station", "Harbor Line"));
//        ticketModelList.add(new TicketModel("Second", "ORDINARY", 1, 0, "2024-02-17", 123459, "Grant Road Station", "3 HOUR", 10, "Chembur Station", "Harbor Line"));
//        // Add more stations as needed

        returnTicketModelsList = new ArrayList<>();
        returnTicketModelsList.add(new ReturnTicketModel("Second", "ORDINARY", 1, 0, "2024-02-17", 123456, "Churchgate Station", "24 HOUR", 20, "(CSMT) Station", "Harbor Line"));
        returnTicketModelsList.add(new ReturnTicketModel("Second", "ORDINARY", 1, 0, "2024-02-17", 123457, "Marine Lines Station", "24 HOUR", 20, "Masjid Bunder Station", "Harbor Line"));
        returnTicketModelsList.add(new ReturnTicketModel("Second", "ORDINARY", 1, 0, "2024-02-17", 123458, "Charni Road Station", "24 HOUR", 20, "Sandhurst Road Station", "Harbor Line"));
        returnTicketModelsList.add(new ReturnTicketModel("Second", "ORDINARY", 1, 0, "2024-02-17", 123459, "Grant Road Station", "24 HOUR", 20, "Dockyard Road Station", "Harbor Line"));
        returnTicketModelsList.add(new ReturnTicketModel("Second", "ORDINARY", 1, 0, "2024-02-17", 123459, "Grant Road Station", "24 HOUR", 20, "Reay Road Station", "Harbor Line"));
        returnTicketModelsList.add(new ReturnTicketModel("Second", "ORDINARY", 1, 0, "2024-02-17", 123459, "Grant Road Station", "24 HOUR", 20, "Cotton Green Station", "Harbor Line"));
        returnTicketModelsList.add(new ReturnTicketModel("Second", "ORDINARY", 1, 0, "2024-02-17", 123459, "Grant Road Station", "24 HOUR", 20, "Sewri Station", "Harbor Line"));
        returnTicketModelsList.add(new ReturnTicketModel("Second", "ORDINARY", 1, 0, "2024-02-17", 123459, "Grant Road Station", "24 HOUR", 20, "Wadala Station", "Harbor Line"));
        returnTicketModelsList.add(new ReturnTicketModel("Second", "ORDINARY", 1, 0, "2024-02-17", 123459, "Mumbai", "24 HOUR", 20, "(GTBN) Station", "Harbor Line"));
        returnTicketModelsList.add(new ReturnTicketModel("Second", "ORDINARY", 1, 0, "2024-02-17", 123459, "Mumbai", "24 HOUR", 20, "Chembur Road Station", "Harbor Line"));

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



