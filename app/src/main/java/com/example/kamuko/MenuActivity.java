package com.example.kamuko;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Intent intent = getIntent();
        String id = intent.getStringExtra("id");

        DBModel rDBm = new DBModel();
        rDBm.load(getApplicationContext());

        RecyclerView rv = findViewById(R.id.MenuRecyclerView);
        rv.setLayoutManager(new LinearLayoutManager(this));
        MenuAdapter adapter = new MenuAdapter(rDBm, id);
        rv.setAdapter(adapter);
    }
}