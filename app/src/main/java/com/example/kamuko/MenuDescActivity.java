package com.example.kamuko;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MenuDescActivity extends AppCompatActivity {

    ImageView img;
    TextView text;
    TextView price;
    TextView countView;
    Button addButton;
    Button subButton;
    int pos;
    int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_desc);

        img = findViewById(R.id.menuImage);
        text = findViewById(R.id.menuText);
        price = findViewById(R.id.price);
        addButton = findViewById(R.id.plusButton);
        subButton = findViewById(R.id.minusButton);
        countView = findViewById(R.id.quantity);

        Intent intent = getIntent();
        String id = intent.getStringExtra("menuID");

        DBModel rDBm = new DBModel();
        rDBm.load(getApplicationContext());

        ArrayList<Menu> allMenu = rDBm.getAllMenu();
        pos = 0;
        count = 0;

        for(int i = 0; i < allMenu.size(); i++)
        {
            if(allMenu.get(i).getId().equals(id))
            {
                pos = i;
            }
        }

        img.setImageResource(allMenu.get(pos).getImg());
        text.setText(allMenu.get(pos).getDescription());
        price.setText(String.valueOf(allMenu.get(pos).getPrice()));
        countView.setText(String.valueOf(count));

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count = count + 1;
                countView.setText(String.valueOf(count));
                ArrayList<Cart> cart = rDBm.getAllCartItems();
                if(!cart.isEmpty())
                {
                    for (Cart item: cart)
                    {
                        if(item.getId().equals(allMenu.get(pos).getId()))
                        {
                            rDBm.removeCartItem(item);
                            rDBm.addCartItem(new Cart(allMenu.get(pos).getId(), count));
                            Log.d("Item", "Previous Cart item removed and new added |Count: "+item.getCount()+" ID : "+item.getId());
                        }
                    }
                }
                else
                {
                    rDBm.addCartItem(new Cart(allMenu.get(pos).getId(), count));
                    Log.d("Item", "New Cart item added |Count: "+String.valueOf(count)+" ID : "+allMenu.get(pos).getId());
                }
            }
        });
    }
}