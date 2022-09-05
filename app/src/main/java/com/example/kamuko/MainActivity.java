package com.example.kamuko;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager frag = getSupportFragmentManager();
        SpecialMenuFragment specialMenuFragment = (SpecialMenuFragment) frag.findFragmentById(R.id.frameLayout);

        specialMenuFragment = new SpecialMenuFragment();
        frag.beginTransaction().add(R.id.frameLayout, specialMenuFragment).commit();
    }
}