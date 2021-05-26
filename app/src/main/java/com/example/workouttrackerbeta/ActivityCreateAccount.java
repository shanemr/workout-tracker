package com.example.workouttrackerbeta;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.workouttrackerbeta.databinding.ActivityCreateAccountBinding;
import com.example.workouttrackerbeta.databinding.ActivityLoginBinding;

public class ActivityCreateAccount extends AppCompatActivity {
    //Creating binding object to access layout views
    private ActivityCreateAccountBinding binding;
    // Initializing a shared preference object to later store user login info.
    private SharedPreferences spNewUnPw;
    // Variables to hold new user login info
    private String userName;
    private String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        // Setting binding object to current view
        binding = DataBindingUtil.setContentView(this, R.layout.activity_create_account);
        // Instantiating shared preference object to hold username and password
        spNewUnPw = getSharedPreferences("UserLoginInfo", Context.MODE_PRIVATE);

        // Actions for create profile button
        binding.signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Displays an error if the user did not fill out all appropriate fields.
                if(binding.createUsername.length() == 0 || binding.createPassword.length() == 0){
                    Toast.makeText(v.getContext(), R.string.input_fields_empty, Toast.LENGTH_SHORT).show();
                } else {
                    // Storing user information in instance variables.
                    userName = binding.createUsername.getText().toString();
                    password = binding.createPassword.getText().toString();
                    // Storing user instance variable information in shared preference.
                    SharedPreferences.Editor editor = spNewUnPw.edit();
                    editor.putString("un", userName);
                    editor.putString("pw", password);
                    // Method that takes user to home page activity screen.
                    openHomePage();
                }


            }
        });
    }

    // Method that takes user to home page activity screen.
    private void openHomePage() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}
