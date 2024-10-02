//package com.example.finalyearproject.PaymentGateway;
//
//import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;
//
//import androidx.annotation.NonNull;
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.os.Bundle;
//import android.util.Log;
//import android.view.View;
//import android.widget.Button;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import com.example.finalyearproject.R;
//import com.google.android.gms.tasks.OnFailureListener;
//import com.google.android.gms.tasks.OnSuccessListener;
//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;
//
////public class PaymentGateway_Activity extends AppCompatActivity {
////
////    DatabaseReference databaseReference;
////
////    @Override
////    protected void onCreate(Bundle savedInstanceState) {
////        super.onCreate(savedInstanceState);
////        setContentView(R.layout.activity_payment_gateway);
////
////        // Get user data from intent
////        Bundle extras = getIntent().getExtras();
////        if (extras != null) {
////            String ticketTo = extras.getString("ticketTo", "");
////            String ticketRoute = extras.getString("ticketRoute", "");
////            String ticketClass = extras.getString("ticketClass", "");
////            String ticketType = extras.getString("ticketType", "");
////            int ticketPrice = extras.getInt("ticketPrice", 0);
////            String ticketDate = extras.getString("ticketDate", "");
////            int ticketNumber = extras.getInt("ticketNumber", 0);
////            int ticketAdultCount = extras.getInt("ticketAdultCount", 0);
////            int ticketChildCount = extras.getInt("ticketChildCount", 0);
////            String ticketValidity = extras.getString("ticketValidity", "");
////            String ticketFrom = extras.getString("ticketFrom", "");
////
////            // Update TextViews with user data
////            TextView tvTicketTo = findViewById(R.id.tvTicketTo);
////            tvTicketTo.setText("Ticket To: " + ticketTo);
////            TextView tvTicketRoute = findViewById(R.id.Ticket_Route);
////            tvTicketRoute.setText("Ticket Route: " + ticketRoute);
////            TextView tvTicketClass = findViewById(R.id.TicketClass);
////            tvTicketClass.setText("Ticket Class: " + ticketClass);
////            TextView tvTicketType = findViewById(R.id.TicketType);
////            tvTicketType.setText("Ticket Type: " + ticketType);
////            TextView tvTicketPrice = findViewById(R.id.TicketPrice);
////            tvTicketPrice.setText("Ticket Price: " + ticketPrice);
////            TextView tvTicketDate = findViewById(R.id.TicketDate);
////            tvTicketDate.setText("Ticket Date: " + ticketDate);
////            TextView tvTicketNumber = findViewById(R.id.TicketNumber);
////            tvTicketNumber.setText("Ticket Number: " + ticketNumber);
////            TextView tvTicketAdultCount = findViewById(R.id.TicketAdultCount);
////            tvTicketAdultCount.setText("Adult Count: " + ticketAdultCount);
////            TextView tvTicketChildCount = findViewById(R.id.TicketChildCount);
////            tvTicketChildCount.setText("Child Count: " + ticketChildCount);
////            TextView tvTicketValidity = findViewById(R.id.TicketValidity);
////            tvTicketValidity.setText("Ticket Validity: " + ticketValidity);
////            TextView tvTicketFrom = findViewById(R.id.Ticket_From);
////            tvTicketFrom.setText("Ticket From: " + ticketFrom);
////        }
////
////        // Initialize Firebase database reference
////        databaseReference = FirebaseDatabase.getInstance().getReference().child("UserTickets");
////
////        // Handle Pay button click
////        Button btnPay = findViewById(R.id.btnPay);
////        btnPay.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View view) {
////                // Implement your payment gateway integration logic here
////                // For example, you can show a Toast message
////                Toast.makeText(PaymentGateway_Activity.this, "Payment processed successfully", Toast.LENGTH_SHORT).show();
////
////                // After successful payment, you can store ticket data in Firebase database
////                storeTicketData();
////            }
////        });
////    }
////
////    private void storeTicketData() {
////        // Implement your logic to store ticket data in Firebase database here
////        // For example, create a unique ticket ID and store all ticket details under that ID
////        // You can use the databaseReference to push data to Firebase
////        String ticketId = databaseReference.push().getKey();
////        if (ticketId != null) {
////            // Create a new UserTicket object with the ticket details
////            UserTicket ticket = new UserTicket(
////                    "Destination",
////                    "Route",
////                    "Class",
////                    "Type",
////                    100, // Price
////                    "Date",
////                    123456, // Ticket number
////                    2, // Adult count
////                    1, // Child count
////                    "Validity",
////                    "From"
////                    // Pass other ticket properties here
////            );
////
////            // Save the ticket object to Firebase under the ticketId node
////            databaseReference.child(ticketId).setValue(ticket)
////                    .addOnSuccessListener(new OnSuccessListener<Void>() {
////                        @Override
////                        public void onSuccess(Void aVoid) {
////                            // Ticket data saved successfully
////                            Toast.makeText(PaymentGateway_Activity.this, "Ticket data saved successfully", Toast.LENGTH_SHORT).show();
////                        }
////                    })
////                    .addOnFailureListener(new OnFailureListener() {
////                        @Override
////                        public void onFailure(@NonNull Exception e) {
////                            // Handle any errors that occurred while saving the data
////                            Toast.makeText(PaymentGateway_Activity.this, "Failed to save ticket data", Toast.LENGTH_SHORT).show();
////                            Log.e(TAG, "Error saving ticket data: " + e.getMessage());
////                        }
////                    });
////        }
////    }
////
////}
