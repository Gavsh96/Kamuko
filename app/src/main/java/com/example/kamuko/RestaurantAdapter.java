package com.example.kamuko;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RestaurantAdapter extends RecyclerView.Adapter<RestaurantVH> {

    RestaurantDBModel rDBm;
    ArrayList<Restaurant> restaurants;

    public RestaurantAdapter(RestaurantDBModel rDBm)
    {
        this.rDBm = rDBm;
        restaurants = rDBm.getAllRestaurant();
    }

    @NonNull
    @Override
    public RestaurantVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.special_menu, parent, false);
        RestaurantVH viewHolder = new RestaurantVH(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RestaurantVH holder, int position) {
        holder.textView.setText(restaurants.get(position).getName());
        holder.imageView.setImageResource(restaurants.get(position).getImg());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
    }

    @Override
    public int getItemCount() {
        return restaurants.size();
    }
}
