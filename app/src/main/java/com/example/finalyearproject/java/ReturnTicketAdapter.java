// ReturnTicketAdapter.java
package com.example.finalyearproject.java;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.finalyearproject.R;
import java.util.List;

public class ReturnTicketAdapter extends RecyclerView.Adapter<ReturnTicketViewHolder> {
    private Context context;
    private List<ReturnTicketModel> returnTicketModelsList;

    public ReturnTicketAdapter(Context context, List<ReturnTicketModel> returnTicketModelsList) {
        this.context = context;
        this.returnTicketModelsList = returnTicketModelsList;
    }

    @NonNull
    @Override
    public ReturnTicketViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_station_name_item, parent, false);
        return new ReturnTicketViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ReturnTicketViewHolder holder, int position) {
        ReturnTicketModel returnTicketModel = returnTicketModelsList.get(position);
        holder.recStationTo.setText(returnTicketModel.getTicket_To());
        holder.recClass.setText(returnTicketModel.getTicketClass());
        holder.recRoute.setText(returnTicketModel.getTicket_Route());
        holder.recTicketType.setText(returnTicketModel.getTicketType());

        holder.btnReturnTicket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, TicketDetailsPaymentActivity.class);
                intent.putExtra("ticketTo", returnTicketModel.getTicket_To());
                intent.putExtra("ticketRoute", returnTicketModel.getTicket_Route());
                intent.putExtra("ticketClass", returnTicketModel.getTicketClass());
                intent.putExtra("ticketType", returnTicketModel.getTicketType());
                intent.putExtra("ticketPrice", returnTicketModel.getTicketPrice());
                intent.putExtra("ticketDate", returnTicketModel.getTicketDate());
                intent.putExtra("ticketNumber", returnTicketModel.getTicketNumber());
                intent.putExtra("ticketAdultCount", returnTicketModel.getTicketAdultCount());
                intent.putExtra("ticketChildCount", returnTicketModel.getTicketChildCount());
                intent.putExtra("ticketValidity", returnTicketModel.getTicketValidity());
                intent.putExtra("ticketFrom", returnTicketModel.getTicket_From());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return returnTicketModelsList.size();
    }
}



