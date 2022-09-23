package com.example.kamuko;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class OrderHistoryVH extends RecyclerView.ViewHolder {
    public TextView restName;
    public TextView items;
    public TextView cost;
    public TextView date;
    public TextView time;

    public OrderHistoryVH(@NonNull View itemView) {
        super(itemView);
        restName = itemView.findViewById(R.id.restName);
        items = itemView.findViewById(R.id.items);
        cost = itemView.findViewById(R.id.cost);
        date = itemView.findViewById(R.id.date);
        time = itemView.findViewById(R.id.time);
    }
}
