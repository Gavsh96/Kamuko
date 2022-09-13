package com.example.kamuko;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MenuAdapter extends RecyclerView.Adapter<MenuVH> {
    RestaurantDBModel rDBm;
    ArrayList<Menu> allMenuList;
    ArrayList<Menu> menuList = new ArrayList<>();

    public MenuAdapter(RestaurantDBModel rDBm, String id)
    {
        this.rDBm = rDBm;
        allMenuList = rDBm.getAllMenu();

        for (Menu menu: allMenuList)
        {
            if(menu.getRestId().equals(id))
            {
                menuList.add(menu);
            }
        }
    }
    @NonNull
    @Override
    public MenuVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.special_menu, parent, false);
        MenuVH viewHolder = new MenuVH(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MenuVH holder, int position) {
        holder.textView.setText(menuList.get(position).getName());
        holder.imageView.setImageResource(menuList.get(position).getImg());
    }

    @Override
    public int getItemCount() {
        return menuList.size();
    }
}
