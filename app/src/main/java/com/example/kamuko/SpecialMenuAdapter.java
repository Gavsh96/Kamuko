package com.example.kamuko;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class SpecialMenuAdapter extends RecyclerView.Adapter<SpecialMenuVH> {

    DBModel dbModel;
    ArrayList<Menu> menuList = new ArrayList<>();
    Random rand = new Random();

    public SpecialMenuAdapter(DBModel dbModel)
    {
        this.dbModel = dbModel;
        ArrayList<Menu> allMenu = dbModel.getAllMenu();
        ArrayList<Integer> list = new ArrayList<>();
        int temp;

        for(int i = 1; i < 54; i++)
        {
            list.add(i);
        }
        Collections.shuffle(list);
        for (int i = 0; i < 10; i++)
        {
            menuList.add(allMenu.get(list.get(i)));
        }
    }

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
        holder.textView.setText(menuList.get(position).getName());
        holder.imageView.setImageResource(menuList.get(position).getImg());
    }

    @Override
    public int getItemCount() {
        return menuList.size();
    }
}
