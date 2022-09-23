package com.example.kamuko;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CartVH extends RecyclerView.ViewHolder {

    TextView name;
    TextView qty;
    TextView Price;
    Button edit;
    Button remove;

    public CartVH(@NonNull View itemView, CartInterface cartInterface) {
        super(itemView);

        name = itemView.findViewById(R.id.name);
        qty = itemView.findViewById(R.id.qty);
        Price = itemView.findViewById(R.id.price);
        edit = itemView.findViewById(R.id.editButton);
        remove = itemView.findViewById(R.id.removeButton);

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(cartInterface != null)
                {
                    int position = getAdapterPosition();
                    if(position != RecyclerView.NO_POSITION)
                    {
                        cartInterface.onCartClick(position);
                    }
                }
            }
        });

        remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(cartInterface != null)
                {
                    int position = getAdapterPosition();
                    if(position != RecyclerView.NO_POSITION)
                    {
                        cartInterface.onRemoveClick(position);
                    }
                }
            }
        });
    }
}
