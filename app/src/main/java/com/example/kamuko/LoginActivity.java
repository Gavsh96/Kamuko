package com.example.kamuko;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;

import com.example.kamuko.databinding.ActivityMainBinding;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        DBModel rDBm = new DBModel();
        rDBm.load(getApplicationContext());

        Intent intent = getIntent();
        String id = intent.getStringExtra("id");

        if(id != null)
        {
            Fragment fragment = new MenuDescFragment();
            Bundle args = new Bundle();
            args.putString("menuID", id);
            fragment.setArguments(args);
            FragmentManager frag = getSupportFragmentManager();
            frag.beginTransaction().add(R.id.LAfragment1, fragment).commit();
        }
        else
        {
            FragmentManager frag = getSupportFragmentManager();
            LoginFrag loginFrag = (LoginFrag) frag.findFragmentById(R.id.LAfragment1);
            loginFrag = new LoginFrag();
            frag.beginTransaction().add(R.id.LAfragment1, loginFrag).commit();
        }
    }
}