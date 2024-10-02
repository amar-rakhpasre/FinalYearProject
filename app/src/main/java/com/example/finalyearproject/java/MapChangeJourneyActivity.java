package com.example.finalyearproject.java;

        import androidx.appcompat.app.AppCompatActivity;

        import android.content.Intent;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.ArrayAdapter;
        import android.widget.AutoCompleteTextView;
        import android.widget.Button;
        import android.widget.CheckBox;
        import android.widget.CompoundButton;
        import android.widget.RadioButton;
        import android.widget.TextView;
        import android.widget.Toast;

        import com.example.finalyearproject.R;

public class MapChangeJourneyActivity extends AppCompatActivity {

    // Declare your UI elements
    RadioButton radioButtonSingle, radioButtonReturn, radioButtonFirstClass, radioButtonSecondClass;
    RadioButton radioButton1, radioButton2, radioButton3, radioButton4;
    CheckBox checkBoxOrdinary;
    TextView textViewTotalFare;
    Button buttonConfirm, buttonBack;
    TextView destinationStationTextView;
    AutoCompleteTextView sourceStationTextView;
    double fareAmount = 0; // Default fare amount

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_change_journey);

        // Initialize UI elements
        radioButtonSingle = findViewById(R.id.radioButtonSingle);
        radioButtonReturn = findViewById(R.id.radioButtonReturn);
        radioButtonFirstClass = findViewById(R.id.radioButtonFirstClass);
        radioButtonSecondClass = findViewById(R.id.radioButtonSecondClass);
        radioButton1 = findViewById(R.id.radioButton1);
        radioButton2 = findViewById(R.id.radioButton2);
        radioButton3 = findViewById(R.id.radioButton3);
        radioButton4 = findViewById(R.id.radioButton4);
        checkBoxOrdinary = findViewById(R.id.checkBoxOrdinary);
        textViewTotalFare = findViewById(R.id.textViewTotalFare);
        buttonConfirm = findViewById(R.id.buttonConfirm);
        buttonBack = findViewById(R.id.buttonBack);

        // Initialize UI elements
        sourceStationTextView = findViewById(R.id.sourceStationTextView);
        destinationStationTextView = findViewById(R.id.destinationStationTextView);

        // Get the intent that started this activity
        Intent intent = getIntent();
        if (intent != null) {
            // Retrieve the source and destination station names from intent extras
            String sourceStation = intent.getStringExtra("sourceStation");
            String destinationStation = intent.getStringExtra("destinationStation");

            // Set the retrieved station names to TextViews
            sourceStationTextView.setText(sourceStation);

            // Retrieve and set the destination station name
            String clickedStation = intent.getStringExtra("stationName");
            destinationStationTextView.setText(clickedStation);
        }

        // Set onClickListener for Confirm button
        buttonConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Check if the source station is empty
                if (sourceStationTextView.getText().toString().isEmpty()) {
                    // Display a toast message
                    Toast.makeText(MapChangeJourneyActivity.this, "Please select the source Station", Toast.LENGTH_SHORT).show();
                    return; // Exit the onClick method
                }

                // Check if all required options are selected
                if (isSelectionValid()) {
                    // Redirect to TicketDetailsPaymentActivity with selected values
                    Intent intent = new Intent(MapChangeJourneyActivity.this, MapTicketPaymentActivity.class);
                    intent.putExtra("trainType", radioButtonReturn.isChecked() ? "Return Ticket" : "Single Ticket");
                    intent.putExtra("travelClass", radioButtonFirstClass.isChecked() ? "First Class" : "Second Class");
                    intent.putExtra("isOrdinary", checkBoxOrdinary.isChecked());
                    // Convert total fare to String before passing it
                    intent.putExtra("totalFare", String.valueOf(calculateTotalFare()));
                    // Pass sourceStation and destinationStation
                    intent.putExtra("sourceStation", sourceStationTextView.getText().toString());
                    intent.putExtra("destinationStation", destinationStationTextView.getText().toString());
                    // Pass ticket count
                    intent.putExtra("ticketCount", getNumberOfTickets());
                    // Pass checkBoxOrdinary state
                    intent.putExtra("isCheckBoxOrdinaryChecked", checkBoxOrdinary.isChecked());
                    startActivity(intent);
                }
            }
        });

        // Set checkBoxOrdinary as checked by default
        checkBoxOrdinary.setChecked(true);

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // If HomeFragment is a fragment, navigate to it using FragmentTransaction
                // If it's an activity, replace with the correct intent
                Intent intent = new Intent(MapChangeJourneyActivity.this, HomeFragment.class);
                startActivity(intent);
                finish();
            }
        });

        // Set listeners for fare calculation
        setFareCalculationListeners();

        // Set initial fare amount and update total fare text
        updateTotalFareText();

        // Setup AutoCompleteTextViews
        setupAutoCompleteTextViews();
    }

    // Method to setup AutoCompleteTextViews
    private void setupAutoCompleteTextViews() {
        AutoCompleteTextView autoCompleteTextView = findViewById(R.id.sourceStationTextView);

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
                "Atgaon", "Khardi", "Kasara"
        };


        // Set up adapter for AutoCompleteTextView
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, searchsource);
        autoCompleteTextView.setAdapter(adapter);
    }

    // Method to check if all required options are selected
    private boolean isSelectionValid() {
        boolean isValid = true;

        // Check if either radioButtonSingle or radioButtonReturn is checked
        if (!radioButtonSingle.isChecked() && !radioButtonReturn.isChecked()) {
            Toast.makeText(MapChangeJourneyActivity.this, "Please select the Ticket type", Toast.LENGTH_SHORT).show();
            isValid = false;
        }

        // Check if either radioButtonFirstClass or radioButtonSecondClass is checked
        if (!radioButtonFirstClass.isChecked() && !radioButtonSecondClass.isChecked()) {
            Toast.makeText(MapChangeJourneyActivity.this, "Please select the Travel class", Toast.LENGTH_SHORT).show();
            isValid = false;
        }

        // Check if at least one of radioButton1, radioButton2, radioButton3, radioButton4 is checked
        if (!radioButton1.isChecked() && !radioButton2.isChecked() && !radioButton3.isChecked() && !radioButton4.isChecked()) {
            Toast.makeText(MapChangeJourneyActivity.this, "Please select the Ticket count", Toast.LENGTH_SHORT).show();
            isValid = false;
        }

        return isValid;
    }

    // Method to update the total fare text based on selected options
    private void updateTotalFareText() {
        textViewTotalFare.setText(String.format("Total Fare: %d rupees", (int) calculateTotalFare()));
    }

    // Method to calculate total fare based on selected options
    private double calculateTotalFare() {
        double baseFare = radioButtonSingle.isChecked() ? (radioButtonFirstClass.isChecked() ? 20 : 10) : (radioButtonFirstClass.isChecked() ? 40 : 20);
        int numberOfTickets = getNumberOfTickets();
        double seniorityMultiplier = checkBoxOrdinary.isChecked() ? 2.0 : 1.0; // Apply multiplier if ordinary ticket is selected

        return baseFare * numberOfTickets * seniorityMultiplier;
    }

    // Method to get the number of tickets based on radio button selection
    private int getNumberOfTickets() {
        if (radioButton1.isChecked()) return 1;
        else if (radioButton2.isChecked()) return 2;
        else if (radioButton3.isChecked()) return 3;
        else if (radioButton4.isChecked()) return 4;
        else return 1; // Default to 1 ticket if none selected
    }

    // Set listeners for fare calculation
    private void setFareCalculationListeners() {
        radioButtonSingle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateTotalFareText();
            }
        });

        radioButtonReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateTotalFareText();
            }
        });

        radioButtonFirstClass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateTotalFareText();
            }
        });

        radioButtonSecondClass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateTotalFareText();
            }
        });

        radioButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateTotalFareText();
            }
        });

        radioButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateTotalFareText();
            }
        });

        radioButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateTotalFareText();
            }
        });

        radioButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateTotalFareText();
            }
        });

    }
}