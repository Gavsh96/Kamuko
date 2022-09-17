package com.example.kamuko;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

import com.example.kamuko.databinding.ActivityMainBinding;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        DBModel rDBm = new DBModel();
        rDBm.load(getApplicationContext());

        FragmentManager frag = getSupportFragmentManager();
        SignUpFrag signUpFrag = (SignUpFrag) frag.findFragmentById(R.id.LAfragment1);
        signUpFrag  = new SignUpFrag ();
        frag.beginTransaction().add(R.id.LAfragment1, signUpFrag ).commit();

    }
}