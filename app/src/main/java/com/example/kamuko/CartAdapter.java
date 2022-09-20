package com.example.kamuko;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CartAdapter extends RecyclerView.Adapter<CartVH> {

    DBModel rDBm;
    ArrayList<Cart> list = new ArrayList<>();
    ArrayList<Menu> menuList = new ArrayList<>();
    ArrayList<Menu> temp = new ArrayList<>();

    public CartAdapter(DBModel rDBm)
    {
        this.rDBm = rDBm;
        list = rDBm.getAllCartItems();
        /*menuList = rDBm.getAllMenu();

        for (Menu menu: menuList)
        {
            for (Cart item: list)
            {
                if(item.getId().equals(menu.getId()))
                {
                    temp.add(menu);
                }
            }
        }*/
    }

    @NonNull
    @Override
    public CartVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.cart_design, parent, false);
        CartVH viewHolder = new CartVH(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CartVH holder, int position) {
        holder.name.setText(list.get(position).getId());
        holder.qty.setText("2");
    }

    @Override
    public int getItemCount() {
        return 7;
    }
}
