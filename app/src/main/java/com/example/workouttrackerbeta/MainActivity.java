package com.example.workouttrackerbeta;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;


import com.example.workouttrackerbeta.databinding.ActivityCreateProfileBinding;

public class MainActivity extends AppCompatActivity {
    //Creating binding object to access layout views
    private ActivityCreateProfileBinding binding;
    // Instance variables that will hold user profile information
    private String firstName;
    private String lastName;
    private long height;
    private long weight;


    // Creating shared preference object to store user profile data
    private SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_profile);

        // Instantiating shared preference object to hold basic user information.
        sp = getSharedPreferences("UserInfo", Context.MODE_PRIVATE);

        // Instantiating main binding to activity_main view.
        binding = DataBindingUtil.setContentView(this, R.layout.activity_create_profile);

        // This is the create profile button that takes user to next activity
        binding.loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Validating user input
                if(binding.firstName.length() == 0 || binding.lastName.length() == 0
                  || binding.height.length() == 0 || binding.weight.length() == 0){
                    Toast.makeText(v.getContext(), R.string.input_fields_empty, Toast.LENGTH_SHORT).show();
                } else if(!isNumber(binding.height.getText().toString()) || !isNumber(binding.weight.getText().toString())){
                    Toast.makeText(v.getContext(), R.string.invalid_number_format, Toast.LENGTH_SHORT).show();
                } else if(!isCheckedCorrectly(findViewById(R.id.inches), findViewById(R.id.cm))){
                    Toast.makeText(v.getContext(), R.string.check_inch_or_cm, Toast.LENGTH_SHORT).show();
                } else if(!isCheckedCorrectly(findViewById(R.id.lbs), findViewById(R.id.kg))){
                    Toast.makeText(v.getContext(), R.string.check_lbs_or_kg, Toast.LENGTH_SHORT).show();
                } else {
                    // Storing user entered data in instance variable
                    firstName = binding.firstName.getText().toString();
                    lastName = binding.lastName.getText().toString();
                    height = Long.parseLong(binding.height.getText().toString());
                    weight = Long.parseLong(binding.weight.getText().toString());

                    // Storing instance variable user data in shared preference
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putString("firstName", firstName);
                    editor.putString("lastName", lastName);
                    editor.putLong("height", height);
                    editor.putLong("height", weight);
                    editor.apply();
                    // Calling method to go to next next activity page (username and password)
                    openUserHome();
                }
            }
        });
    }
    // This method is called by the create profile button and takes the user to the home activity page.
    private void openUserHome() {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }

    // This method is used to make sure the height and weight entered are number characters.
    private boolean isNumber(String input){
        try{
            Integer.parseInt(input);
        } catch(NumberFormatException e){
            return false;
        }
        return true;
    }

    // This method makes sure that the check boxes are checked in the correct way.
    private boolean isCheckedCorrectly(View v, View z){
        CheckBox checkBoxOne = (CheckBox) v;
        CheckBox checkBoxTwo = (CheckBox) z;
        if(!checkBoxOne.isChecked() && !checkBoxTwo.isChecked()){
           return false;
        } else if(checkBoxOne.isChecked() && checkBoxTwo.isChecked()){
            return false;
        }
        return true;
    }


}