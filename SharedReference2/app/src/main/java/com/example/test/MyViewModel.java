package com.example.test;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;

public class MyViewModel extends AndroidViewModel {

    private SavedStateHandle handle;

    public MyViewModel(Application application, SavedStateHandle handel){
        super(application);
        this.handle = handel;
    }

    public MutableLiveData<Integer> getNumber() {
        if(!handle.contains(MainActivity.KEY))
        {
            Load();
            Log.d("Test", "getNumber: "+ String.valueOf(handle.getLiveData(MainActivity.KEY)));
        }
        return handle.getLiveData(MainActivity.KEY);
    }

    public void Add(int n){
        getNumber().setValue(getNumber().getValue() + n);
    }

    public void Save()
    {
        SharedPreferences shp = getApplication().getSharedPreferences("MY_DATA", Context.MODE_PRIVATE);
        SharedPreferences.Editor edt = shp.edit();
        edt.putInt("NUMBER", getNumber().getValue());
        edt.apply();
    }

    public void Load()
    {
        SharedPreferences shp  = getApplication().getSharedPreferences("MY_DATA", Context.MODE_PRIVATE);
        int x = shp.getInt("NUMBER", 0);
        Log.d("Test", "Load: " +String.valueOf(x));
        handle.set(MainActivity.KEY, x);
    }
}
