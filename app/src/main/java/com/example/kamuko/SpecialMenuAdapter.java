package com.example.kamuko;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class SpecialMenuAdapter extends RecyclerView.Adapter<SpecialMenuVH> {
    @NonNull
    @Override
    public SpecialMenuVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.special_menu, parent, false);
        SpecialMenuVH viewHolder = new SpecialMenuVH(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull SpecialMenuVH holder, int position) {
        holder.textView.setText("Test Restaurant Name");
        holder.imageView.setImageResource(R.drawable.hamburger);
    }

    @Override
    public int getItemCount() {
        return 12;
    }
}
