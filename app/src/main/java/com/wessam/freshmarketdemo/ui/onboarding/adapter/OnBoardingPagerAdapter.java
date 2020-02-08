package com.wessam.freshmarketdemo.ui.onboarding.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.wessam.freshmarketdemo.ui.onboarding.fragment.OnBoardingItemFragment;

public class OnBoardingPagerAdapter extends FragmentPagerAdapter {

    public OnBoardingPagerAdapter(FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return OnBoardingItemFragment.newInstance(position);
    }

    @Override
    public int getCount() {
        return 3;
    }

}
