package com.example.finalyearproject.java;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.finalyearproject.R;

public class PlatformTicketFragment extends Fragment {

    AutoCompleteTextView platformAutoCompleteTextView;

    CheckBox checkbox1, checkbox2, checkbox3, checkbox4;
    CheckBox lastCheckedCheckbox = null;

    public PlatformTicketFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_platform_ticket, container, false);

        // Initialize AutoCompleteTextView
        platformAutoCompleteTextView = view.findViewById(R.id.searchbar2);
        setupAutoCompleteTextView();

        // Initialize checkboxes
        checkbox1 = view.findViewById(R.id.C1);
        checkbox2 = view.findViewById(R.id.C2);
        checkbox3 = view.findViewById(R.id.C3);
        checkbox4 = view.findViewById(R.id.C4);

        // Set click listeners for checkboxes
        checkbox1.setOnClickListener(ticketCountListener);
        checkbox2.setOnClickListener(ticketCountListener);
        checkbox3.setOnClickListener(ticketCountListener);
        checkbox4.setOnClickListener(ticketCountListener);

        return view;
    }

    private void setupAutoCompleteTextView() {
        // Sample platform names
        String[] platforms = {"Chhatrapati Shivaji Maharaj Terminus (CSMT)", "Masjid Bunder", "Sandhurst Road", "Dockyard Road", "Reay Road",
                "Cotton Green",
                "Sewri",
                "Wadala Road",
                "Guru Tegh Bahadur Nagar (GTBN)",
                "Chunabhatti",
                "Kurla",
                "Tilak Nagar",
                "Chembur",
                "Govandi",
                "Mankhurd",
                "Vashi",
                "Sanpada",
                "Juinagar",
                "Nerul",
                "Seawoods–Darave",
                "CBD Belapur",
                "Kharghar",
                "Mansarovar",
                "Khandeshwar",
                "Panvel",
                "Churchgate",
                "Marine Lines",
                "Charni Road",
                "Grant Road",
                "Mumbai Central",
                "Lower Parel",
                "Mahalaxmi",
                "Elphinstone Road",
                "Dadar",
                "Matunga Road",
                "Mahim",
                "Bandra",
                "Khar Road",
                "Santacruz",
                "Vile Parle",
                "Andheri",
                "Jogeshwari",
                "Ram Mandir",
                "Goregaon",
                "Malad",
                "Kandivali",
                "Borivali",
                "Dahisar",
                "Mira Road",
                "Bhayandar",
                "Naigaon",
                "Vasai Road",
                "Nallasopara",
                "Virar",
                "Byculla",
                "Chinchpokli",
                "Currey Road",
                "Parel",
                "Dadar",
                "Matunga",
                "Sion",
                "Kurla",
                "Vidyavihar",
                "Ghatkopar",
                "Vikhroli",
                "Kanjurmarg",
                "Bhandup",
                "Nahur",
                "Mulund",
                "Thane",
                "Diva Junction",
                "Mumbra",
                "Kalwa",
                "Thakurli",
                "Dombivli",
                "Kopar",
                "kalyan",
                "Shahad",
                "Ambivli",
                "Titwala",
                "Khadavli",
                "Vasind",
                "Asangaon",
                "Atgaon",
                "Khardi",
                "Kasara",
                "Sheelar",
                "Neral",
                "Bhivpuri Road",
                "Karjat",
                "Shahad",
                "Ambivli",
                "Titwala",
                "Khadavli",
                "Vasind",
                "Asangaon",
                "Atgaon",
                "Khardi",
                "Kasara"};
        ArrayAdapter<String> platformAdapter = new ArrayAdapter<>(requireContext(),
                android.R.layout.simple_dropdown_item_1line, platforms);
        platformAutoCompleteTextView.setAdapter(platformAdapter);
    }

    private final View.OnClickListener ticketCountListener = v -> {
        CheckBox clickedCheckbox = (CheckBox) v;
        boolean isChecked = clickedCheckbox.isChecked();
        int count = getCheckBoxValue(clickedCheckbox);
        handleCheckboxChecked(isChecked, clickedCheckbox);
    };

    private void handleCheckboxChecked(boolean isChecked, CheckBox clickedCheckbox) {
        if (isChecked) {
            if (lastCheckedCheckbox != null) {
                // Uncheck the previously checked checkbox
                lastCheckedCheckbox.setChecked(false);
            }
            lastCheckedCheckbox = clickedCheckbox;
        } else {
            if (lastCheckedCheckbox != null && lastCheckedCheckbox == clickedCheckbox) {
                lastCheckedCheckbox = null;
            }
        }
    }

    private int getCheckBoxValue(CheckBox checkBox) {
        int checkBoxId = checkBox.getId();
        if (checkBoxId == R.id.C1) {
            return 1;
        } else if (checkBoxId == R.id.C2) {
            return 2;
        } else if (checkBoxId == R.id.C3) {
            return 3;
        } else if (checkBoxId == R.id.C4) {
            return 4;
        } else {
            return 0; // Default value or error handling
        }
    }


}
