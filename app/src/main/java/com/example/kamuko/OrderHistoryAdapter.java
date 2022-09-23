package com.example.kamuko;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Iterator;

public class OrderHistoryAdapter extends RecyclerView.Adapter<OrderHistoryVH> {

    private int count = 0;
    private DBModel rDBm;
    private ArrayList<OrderHistory> oH;
    private ArrayList<OrderHistory> oH2 = new ArrayList<>();
    private Iterator<OrderHistory> itU;
    private ArrayList<LoggedIn> lI;
    private String uID;

    public OrderHistoryAdapter(DBModel rDBm)
    {
        this.rDBm = rDBm;
        oH = rDBm.getAllOrderHistory();
        lI = rDBm.getAllLoggedIn();

        uID = lI.get(0).getUserId();
        searchOH(uID);

    }

    @NonNull
    @Override
    public OrderHistoryVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.order_history, parent, false);
        OrderHistoryVH viewHolder = new OrderHistoryVH(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull OrderHistoryVH holder, int position) {
        holder.restName.setText(oH2.get(position).getRestaurantName());
        holder.items.setText(oH2.get(position).getItems());
        holder.cost.setText(oH2.get(position).getCost().toString());
        holder.date.setText(oH2.get(position).getDate());
    }

    @Override
    public int getItemCount() {
        return count;
    }

    private void searchOH(String userID)
    {
        itU = oH.iterator();

        while (itU.hasNext())
        {
            OrderHistory oh = itU.next();
            if(oh.getUserId().equals(userID))
            {
                count++;
                oH2.add(oh);
            }
        }
    }

}
