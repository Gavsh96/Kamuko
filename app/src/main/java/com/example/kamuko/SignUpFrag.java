package com.example.kamuko;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class SignUpFrag extends Fragment {

    TextView userIdText;
    TextView passwordText;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sign_up,container,false);

        userIdText = view.findViewById(R.id.userIdText);
        passwordText = view.findViewById(R.id.passwordText);

        userIdText.setText("User ID");
        passwordText.setText("Password");
        return  view;


    }
}