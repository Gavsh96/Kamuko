package com.example.kamuko;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView restImage = findViewById(R.id.restImage);

        RestaurantDBModel rDBm = new RestaurantDBModel();
        rDBm.load(getApplicationContext());
        CreateRestaurants(rDBm);

        FragmentManager frag = getSupportFragmentManager();
        SpecialMenuFragment specialMenuFragment = (SpecialMenuFragment) frag.findFragmentById(R.id.frameLayout);
        specialMenuFragment = new SpecialMenuFragment(rDBm);
        frag.beginTransaction().add(R.id.frameLayout, specialMenuFragment).commit();

        restImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Found no other way to transfer an object from one activity to another
                // But using this way creates a class cast exception.
                ArrayList<Restaurant> list = rDBm.getAllRestaurant();

                Intent intent = new Intent(MainActivity.this, RestaurantActivity.class);
                intent.putParcelableArrayListExtra("ParceledRestaurant", list);
                startActivity(intent);
            }
        });
    }

    private void CreateRestaurants(RestaurantDBModel rDBm)
    {
        Restaurant r1 = new Restaurant("1234", "Shamika's Chicken Shop", "kukula");
        Restaurant r2 = new Restaurant("1235", "Akbho Bell", "taco");
        Restaurant r3 = new Restaurant("1236", "Gav's Pizza", "pizza");
        Restaurant r4 = new Restaurant("1237", "Hindiye kade", "roti");
        Restaurant r5 = new Restaurant("1238", "Beepan plaintea", "tea");

        rDBm.addRestaurant(r1);
        rDBm.addRestaurant(r2);
        rDBm.addRestaurant(r3);
        rDBm.addRestaurant(r4);
        rDBm.addRestaurant(r5);
    }
}