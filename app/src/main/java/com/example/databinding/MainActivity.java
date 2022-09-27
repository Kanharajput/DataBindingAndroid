package com.example.databinding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;

import com.example.databinding.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    // activity binding object
    ActivityMainBinding binding;
    String[] first_names;
    String[] second_names;
    int total_names;
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // set the layout using and get the reference in binding object
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        // set default names
        binding.firstNameTxt.setText("Kanha");
        binding.secondNameTxt.setText("Tomar");

        // getting the array of names from resources
        first_names = getResources().getStringArray(R.array.first_names);
        second_names = getResources().getStringArray(R.array.second_names);
        total_names = first_names.length;

        binding.nextNameBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.firstNameTxt.setText(first_names[count%total_names]);
                binding.secondNameTxt.setText(second_names[count%total_names]);
                count++;
            }
        });
    }
}