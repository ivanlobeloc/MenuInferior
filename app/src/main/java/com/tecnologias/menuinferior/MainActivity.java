package com.tecnologias.menuinferior;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Fragment home = new Fragment_home();
        final Fragment dash =  new Fragment_Dashboard();
        final Fragment notif = new Fragment_notifications();

        if(savedInstanceState == null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.content_main, new Fragment_home()).commit();
        }

        bottomNavigationView = (BottomNavigationView) findViewById(R.id.navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

               FragmentManager fragmentManager = getSupportFragmentManager();
               FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
               fragmentTransaction.addToBackStack(null);

                if (item.getItemId() == R.id.home) {
                    fragmentTransaction.replace(R.id.content_main, home).commit();
                } else if (item.getItemId() == R.id.dashboard) {
                    fragmentTransaction.replace(R.id.content_main, dash).commit();
                } else if (item.getItemId() == R.id.notifications) {
                    fragmentTransaction.replace(R.id.content_main, notif).commit();
                }
                return true;
            }
        });//*


    }

}
