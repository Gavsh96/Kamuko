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

    public SpecialMenuVH(@NonNull View itemView, SpecialMenuInterface specialMenuInterface, ArrayList<Menu> list) {
        super(itemView);

        imageView = itemView.findViewById(R.id.specialImage);
        textView = itemView.findViewById(R.id.specialText);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(specialMenuInterface != null)
                {
                    int position = getAdapterPosition();
                    if(position != RecyclerView.NO_POSITION)
                    {
                        specialMenuInterface.onSpecialClick(position, list);
                    }
                }
            }
        });
    }
}
