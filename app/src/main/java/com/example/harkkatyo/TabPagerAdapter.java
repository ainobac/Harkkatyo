package com.example.harkkatyo;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.harkkatyo.fragments.FragmentCemetery;
import com.example.harkkatyo.fragments.FragmentFighting;
import com.example.harkkatyo.fragments.FragmentHome;
import com.example.harkkatyo.fragments.FragmentTraining;

import java.util.ArrayList;

public class TabPagerAdapter extends FragmentStateAdapter {

    private ArrayList<Fragment> fragmentList = new ArrayList<>();

    public TabPagerAdapter(FragmentActivity activity) {
        super(activity);
        fragmentList.add(new FragmentHome());
        fragmentList.add(new FragmentTraining());
        fragmentList.add(new FragmentFighting());
        fragmentList.add(new FragmentCemetery());
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getItemCount() {
        return 4;
    }


    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Koti";
            case 1:
                return "Treeni";
            case 2:
                return "Taistelu";
            case 3:
                return "Hautausmaa";
            default:
                return "Koti";
        }
    }

    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }
}
