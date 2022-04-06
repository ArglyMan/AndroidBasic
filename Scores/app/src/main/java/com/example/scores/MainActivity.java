package com.example.scores;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.example.scores.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    MyViewModel viewModel;
    ActivityMainBinding databind;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        databind = DataBindingUtil.setContentView(this, R.layout.activity_main);
        viewModel = new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(MyViewModel.class);
        databind.setData(viewModel);
        databind.setLifecycleOwner(this);
    }
}