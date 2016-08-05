package com.sean.nanastudio.seanutilsample;

import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;


import seantool.SeanTool;
import seantool.viewpager.ViewPagerAdapter;

public class MainActivity extends AppCompatActivity  {

    private static SeanTool seanTool;
    private DrawerLayout drawerLayout;
    private final static String TEST_TITLE = "TEST!!";
    private final static String TEST_MESSAGE = "This is test..";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seanTool = SeanTool.getInstance(this);

        findViewById(R.id.fab).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                seanTool.getNotifyTool().showShortSnackBar(findViewById(R.id.fab), "This is snack bar");
                seanTool.getNotifyTool().showLongSnackBarWithAction(findViewById(R.id.fab),
                        "This is snack bar..",
                        "notify",
                        new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                seanTool.getNotifyTool().sentSimpleNotification(
                                        "On click",
                                        "Snack bar is on click!"
                                );
                            }
                        });
            }
        });

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        if (navigationView != null) {
            setupDrawerContent(navigationView);
        }

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        if (viewPager != null) {
            setupViewPager(viewPager);
        }

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        menuItem.setChecked(true);
                        drawerLayout.closeDrawers();
                        return true;
                    }
                });
    }


    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter viewPagerAdapter =
                new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragment(new TestFragment(),"Test 1");
        viewPagerAdapter.addFragment(new TestFragment(),"Test 2");
        viewPagerAdapter.addFragment(new TestFragment(),"Test 3");
        viewPager.setAdapter(viewPagerAdapter);
    }





}
