package com.example.workouttrackerbeta;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.workouttrackerbeta.databinding.ActivityHomeBinding;


public class HomeActivity extends AppCompatActivity {
    private ActivityHomeBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Setting binding object to current view
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home);

        binding.workoutIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "R.string.input_fields_empty", Toast.LENGTH_SHORT).show();
            }
        });
    }
}