package com.example.databinding;

import android.content.Context;
import android.media.MediaCodec;

import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.Arrays;

public class MainViewModel extends ViewModel {

    Context context;
    String[] FirstNamesStringArray;
    String[] SecondNamesStringArray;

    public String first_name;
    public String second_name;

    // to integrate in names list
    int count = 1;
    int total_names;

    // constructor to get the context
    public MainViewModel(Context context) {
        this.context = context;
        initializeData();
    }

    // get the data from resources and pass it to the LiveData objects
    public void initializeData() {
        FirstNamesStringArray = context.getResources().getStringArray(R.array.first_names);
        SecondNamesStringArray = context.getResources().getStringArray(R.array.second_names);

        // get the first name out of the String array
        first_name = FirstNamesStringArray[0];
        second_name = SecondNamesStringArray[0];
        total_names = FirstNamesStringArray.length;
    }

    // get the next name data
    public void nextName() {
        first_name = FirstNamesStringArray[count%total_names];
        second_name = SecondNamesStringArray[count%total_names];
        count++;          // increase the count value to get next name at next click
    }
}