package com.wessam.freshmarketdemo.ui.onboarding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.thekhaeng.pushdownanim.PushDownAnim;
import com.wessam.freshmarketdemo.R;
import com.wessam.freshmarketdemo.databinding.ActivityOnBoardingBinding;
import com.wessam.freshmarketdemo.model.storage.SharedPreferenceManager;
import com.wessam.freshmarketdemo.ui.home.HomeActivity;
import com.wessam.freshmarketdemo.ui.onboarding.adapter.OnBoardingPagerAdapter;
import com.wessam.freshmarketdemo.ui.onboarding.presenter.OnBoardingPresenter;
import com.wessam.freshmarketdemo.ui.onboarding.presenter.OnBoardingPresenterImpl;

public class OnBoardingActivity extends AppCompatActivity implements OnBoardingView {

    private ActivityOnBoardingBinding mBinding;
    private OnBoardingPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_on_boarding);

        PushDownAnim.setPushDownAnimTo(mBinding.getStartedButton);

        presenter = new OnBoardingPresenterImpl(this, SharedPreferenceManager.getInstance());

        OnBoardingPagerAdapter mAdapter = new OnBoardingPagerAdapter(getSupportFragmentManager(),
                FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);

        mBinding.viewPager.setAdapter(mAdapter);

        mBinding.tabs.setupWithViewPager(mBinding.viewPager);

        showGetStartedButton();

        mBinding.getStartedButton.setOnClickListener(view -> presenter.onGetStartedButtonClicked());

    }

    /**
     * show get started button in last fragment
     */
    private void showGetStartedButton() {
        mBinding.viewPager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                if (position == 2) mBinding.getStartedButton.setVisibility(View.VISIBLE);
                else mBinding.getStartedButton.setVisibility(View.INVISIBLE);
            }
        });
    }

    @Override
    public void navigateToHomeActivity() {
        startActivity(new Intent(OnBoardingActivity.this, HomeActivity.class));
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        finish();
    }

}