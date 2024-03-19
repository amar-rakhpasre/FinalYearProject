package com.example.finalyearproject.java;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.finalyearproject.R;

public class TicketDetailsPaymentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket_details_payment);

        // Get the ticket data from the intent
        String ticketTo = getIntent().getStringExtra("ticketTo");
        String ticketRoute = getIntent().getStringExtra("ticketRoute");
        String ticketClass = getIntent().getStringExtra("ticketClass");
        String ticketType = getIntent().getStringExtra("ticketType");
        int ticketPrice = getIntent().getIntExtra("ticketPrice", 0);
        String ticketDate = getIntent().getStringExtra("ticketDate");
        int ticketNumber = getIntent().getIntExtra("ticketNumber", 0);
        int ticketAdultCount = getIntent().getIntExtra("ticketAdultCount", 0);
        int ticketChildCount = getIntent().getIntExtra("ticketChildCount", 0);
        String ticketValidity = getIntent().getStringExtra("ticketValidity");
        String ticketFrom = getIntent().getStringExtra("ticketFrom");

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
        ticketPriceTextView.setText(String.valueOf(ticketPrice));
        ticketDateTextView.setText(ticketDate);
        ticketNumberTextView.setText(String.valueOf(ticketNumber));
        ticketAdultCountTextView.setText(String.valueOf(ticketAdultCount));
        ticketChildCountTextView.setText(String.valueOf(ticketChildCount));
        ticketValidityTextView.setText(ticketValidity);
        ticketFromTextView.setText(ticketFrom);
    }
}
