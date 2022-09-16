package com.example.kamuko;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MenuDescActivity extends AppCompatActivity {

    ImageView img;
    TextView text;
    TextView price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_desc);

        img = findViewById(R.id.menuImage);
        text = findViewById(R.id.menuText);
        price = findViewById(R.id.price);

        Intent intent = getIntent();
        String id = intent.getStringExtra("menuID");

        DBModel rDBm = new DBModel();
        rDBm.load(getApplicationContext());

        ArrayList<Menu> allMenu = rDBm.getAllMenu();
        int pos = 0;

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
    }
}