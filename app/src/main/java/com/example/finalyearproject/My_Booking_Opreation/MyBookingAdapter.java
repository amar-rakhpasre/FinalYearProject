package com.example.finalyearproject.My_Booking_Opreation;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.finalyearproject.R;
import java.util.List;

public class MyBookingAdapter extends RecyclerView.Adapter<MyBookingAdapter.MyBookingViewHolder> {

    private List<MyBookingModel> myBookingModelList;
    private Context context;

    public void setFilteredList(List<MyBookingModel> filteredList) {
        this.myBookingModelList = filteredList;
        notifyDataSetChanged();
    }

    public MyBookingAdapter(List<MyBookingModel> myBookingModelList, Context context) {
        this.myBookingModelList = myBookingModelList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyBookingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.my_booking_item, parent, false);
        return new MyBookingViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyBookingViewHolder holder, int position) {
        MyBookingModel item = myBookingModelList.get(position);
        holder.TVTicketClass.setText(item.getTicketClass());
        holder.TVTicket_To.setText(item.getTicketTo());
        holder.TVTicket_Route.setText(item.getTicketRoute());
        holder.TVTicketValidity.setText(item.getTicketValidity());
        holder.TVTicket_From.setText(item.getTicketFrom());
        holder.TVTicketNumber.setText(String.valueOf(item.getTicketNumber()));
        holder.TVTicketDate.setText(item.getTicketDate());
        holder.TVTicketChildCount.setText(String.valueOf(item.getTicketChildCount()));
        holder.TVTicketAdultCount.setText(String.valueOf(item.getTicketAdultCount()));
        holder.TVTicketType.setText(item.getTicketType());
        holder.TVTicketPrice.setText(String.valueOf(item.getTicketPrice()));
    }

    @Override
    public int getItemCount() {
        return myBookingModelList.size();
    }

    public class MyBookingViewHolder extends RecyclerView.ViewHolder {

        public TextView TVTicketClass, TVTicket_To, TVTicket_Route, TVTicketValidity, TVTicket_From, TVTicketNumber, TVTicketDate, TVTicketChildCount, TVTicketAdultCount, TVTicketType, TVTicketPrice;

        public MyBookingViewHolder(@NonNull View itemView) {
            super(itemView);
            TVTicketClass = itemView.findViewById(R.id.TVTicketClass);
            TVTicket_To = itemView.findViewById(R.id.TVTicket_To);
            TVTicket_Route = itemView.findViewById(R.id.TVTicket_Route);
            TVTicketValidity = itemView.findViewById(R.id.TVTicketValidity);
            TVTicket_From = itemView.findViewById(R.id.TVTicket_From);
            TVTicketNumber = itemView.findViewById(R.id.TVTicketNumber);
            TVTicketDate = itemView.findViewById(R.id.TVTicketDate);
            TVTicketChildCount = itemView.findViewById(R.id.TVTicketChildCount);
            TVTicketAdultCount = itemView.findViewById(R.id.TVTicketAdultCount);
            TVTicketType = itemView.findViewById(R.id.TVTicketType);
            TVTicketPrice = itemView.findViewById(R.id.TVTicketPrice);
        }
    }
}
