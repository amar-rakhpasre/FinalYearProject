package com.example.finalyearproject.java;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.finalyearproject.R;
import java.util.List;

public class StationMapModelAdapter extends RecyclerView.Adapter<StationMapModelAdapter.StationMapViewHolder> {
    private List<StationMapModel> stationList;
    private OnItemClickListener listener;
    private Context context;

    public  void  setFilteredLIst(List<StationMapModel> filteredLIst){
        this.stationList = filteredLIst;
        notifyDataSetChanged();
    }

    public StationMapModelAdapter(Context context, List<StationMapModel> stationList, OnItemClickListener listener) {
        this.context = context;
        this.stationList = stationList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public StationMapViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_slectedstationsitme, parent, false);
        return new StationMapViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StationMapViewHolder holder, int position) {
        StationMapModel station = stationList.get(position);
        holder.stationName.setText(station.getStationName());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener != null) {
                    listener.onItemClick(station);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return stationList.size();
    }

    static class StationMapViewHolder extends RecyclerView.ViewHolder {
        TextView stationName;

        public StationMapViewHolder(@NonNull View itemView) {
            super(itemView);
            stationName = itemView.findViewById(R.id.textStationName);
        }
    }

    // Interface for item click listener
    public interface OnItemClickListener {
        void onItemClick(StationMapModel item);
    }
}
