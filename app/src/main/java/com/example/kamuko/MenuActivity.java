package com.example.kamuko;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class MenuActivity extends AppCompatActivity implements MenuInterface{

    ArrayList<Menu> list;
    ArrayList<Menu> menuList = new ArrayList<>();
    String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Intent intent = getIntent();
        id = intent.getStringExtra("id");

        DBModel rDBm = new DBModel();
        rDBm.load(getApplicationContext());
        list = rDBm.getAllMenu();

        RecyclerView rv = findViewById(R.id.MenuRecyclerView);
        rv.setLayoutManager(new LinearLayoutManager(this));
        MenuAdapter adapter = new MenuAdapter(rDBm, id, this);
        rv.setAdapter(adapter);
    }

    @Override
    public void onMenuClick(int position) {

        for (Menu menu: list)
        {
            if(menu.getRestId().equals(id))
            {
                menuList.add(menu);
            }
        }

        Intent intent = new Intent(this, MenuDescActivity.class);
        intent.putExtra("menuID", menuList.get(position).getId());
        startActivity(intent);
    }
}