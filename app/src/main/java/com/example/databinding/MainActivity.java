package com.example.databinding;

/* One way binding in which data flow in only one side
* like here data is flowing only from viewmodel to ui not ui to viewmodel
* this is know as one way binding.
* Two way binding is the flow of data on both side
* */

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
        // liveData is lifecycle aware so here we are setting this activity as owner.
        // and let the bindind know about this so it will automatically update the new data
        // like we do with the help of observer
        binding.setLifecycleOwner(this);
    }
}