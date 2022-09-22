package com.example.kamuko;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SpecialMenuVH extends RecyclerView.ViewHolder {

    public ImageView imageView;
    public TextView textView;

    public SpecialMenuVH(@NonNull View itemView) {
        super(itemView);

        imageView = itemView.findViewById(R.id.specialImage);
        textView = itemView.findViewById(R.id.specialText);
    }
}
