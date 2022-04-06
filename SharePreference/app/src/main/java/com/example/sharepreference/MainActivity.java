package com.example.sharepreference;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        MyData data = new MyData(getApplicationContext());

        data.number = 300;
        data.Save();

        Log.d("Test", "onCreate: " + String.valueOf(data.Load()));
    }
}