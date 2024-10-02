package com.example.finalyearproject.SudoOperation;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalyearproject.R;
import com.example.finalyearproject.java.StationMapModel;

import java.util.List;

public class ScheduleAdapter extends RecyclerView.Adapter<ScheduleAdapter.scheduleViewHolder> {

    private List<Schedule> scheduleList;
    private Context context;

    public  void  setFilteredLIst(List<Schedule> filteredLIst){
        this.scheduleList = filteredLIst;
        notifyDataSetChanged();
    }

    public ScheduleAdapter(List<Schedule> scheduleList, Context context) {
        this.scheduleList = scheduleList;
        this.context = context;
    }

    @NonNull
    @Override
    public scheduleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.trainschedule_item, parent, false);
        return new scheduleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull scheduleViewHolder holder, int position) {

        Schedule item = scheduleList.get(position);
        holder.recFrom.setText(item.getFrom());
        holder.recPlatform.setText(item.getPlatform());
        holder.rectime.setText(item.getTime());
        holder.recStatlionTo.setText(item.getTo());
        holder.recTrainNum.setText(item.getTrainNum());


    }

    @Override
    public int getItemCount() {
        return scheduleList.size();
    }

    public class scheduleViewHolder extends RecyclerView.ViewHolder {

        public TextView rectime, recFrom, recStatlionTo, recPlatform, recTrainNum;

        public scheduleViewHolder(@NonNull View itemView) {
            super(itemView);
            rectime = itemView.findViewById(R.id.rectime);
            recFrom = itemView.findViewById(R.id.recFrom);
            recStatlionTo = itemView.findViewById(R.id.recStatlionTo);
            recPlatform = itemView.findViewById(R.id.recPlatform);
            recTrainNum = itemView.findViewById(R.id.recTrainNum);
        }
    }
}
