package com.example.finalyearproject.java;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalyearproject.R;

public class ReturnTicketViewHolder extends RecyclerView.ViewHolder {
    TextView recStationTo;
    TextView recRoute;
    TextView recClass;
    TextView recTicketType;
    Button btnReturnTicket, btnSingleTicket;

    public ReturnTicketViewHolder(@NonNull View itemView) {
        super(itemView);
        recStationTo = itemView.findViewById(R.id.recStationTo);
        recRoute = itemView.findViewById(R.id.recRoute);
        recClass = itemView.findViewById(R.id.recClass);
        recTicketType = itemView.findViewById(R.id.recTicketType);
        btnReturnTicket = itemView.findViewById(R.id.btnReturnTicket);
        btnSingleTicket = itemView.findViewById(R.id.btnSingleTicket);
    }
}
