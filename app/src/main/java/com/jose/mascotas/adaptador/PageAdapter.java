package com.jose.mascotas.adaptador;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by Asus on 11/09/2016.
 */
public class PageAdapter extends FragmentPagerAdapter {
    private List<Fragment> fragments;

    public PageAdapter(FragmentManager fm, List<Fragment> fragments){
        super(fm);
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
