package com.example.harkkatyo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.example.harkkatyo.fragments.FragmentHome;
import com.example.harkkatyo.fragments.FragmentTraining;
import com.google.android.material.tabs.TabLayout;

public class TabActivity extends AppCompatActivity {

    private TabPagerAdapter tabPagerAdapter;
    private ViewPager2 viewPager;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);

        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);
        tabPagerAdapter = new TabPagerAdapter(this);
        viewPager.setAdapter(tabPagerAdapter);

        tabLayout.addTab(tabLayout.newTab().setText("Koti"));
        tabLayout.addTab(tabLayout.newTab().setText("Treeni"));
        tabLayout.addTab(tabLayout.newTab().setText("Taistelu"));
        tabLayout.addTab(tabLayout.newTab().setText("RIP"));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                tabLayout.getTabAt(position).select();
            }
        });
    }

    public void moveLutemons() {
        Fragment currentFragment = tabPagerAdapter.createFragment(viewPager.getCurrentItem());
        if (currentFragment instanceof FragmentHome) {
            ((FragmentHome) currentFragment).moveLutemons();
        }
        if (currentFragment instanceof FragmentTraining) {
            //((FragmentTraining) currentFragment).moveLutemons();
        }
    }
}