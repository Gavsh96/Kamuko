package com.example.kamuko;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CartVH extends RecyclerView.ViewHolder {

    TextView name;
    TextView qty;

    public CartVH(@NonNull View itemView) {
        super(itemView);

        name = itemView.findViewById(R.id.name);
        qty = itemView.findViewById(R.id.qty);
    }
}
