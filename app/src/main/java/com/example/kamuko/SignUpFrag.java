package com.example.kamuko;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.service.autofill.UserData;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Iterator;

public class SignUpFrag extends Fragment {

    private DBModel rDBm;
    private TextView userIdText;
    private EditText userIdIn;
    private TextView passwordText;
    private EditText passwordIn;
    private Button Login;
    private Button Register;
    private Button SignOut;
    private String userID;
    private String password;
    private TextView notification;
    private ArrayList<LoggedIn> loggedIn;
    private ArrayList<User> userData;
    private Iterator<User> itU;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sign_up, container, false);

        rDBm = new DBModel();
        rDBm.load(getActivity().getApplicationContext());

        loggedIn = rDBm.getAllLoggedIn();
        userData = rDBm.getAllUser();

        userIdText = view.findViewById(R.id.userIdText);
        passwordText = view.findViewById(R.id.passwordText);
        userIdIn = view.findViewById(R.id.userIdIn);
        passwordIn = view.findViewById(R.id.passwordIn);
        Login = view.findViewById(R.id.loginBt);
        Register = view.findViewById(R.id.registerBt);
        SignOut = view.findViewById(R.id.signoutBt);
        notification = view.findViewById(R.id.notification);

        SignOut.setEnabled(!loggedIn.isEmpty());
        userIdIn.addTextChangedListener(textDetector);
        passwordIn.addTextChangedListener(textDetector);

        userIdText.setText("User ID");
        passwordText.setText("Password");

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userID = userIdIn.getText().toString();
                password = passwordIn.getText().toString();

                User user = searchUser(userID, password);
                if (user != null)
                {
                    rDBm.deleteAllLoggedIn();
                    LoggedIn lI = new LoggedIn(user.getUserId(), user.getName());
                    rDBm.addLoggedIn(lI);
                    String name = user.getName();
                    notification.setText(name+" logged in !");
                    loggedIn = rDBm.getAllLoggedIn();
                }
                else
                {
                    notification.setText("This user is not registered !");
                }

                if(!loggedIn.isEmpty() && loggedIn.size() < 2)
                {
                    notification.setText("wade hari !");
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
            String inputId = userIdIn.getText().toString().trim();
            String inputPassword = passwordIn.getText().toString().trim();

            Login.setEnabled(!inputId.isEmpty() && !inputPassword.isEmpty());
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };

    private User searchUser(String userID, String password)
    {
        itU = userData.iterator();

        while (itU.hasNext())
        {
            User user = itU.next();
            if(user.getUserId().equals(userID) && user.getPassword().equals(password))
            {
                return user;
            }
        }
        return null;
    }

}