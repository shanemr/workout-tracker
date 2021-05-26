package com.example.workouttrackerbeta;

import android.os.Bundle;

import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.workouttrackerbeta.databinding.ActivityWorkoutBinding;

public class WorkoutActivity extends AppCompatActivity {
    private ActivityWorkoutBinding binding;
    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout);

        // Setting binding object to current view
        binding = DataBindingUtil.setContentView(this, R.layout.activity_workout);


    }
}