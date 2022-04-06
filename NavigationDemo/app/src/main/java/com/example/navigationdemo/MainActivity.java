package com.example.navigationdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NavHostFragment framgment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentContainerView);

        NavController controller = framgment.getNavController();
        NavigationUI.setupActionBarWithNavController(this, controller);
//        NavController controller = Navigation.findNavController(this, R.id.fragmentContainerView);
//        NavigationUI.setupActionBarWithNavController(this, Navigation.findNavController(this, R.id.fragmentContainerView));
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavHostFragment fragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentContainerView);
        NavController controller = fragment.getNavController();
        return controller.navigateUp();
    }
}