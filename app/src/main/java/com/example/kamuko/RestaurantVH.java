package com.example.kamuko;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RestaurantVH extends RecyclerView.ViewHolder {
    public ImageView imageView;
    public TextView textView;

    public RestaurantVH(@NonNull View itemView) {
        super(itemView);

        imageView = itemView.findViewById(R.id.specialImage);
        textView = itemView.findViewById(R.id.specialText);
    }
}
