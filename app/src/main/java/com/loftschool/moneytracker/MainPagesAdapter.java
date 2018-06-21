package com.loftschool.moneytracker;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class MainPagesAdapter extends FragmentPagerAdapter {

    public MainPagesAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        if(position == 0){
            return new ItemsFragment();
        } else if(position==1){
            return new ItemsFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 2;
    }
}