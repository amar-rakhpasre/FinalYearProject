//package com.example.finalyearproject.java;
//
//import android.content.Context;
//import android.content.Intent;
//import android.util.Log;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.Button;
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//import com.example.finalyearproject.R;
//import java.util.List;
//
//public class MyAdapter extends RecyclerView.Adapter<SingalViewHolder> {
//    private Context context;
//    private List<TicketModel> ticketModelList;
//
//    public MyAdapter(Context context, List<TicketModel> ticketModelList) {
//        this.context = context;
//        this.ticketModelList = ticketModelList;
//    }
//
//    @NonNull
//    @Override
//    public SingalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_station_name_item, parent, false);
//        return new SingalViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull SingalViewHolder holder, int position) {
//        TicketModel ticketModel = ticketModelList.get(position);
//        holder.recStationTo.setText(ticketModel.getTicket_To());
//        holder.recClass.setText(ticketModel.getTicketClass());
//        holder.recRoute.setText(ticketModel.getTicket_Route());
//        holder.recTicketType.setText(ticketModel.getTicketType());
//
//        holder.btnSingleTicket.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Log.d("MyAdapter", "btnSingleTicket clicked"); // Debug log
//                Intent intent = new Intent(context, TicketDetailsPaymentActivity.class);
//                // Pass data to intent
//                intent.putExtra("ticketTo", ticketModel.getTicket_To());
//                intent.putExtra("ticketRoute", ticketModel.getTicket_Route());
//                intent.putExtra("ticketClass", ticketModel.getTicketClass());
//                intent.putExtra("ticketType", ticketModel.getTicketType());
//                // Add more data as needed
//                context.startActivity(intent);
//            }
//        });
//    }
//
//    @Override
//    public int getItemCount() { return ticketModelList.size(); }
//}
