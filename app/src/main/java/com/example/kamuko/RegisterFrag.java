package com.example.kamuko;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Iterator;

public class RegisterFrag extends Fragment {

    private DBModel rDBm;
    private TextView emailText;
    private EditText emailIn;
    private TextView passwordText;
    private EditText passwordIn;
    private TextView nameText;
    private EditText nameIn;
    private Button completeReg;
    private TextView notification;
    private ArrayList<LoggedIn> loggedIn;
    private ArrayList<User> userData;
    private Iterator<User> itU;
    private String userID;
    private String password;
    private String name;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_register, container, false);
        rDBm = new DBModel();
        rDBm.load(getActivity().getApplicationContext());

        loggedIn = rDBm.getAllLoggedIn();
        userData = rDBm.getAllUser();

        emailText = view.findViewById(R.id.emailText);
        passwordText = view.findViewById(R.id.passwordText);
        nameText = view.findViewById(R.id.nameText);
        emailIn = view.findViewById(R.id.emailIn);
        passwordIn = view.findViewById(R.id.passwordIn);
        nameIn = view.findViewById(R.id.nameIn);
        completeReg =view.findViewById(R.id.registerBt);
        notification = view.findViewById(R.id.notification);

        emailIn.addTextChangedListener(textDetector);
        nameIn.addTextChangedListener(textDetector);
        passwordIn.addTextChangedListener(textDetector);

        emailText.setText("Email");
        nameText.setText("Full Name");
        passwordText.setText("Password");

        completeReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userID = emailIn.getText().toString();
                password = passwordIn.getText().toString();
                name = nameIn.getText().toString();

                User user = searchUser(userID);
                if (user == null)
                {
                    User newUser = new User(userID,name,password);
                    rDBm.addUser(newUser);
                    rDBm.deleteAllLoggedIn();
                    LoggedIn lI = new LoggedIn(newUser.getUserId(), newUser.getName());
                    rDBm.addLoggedIn(lI);
                    String name = newUser.getName();
                    notification.setText(name+" registered and logged in !");
                }
                else
                {
                    notification.setText("This email is already registered !");
                }
            }
        });

        return view;
    }

    private TextWatcher textDetector = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            String inputId = emailIn.getText().toString().trim();
            String inputName = nameIn.getText().toString().trim();
            String inputPassword = passwordIn.getText().toString().trim();

            completeReg.setEnabled(!inputId.isEmpty() && !inputPassword.isEmpty() && !inputName.isEmpty());
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };

    private User searchUser(String userID)
    {
        itU = userData.iterator();

        while (itU.hasNext())
        {
            User user = itU.next();
            if(user.getUserId().equals(userID))
            {
                return user;
            }
        }
        return null;
    }
}