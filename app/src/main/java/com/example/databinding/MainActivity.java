package com.example.databinding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;

import com.example.databinding.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    // activity binding object
    ActivityMainBinding binding;
    MainViewModel mainViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // set the layout using and get the reference in binding object
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        // get the viewModel
        mainViewModel = new ViewModelProvider(this, new MainViewModelFactory(this))
                .get(MainViewModel.class);

        // set the viewmodel
        binding.setViewmodel(mainViewModel);
    }

    // change the data in viewmodel
    // layout will automatically get the data
    // because data is bind with layout
    public void onNext(View view) {
        mainViewModel.nextName();
        // it is not automatically updating the new name in layout
        // while it is updated in the variable which is holding the name
        // so refreshing will make the layout again put the variable values
        // but this time it will be the new value/name.
        recreate();
    }
}