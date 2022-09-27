package com.example.databinding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.example.databinding.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    // activity binding object
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // set the layout using and get the reference in binding object
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        binding.firstNameTxt.setText("kanha");
        binding.secondNameTxt.setText("Tomar");

    }
}