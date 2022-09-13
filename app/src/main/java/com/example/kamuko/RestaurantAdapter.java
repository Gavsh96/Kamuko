package com.example.kamuko;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RestaurantAdapter extends RecyclerView.Adapter<RestaurantVH> {
    RestaurantInterface restaurantInterface;
    RestaurantDBModel rDBm;
    ArrayList<Restaurant> restaurants;

    public RestaurantAdapter(RestaurantDBModel rDBm, RestaurantInterface restaurantInterface)
    {
        this.rDBm = rDBm;
        this.restaurantInterface = restaurantInterface;
        restaurants = rDBm.getAllRestaurant();
    }

    @NonNull
    @Override
    public RestaurantVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.special_menu, parent, false);
        RestaurantVH viewHolder = new RestaurantVH(view, restaurantInterface);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RestaurantVH holder, int position) {
        holder.textView.setText(restaurants.get(position).getName());
        holder.imageView.setImageResource(restaurants.get(position).getImg());
    }

    @Override
    public int getItemCount() {
        return restaurants.size();
    }
}
