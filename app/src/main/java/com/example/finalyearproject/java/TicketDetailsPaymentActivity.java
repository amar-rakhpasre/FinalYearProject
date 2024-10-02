package com.example.finalyearproject.java;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.finalyearproject.R;
import com.example.finalyearproject.PaymentGateway.UserTicket;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class TicketDetailsPaymentActivity extends AppCompatActivity {

    Button BookTicket;
    DatabaseReference databaseReference;
    ProgressDialog progressDialog;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket_details_payment);
        BookTicket = findViewById(R.id.BookTicket);

        // Initialize Firebase database reference
        databaseReference = FirebaseDatabase.getInstance().getReference().child("UserTickets");

        // Initialize progressDialog
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Booking Ticket...");
        progressDialog.setCancelable(false);
        progressDialog.setMax(3); // Set the maximum duration in seconds

        BookTicket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressDialog.show();
                new android.os.Handler().postDelayed(
                        new Runnable() {
                            public void run() {
                                progressDialog.dismiss();
                                bookTicket();
                            }
                        },
                        3000 // 3 seconds
                );
            }
        });

        // Get the ticket data from the intent and display it
        displayTicketData();
    }

    private void displayTicketData() {
        // Get the ticket data from the intent
        Intent intent = getIntent();
        if (intent != null) {
            String ticketTo = intent.getStringExtra("ticketTo");
            String ticketRoute = intent.getStringExtra("ticketRoute");
            String ticketClass = intent.getStringExtra("ticketClass");
            String ticketType = intent.getStringExtra("ticketType");
            int ticketPrice = intent.getIntExtra("ticketPrice", 0);
            String ticketDate = intent.getStringExtra("ticketDate");
            int ticketNumber = intent.getIntExtra("ticketNumber", 0);
            int ticketAdultCount = intent.getIntExtra("ticketAdultCount", 0);
            int ticketChildCount = intent.getIntExtra("ticketChildCount", 0);
            String ticketValidity = intent.getStringExtra("ticketValidity");
            String ticketFrom = intent.getStringExtra("ticketFrom");

            // Find the TextViews in the layout
            TextView ticketToTextView = findViewById(R.id.Ticket_To);
            TextView ticketRouteTextView = findViewById(R.id.Ticket_Route);
            TextView ticketClassTextView = findViewById(R.id.TicketClass);
            TextView ticketTypeTextView = findViewById(R.id.TicketType);
            TextView ticketPriceTextView = findViewById(R.id.TicketPrice);
            TextView ticketDateTextView = findViewById(R.id.TicketDate);
            TextView ticketNumberTextView = findViewById(R.id.TicketNumber);
            TextView ticketAdultCountTextView = findViewById(R.id.TicketAdultCount);
            TextView ticketChildCountTextView = findViewById(R.id.TicketChildCount);
            TextView ticketValidityTextView = findViewById(R.id.TicketValidity);
            TextView ticketFromTextView = findViewById(R.id.Ticket_From);

            // Set the ticket data to the TextViews
            ticketToTextView.setText(ticketTo);
            ticketRouteTextView.setText(ticketRoute);
            ticketClassTextView.setText(ticketClass);
            ticketTypeTextView.setText(ticketType);
            ticketPriceTextView.setText(String.valueOf(ticketPrice)); // Convert int to String
            ticketDateTextView.setText(ticketDate);
            ticketNumberTextView.setText(String.valueOf(ticketNumber)); // Convert int to String
            ticketAdultCountTextView.setText(String.valueOf(ticketAdultCount)); // Convert int to String
            ticketChildCountTextView.setText(String.valueOf(ticketChildCount)); // Convert int to String
            ticketValidityTextView.setText(ticketValidity);
            ticketFromTextView.setText(ticketFrom);
        } else {
            // Handle null intent case
        }
    }

    private void bookTicket() {
        // Get the ticket data from the intent
        Intent intent = getIntent();
        if (intent != null) {
            String ticketTo = intent.getStringExtra("ticketTo");
            String ticketRoute = intent.getStringExtra("ticketRoute");
            String ticketClass = intent.getStringExtra("ticketClass");
            String ticketType = intent.getStringExtra("ticketType");
            int ticketPrice = intent.getIntExtra("ticketPrice", 0);
            String ticketDate = intent.getStringExtra("ticketDate");
            int ticketNumber = intent.getIntExtra("ticketNumber", 0);
            int ticketAdultCount = intent.getIntExtra("ticketAdultCount", 0);
            int ticketChildCount = intent.getIntExtra("ticketChildCount", 0);
            String ticketValidity = intent.getStringExtra("ticketValidity");
            String ticketFrom = intent.getStringExtra("ticketFrom");

            // Create a UserTicket object
            UserTicket ticket = new UserTicket(ticketTo, ticketRoute, ticketClass, ticketType, ticketPrice,
                    ticketDate, ticketNumber, ticketAdultCount, ticketChildCount, ticketValidity, ticketFrom);

            // Generate a unique key for the ticket
            String ticketId = databaseReference.push().getKey();
            if (ticketId != null) {
                // Save the ticket object to Firebase under the ticketId node
                databaseReference.child(ticketId).setValue(ticket);

                // Show a success message
                Toast.makeText(TicketDetailsPaymentActivity.this, "Ticket Booked", Toast.LENGTH_SHORT).show();

                // Redirect to HomePageActivity
                Intent homeIntent = new Intent(TicketDetailsPaymentActivity.this, HomePage_Activity.class);
                startActivity(homeIntent);
                finish(); // Finish the current activity to prevent user from going back to it
            }
        } else {
            // Handle null intent case
        }
    }
}
