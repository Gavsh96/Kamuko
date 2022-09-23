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
    CartInterface cartInterface;

    public CartAdapter(DBModel rDBm, CartInterface cartInterface)
    {
        this.rDBm = rDBm;
        //list = rDBm.getAllCartData();
        list = MainActivity.theCart.getCart();
        this.cartInterface = cartInterface;
    }

    @NonNull
    @Override
    public CartVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.cart_design, parent, false);
        CartVH viewHolder = new CartVH(view, cartInterface);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CartVH holder, int position) {
        holder.name.setText(list.get(position).getMenuName());
        holder.qty.setText(String.valueOf(list.get(position).getCount()));
        holder.Price.setText(String.valueOf(list.get(position).getPrice()));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
