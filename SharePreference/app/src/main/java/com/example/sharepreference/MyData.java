package com.example.sharepreference;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.Preference;

public class MyData {
    public Integer number;
    public Context context;

    public MyData(Context context){
        this.context = context;
    }

    public void Save(){
        SharedPreferences shp = context.getSharedPreferences("My_DATA", Context.MODE_PRIVATE);
        SharedPreferences.Editor edt = shp.edit();
        edt.putInt("NUMBER", number);
        edt.apply();
    }

    public int Load(){
        SharedPreferences shp = context.getSharedPreferences("MY_DATA", Context.MODE_PRIVATE);
        shp.getInt("NUMBER", number);

        return number;
    }
}
