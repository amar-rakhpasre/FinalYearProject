package com.example.finalyearproject.java;

import static android.content.Context.INPUT_METHOD_SERVICE;
import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.finalyearproject.R;

public class HomeFragment extends Fragment {


    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);


        // Set up touch listener for non-text box views to hide keyboard
        view.findViewById(R.id.fregmant_layout).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                hideKeyboard(view); // Hide keyboard when user taps outside EditText fields
                return false;
            }
        });


        // Setup spinners


        // Setup AutoCompleteTextView
        setupAutoCompleteTextViews(view);

        CardView HomeUsingMap = view.findViewById(R.id.HomeUsingMap);
        CardView HomeFastBooking = view.findViewById(R.id.HomeFastBooking);
        CardView HomePlatformTicket = view.findViewById(R.id.HomePlatformTicket);
        CardView HomeMyBooking = view.findViewById(R.id.HomeMyBooking);

        // Set click listener for HomeUsingMap
        HomeUsingMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create an instance of the fragment to navigate to
                Fragment homeUsingMapFragment = new UsingMapFragment();

                // Navigate to the new fragment
                navigateTo(homeUsingMapFragment);
            }
        });

        // Set click listener for HomeFastBooking
        HomeFastBooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create an instance of the fragment to navigate to
                Fragment fastBookingFragment = new FastBookingFragment();

                // Navigate to the new fragment
                navigateTo(fastBookingFragment);
            }
        });

        // Set click listener for HomePlatformTicket
        HomePlatformTicket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create an instance of the fragment to navigate to
                Fragment platformTicketFragment = new PlatformTicketFragment();

                // Navigate to the new fragment
                navigateTo(platformTicketFragment);
            }
        });

        // Set click listener for HomeMyBooking
        HomeMyBooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create an instance of the fragment to navigate to
                Fragment bookingHistoryFragment = new MyBookingFragment();

                // Navigate to the new fragment
                navigateTo(bookingHistoryFragment);
            }
        });

        Button buttonChangeJourney = view.findViewById(R.id.cjourney);

        if (buttonChangeJourney != null) {
            buttonChangeJourney.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Handle button click action here
                    navigateToChangeJourneyDetailActivity(); // Example method call
                }
            });
        }


        return view;
    }

    // Example method to navigate to ChangeJourneyDetileActivity
    private void navigateToChangeJourneyDetailActivity() {
        AutoCompleteTextView autoCompleteTextView = getView().findViewById(R.id.searchbar1);
        AutoCompleteTextView autoCompleteTextView1 = getView().findViewById(R.id.searchbar2);

        String sourceStation = autoCompleteTextView.getText().toString();
        String destinationStation = autoCompleteTextView1.getText().toString();

        // Check if source station is not selected
        if (sourceStation.isEmpty()) {
            // Display a Toast message prompting the user to select the source station
            Toast.makeText(getActivity(), "Please select source station", Toast.LENGTH_SHORT).show();
            return; // Exit method early
        }

        // Check if destination station is not selected
        if (destinationStation.isEmpty()) {
            // Display a Toast message prompting the user to select the destination station
            Toast.makeText(getActivity(), "Please select destination station", Toast.LENGTH_SHORT).show();
            return; // Exit method early
        }

        // Proceed with navigating to the ChangeJourneyDetileActivity if both stations are selected
        Intent intent = new Intent(getActivity(), ChangeJourneyDetileActivity.class);
        intent.putExtra("sourceStation", sourceStation);
        intent.putExtra("destinationStation", destinationStation);
        startActivity(intent);
    }




    private void setupAutoCompleteTextViews(View view) {
        AutoCompleteTextView autoCompleteTextView = view.findViewById(R.id.searchbar1);
        AutoCompleteTextView autoCompleteTextView1 = view.findViewById(R.id.searchbar2);

        String[] searchsource = {
                "Chhatrapati Shivaji Maharaj Terminus (CSMT)", "Masjid Bunder", "Sandhurst Road", "Dockyard Road", "Reay Road",
                "Cotton Green", "Sewri", "Wadala Road", "Guru Tegh Bahadur Nagar (GTBN)", "Chunabhatti", "Kurla", "Tilak Nagar",
                "Chembur", "Govandi", "Mankhurd", "Vashi", "Sanpada", "Juinagar", "Nerul", "Seawoods–Darave", "CBD Belapur",
                "Kharghar", "Mansarovar", "Khandeshwar", "Panvel", "Churchgate", "Marine Lines", "Charni Road", "Grant Road",
                "Mumbai Central", "Lower Parel", "Mahalaxmi", "Elphinstone Road", "Dadar", "Matunga Road", "Mahim", "Bandra",
                "Khar Road", "Santacruz", "Vile Parle", "Andheri", "Jogeshwari", "Ram Mandir", "Goregaon", "Malad", "Kandivali",
                "Borivali", "Dahisar", "Mira Road", "Bhayandar", "Naigaon", "Vasai Road", "Nallasopara", "Virar", "Byculla",
                "Chinchpokli", "Currey Road", "Parel", "Dadar", "Matunga", "Sion", "Kurla", "Vidyavihar", "Ghatkopar", "Vikhroli",
                "Kanjurmarg", "Bhandup", "Nahur", "Mulund", "Thane", "Diva Junction", "Mumbra", "Kalwa", "Thakurli", "Dombivli",
                "Kopar", "Kalyan", "Shahad", "Ambivli", "Titwala", "Khadavli", "Vasind", "Asangaon", "Atgaon", "Khardi", "Kasara",
                "Sheelar", "Neral", "Bhivpuri Road", "Karjat", "Shahad", "Ambivli", "Titwala", "Khadavli", "Vasind", "Asangaon",
                "Atgaon", "Khardi", "Kasara"};

        String[] items1 = {
                "Chhatrapati Shivaji Maharaj Terminus (CSMT)", "Masjid Bunder", "Sandhurst Road", "Dockyard Road", "Reay Road",
                "Cotton Green", "Sewri", "Wadala Road", "Guru Tegh Bahadur Nagar (GTBN)", "Chunabhatti", "Kurla", "Tilak Nagar",
                "Chembur", "Govandi", "Mankhurd", "Vashi", "Sanpada", "Juinagar", "Nerul", "Seawoods–Darave", "CBD Belapur",
                "Kharghar", "Mansarovar", "Khandeshwar", "Panvel", "Churchgate", "Marine Lines", "Charni Road", "Grant Road",
                "Mumbai Central", "Lower Parel", "Mahalaxmi", "Elphinstone Road", "Dadar", "Matunga Road", "Mahim", "Bandra",
                "Khar Road", "Santacruz", "Vile Parle", "Andheri", "Jogeshwari", "Ram Mandir", "Goregaon", "Malad", "Kandivali",
                "Borivali", "Dahisar", "Mira Road", "Bhayandar", "Naigaon", "Vasai Road", "Nallasopara", "Virar", "Byculla",
                "Chinchpokli", "Currey Road", "Parel", "Dadar", "Matunga", "Sion", "Kurla", "Vidyavihar", "Ghatkopar", "Vikhroli",
                "Kanjurmarg", "Bhandup", "Nahur", "Mulund", "Thane", "Diva Junction", "Mumbra", "Kalwa", "Thakurli", "Dombivli",
                "Kopar", "Kalyan", "Shahad", "Ambivli", "Titwala", "Khadavli", "Vasind", "Asangaon", "Atgaon", "Khardi", "Kasara",
                "Sheelar", "Neral", "Bhivpuri Road", "Karjat", "Shahad", "Ambivli", "Titwala", "Khadavli", "Vasind", "Asangaon",
                "Atgaon", "Khardi", "Kasara"};


        ArrayAdapter<String> autoCompleteAdapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_dropdown_item_1line, searchsource);
        autoCompleteTextView.setAdapter(autoCompleteAdapter);

        ArrayAdapter<String> autoCompleteAdapter1 = new ArrayAdapter<>(requireContext(), android.R.layout.simple_dropdown_item_1line, items1);
        autoCompleteTextView1.setAdapter(autoCompleteAdapter1);
    }

    // Method to navigate to a new fragment
    public void navigateTo(Fragment fragment) {
        if (fragment != null) {
            FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.frame_layout, fragment);
            fragmentTransaction.commit();
        } else {
            Log.e(TAG, "navigateTo: Null fragment provided");
        }
    }

    private void hideKeyboard(View view) {
        InputMethodManager imm = (InputMethodManager) requireActivity().getSystemService(INPUT_METHOD_SERVICE);
        IBinder windowToken = view.getWindowToken();
        if (windowToken != null) {
            imm.hideSoftInputFromWindow(windowToken, 0);
        }
    }


}
