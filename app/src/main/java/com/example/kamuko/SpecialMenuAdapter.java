package com.example.kamuko;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Random;

public class SpecialMenuAdapter extends RecyclerView.Adapter<SpecialMenuVH> {

    RestaurantDBModel dbModel;
    ArrayList<Menu> menuList = new ArrayList<>();
    Random rand = new Random();

    public SpecialMenuAdapter(RestaurantDBModel dbModel)
    {
        this.dbModel = dbModel;
        ArrayList<Menu> allMenu = dbModel.getAllMenu();
        int temp;

        // There is a chance to contain duplicate values.
        // They should be removed later
        for(int i = 0; i < 8; i++)
        {
            // This is done temporarily until all restaurants and their menus are generated.
            temp = rand.nextInt(30-13) + 13;
            for (Menu menu: allMenu) {
                if(menu.getId().equals(String.valueOf(temp)))
                {
                    menuList.add(menu);
                }
            }
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
