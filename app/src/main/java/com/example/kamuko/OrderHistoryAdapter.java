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
    private ArrayList<OrderHistory> oH2;
    private Iterator<OrderHistory> itU;
    private ArrayList<LoggedIn> lI;
    private String uID;

    public OrderHistoryAdapter(DBModel rDBm)
    {
        this.rDBm = rDBm;
        oH = rDBm.getAllOrderHistory();
        lI = rDBm.getAllLoggedIn();

       /* if(!lI.isEmpty() && !oH.isEmpty()) {
            uID = lI.get(0).getUserId();
            searchOH(uID);
        }*/
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
        holder.restName.setText(oH.get(position).getRestaurantName());
        holder.items.setText(oH.get(position).getItems());
        holder.cost.setText(oH.get(position).getCost().toString());
        holder.date.setText(oH.get(position).getDate());
        holder.time.setText(oH.get(position).getTime());
    }

    @Override
    public int getItemCount() {
        return oH.size();
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
