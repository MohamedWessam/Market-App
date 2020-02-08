package com.wessam.freshmarketdemo.ui.onboarding.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wessam.freshmarketdemo.R;
import com.wessam.freshmarketdemo.databinding.FragmentOnBoardingItemBinding;

public class OnBoardingItemFragment extends Fragment {

    private FragmentOnBoardingItemBinding mBinding;
    private int position;

    public OnBoardingItemFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            position = getArguments().getInt(OnBoardingConstants.ARG_POSITION);
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_on_boarding_item, container, false);

        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // set page title
        mBinding.titleText.setText(OnBoardingConstants.PAGE_TITLES[position]);
        // set page description text
        mBinding.descriptionText.setText(OnBoardingConstants.PAGE_TEXT[position]);
        // set page image
        mBinding.onBoardingImage.setImageResource(OnBoardingConstants.PAGE_IMAGES[position]);
    }

    public static OnBoardingItemFragment newInstance(int position) {
        OnBoardingItemFragment fragment = new OnBoardingItemFragment();
        Bundle                 args     = new Bundle();
        args.putInt(OnBoardingConstants.ARG_POSITION, position);
        fragment.setArguments(args);
        return fragment;
    }


    private final static class OnBoardingConstants {

        private static final String ARG_POSITION = "slider-position";

        // prepare title ids arrays
        private static final int[] PAGE_TITLES = new int[]{
                R.string.on_boarding_title1,
                R.string.on_boarding_title2,
                R.string.on_boarding_title3
        };

        // prepare subtitle ids arrays
        private static final int[] PAGE_TEXT = new int[]{
                R.string.on_boarding_description1,
                R.string.on_boarding_description2,
                R.string.on_boarding_description3
        };

        // prepare image ids arrays
        private static final int[] PAGE_IMAGES = new int[]{
                R.drawable.onboarding_image1,
                R.drawable.onboarding_image2,
                R.drawable.onboarding_image3
        };
    }

}
