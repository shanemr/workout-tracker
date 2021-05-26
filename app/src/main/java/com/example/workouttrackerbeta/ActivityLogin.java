package com.example.workouttrackerbeta;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.workouttrackerbeta.databinding.ActivityLoginBinding;


public class ActivityLogin extends AppCompatActivity {
    //Creating binding object to access layout views
    private ActivityLoginBinding binding;

    @Override
    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Setting binding object to current view
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login);

       // Actions for main login button
        binding.loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Displays an error if all fields are not entered.
                if(binding.username.length() == 0 || binding.password.length() == 0){
                    Toast.makeText(v.getContext(), R.string.input_fields_empty, Toast.LENGTH_SHORT).show();
                } else {
                    openHomePage();
                }
            }
        });

        // Sign up button action --> takes user to create an account activity page
        binding.initialSignUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCreatePage();
            }
        });
    }

    // Method that takes user to home page activity screen.
    private void openHomePage() {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }

    // Method that takes user to the create account activity page
    private void openCreatePage() {
        Intent intent = new Intent(this, ActivityCreateAccount.class);
        startActivity(intent);
    }
}