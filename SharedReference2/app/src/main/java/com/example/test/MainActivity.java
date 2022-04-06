package com.example.test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;

import com.example.test.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    MyViewModel viewModel;
    ActivityMainBinding dataBinding;
    public final static String KEY = "my_key";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        viewModel = new ViewModelProvider(this).get(MyViewModel.class);

        dataBinding.setData(viewModel);
        dataBinding.setLifecycleOwner(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        viewModel.Save();
        Log.d("Test", "onPause: " +String.valueOf(viewModel.getNumber().getValue()));
    }
}