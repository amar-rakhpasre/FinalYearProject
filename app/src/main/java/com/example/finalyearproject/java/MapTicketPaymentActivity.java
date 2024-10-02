package com.example.finalyearproject.java;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.finalyearproject.R;
import com.example.finalyearproject.PaymentGateway.UserTicket;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MapTicketPaymentActivity extends AppCompatActivity {

    Button bookTicketButton;
    private ProgressDialog progressDialog;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_ticket_payment);

        bookTicketButton = findViewById(R.id.BookTicket);

        // Initialize Firebase database reference
        databaseReference = FirebaseDatabase.getInstance().getReference().child("User_MapTickets");

        bookTicketButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bookTicket();
            }
        });

        // Get the ticket data from the intent and display it
        displayTicketData();
    }

    private void displayTicketData() {
        // Get the ticket data from the intent
        Intent intent = getIntent();
        if (intent != null) {
            String ticketTo = intent.getStringExtra("destinationStation");
            String ticketFrom = intent.getStringExtra("sourceStation");
            String ticketClass = intent.getStringExtra("travelClass");
            String ticketType = intent.getStringExtra("trainType");
            String ticketPrice = intent.getStringExtra("totalFare"); // Use "totalFare" as the key
            int ticketAdultCount = intent.getIntExtra("ticketCount", 0);

            // Find the TextViews in the layout
            TextView ticketToTextView = findViewById(R.id.Ticket_To);
            TextView ticketFromTextView = findViewById(R.id.Ticket_From);
            TextView ticketPriceTextView = findViewById(R.id.TicketPrice);
            TextView ticketClassTextView = findViewById(R.id.TicketClass);
            TextView ticketTypeTextView = findViewById(R.id.TicketType);
            TextView ticketAdultCountTextView = findViewById(R.id.TicketAdultCount);

            // Set the ticket data to the TextViews
            ticketToTextView.setText(ticketTo);
            ticketFromTextView.setText(ticketFrom);
            ticketPriceTextView.setText(ticketPrice);
            ticketClassTextView.setText(ticketClass);
            ticketTypeTextView.setText(ticketType);
            ticketAdultCountTextView.setText(String.valueOf(ticketAdultCount)); // Convert int to String
        } else {
            // Handle null intent case
        }
    }

    private void bookTicket() {
        // Display the progress dialog
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Booking ticket...");
        progressDialog.setCancelable(false);
        progressDialog.show();

        // Get the current user's UID from Firebase Authentication
        String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();

        // Get the ticket data from the intent
        Intent intent = getIntent();
        if (intent != null) {
            String ticketTo = intent.getStringExtra("destinationStation");
            String ticketFrom = intent.getStringExtra("sourceStation");
            String ticketClass = intent.getStringExtra("travelClass"); // Adjust this line if ticketClass is present in the UserTicket object
            String ticketType = intent.getStringExtra("trainType");
            String ticketPrice = intent.getStringExtra("totalFare");
            int ticketAdultCount = intent.getIntExtra("ticketCount", 0);

            // Get the current date
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmssSSS");
            String timestamp = dateFormat.format(new Date());

            // Create a UserTicket object
            UserMapTicketModel ticket = new UserMapTicketModel(ticketTo, ticketFrom, ticketClass, ticketType, ticketPrice,
                    timestamp, ticketAdultCount);

            // Save the ticket object to Firebase under the user's UID with the timestamp as part of the key
            databaseReference.child(uid).child(timestamp).setValue(ticket);

            // Delay the execution for 3 seconds
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Dismiss the progress dialog
                    progressDialog.dismiss();

                    // Show a success message
                    Toast.makeText(MapTicketPaymentActivity.this, "Ticket Booked", Toast.LENGTH_SHORT).show();

                    // Redirect the user to the desired activity
                    // For example:
                     Intent intent = new Intent(MapTicketPaymentActivity.this, HomePage_Activity.class);
                     startActivity(intent);
                     finish(); // Optional: finish the current activity
                }
            }, 3000); // 3000 milliseconds = 3 seconds delay
        } else {
            // Handle null intent case
            // Dismiss the progress dialog
            progressDialog.dismiss();
            // Show a failure message
            Toast.makeText(MapTicketPaymentActivity.this, "Failed to book ticket. Please try again.", Toast.LENGTH_SHORT).show();
        }
    }
}
