package com.finalproject.parkbnb;

import android.app.FragmentTransaction;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.FragmentActivity;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;


public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        final String userName = getIntent().getStringExtra("Name");
        //TextView welcome = (TextView) findViewById(R.id.username);
        //welcome.setText("Welcome, " + userName + "!");
        final Configuration config = getResources().getConfiguration();
        BottomBar bottomBar = (BottomBar) findViewById(R.id.bottomBar);
        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {
                if (tabId == R.id.tab_home) {
                    // The tab with id R.id.tab_favorites was selected,
                    // change your content accordingly.

                    HomeFragment hf = new HomeFragment();
                    FragmentTransaction ft = getFragmentManager().beginTransaction();

                    ft.replace(R.id.contentContainer, hf, "NewFragmentTag");
                    ft.commit();
                }
                else if (tabId == R.id.tab_nearby){
                    if (config.orientation == Configuration.ORIENTATION_LANDSCAPE) {
                        FragmentTransaction ft = getFragmentManager().beginTransaction();
                        ft.replace(R.id.contentContainer, new ParkingFragmentHorizontal(), "NewFragmentTag");
                        ft.commit();
                    } else {
                        FragmentTransaction ft = getFragmentManager().beginTransaction();
                        ft.replace(R.id.contentContainer, new ParkingFragmentVertical(), "NewFragmentTag");
                        ft.commit();
                    }
                }
                else if (tabId == R.id.tab_add){

                    FragmentTransaction ft = getFragmentManager().beginTransaction();

                    ft.replace(R.id.contentContainer, new AddParkingFragment(), "NewFragmentTag");
                    ft.commit();
                }
                else if (tabId == R.id.tab_information){
                    FragmentTransaction ft = getFragmentManager().beginTransaction();

                    ft.replace(R.id.contentContainer, new SettingsFragment(), "NewFragmentTag");
                    ft.commit();
                }

            }
        });
    }
}
