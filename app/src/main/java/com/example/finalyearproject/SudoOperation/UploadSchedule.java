package com.example.finalyearproject.SudoOperation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.finalyearproject.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class UploadSchedule extends AppCompatActivity {

    private EditText addTO, addFrom, addTime, addPlatform, addTrainNum;
    private Button uploadSchedule;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_schedule);

        // Initialize Firebase database reference
        databaseReference = FirebaseDatabase.getInstance().getReference("Train Schedule");

        addTO = findViewById(R.id.addTO);
        addFrom = findViewById(R.id.addFrom);
        addTime = findViewById(R.id.addTime);
        addPlatform = findViewById(R.id.addPaltform);
        addTrainNum = findViewById(R.id.addTrainNum);
        uploadSchedule = findViewById(R.id.UploadSchedule);

        uploadSchedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                uploadData();
            }
        });
    }

    private void uploadData() {
        String to = addTO.getText().toString().trim();
        String from = addFrom.getText().toString().trim();
        String time = addTime.getText().toString().trim();
        String platform = addPlatform.getText().toString().trim();
        String trainNum = addTrainNum.getText().toString().trim();

        // Validate input fields
        if (to.isEmpty() || from.isEmpty() || time.isEmpty() || platform.isEmpty() || trainNum.isEmpty()) {
            Toast.makeText(UploadSchedule.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        // Create a unique key for each schedule entry
        String scheduleId = databaseReference.push().getKey();
        if (scheduleId == null) {
            // Handle error in generating key
            Toast.makeText(UploadSchedule.this, "Error uploading data", Toast.LENGTH_SHORT).show();
            return;
        }

        // Create Schedule object
        Schedule schedule = new Schedule(to, from, time, platform, trainNum);

        // Upload to Firebase Realtime Database
        databaseReference.child(scheduleId).setValue(schedule)
                .addOnSuccessListener(aVoid -> {
                    Toast.makeText(UploadSchedule.this, "Schedule uploaded successfully", Toast.LENGTH_SHORT).show();
                    // Clear EditText fields after successful upload
                    addTO.setText("");
                    addFrom.setText("");
                    addTime.setText("");
                    addPlatform.setText("");
                    addTrainNum.setText("");
                })
                .addOnFailureListener(e -> {
                    Toast.makeText(UploadSchedule.this, "Error uploading data", Toast.LENGTH_SHORT).show();
                });
    }
}
