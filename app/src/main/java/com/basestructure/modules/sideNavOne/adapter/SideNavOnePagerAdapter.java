package com.basestructure.modules.sideNavOne.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.basestructure.modules.sideNavOne.subTab.SubTabFragment;

/**
 * Created by innofied on 4/4/18.
 */

public class SideNavOnePagerAdapter extends FragmentPagerAdapter {

    public SideNavOnePagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return SubTabFragment.newInstance(position);
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Sub Tab 1";
            case 1:
                return "Sub Tab 2";
            case 2:
                return "Sub Tab 3";
        }
        return null;
    }
}
