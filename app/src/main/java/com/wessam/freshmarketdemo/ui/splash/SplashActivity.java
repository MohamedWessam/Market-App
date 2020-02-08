package com.wessam.freshmarketdemo.ui.splash;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.wessam.freshmarketdemo.R;
import com.wessam.freshmarketdemo.databinding.ActivitySplashBinding;
import com.wessam.freshmarketdemo.model.storage.SharedPreferenceManager;
import com.wessam.freshmarketdemo.ui.home.HomeActivity;
import com.wessam.freshmarketdemo.ui.onboarding.OnBoardingActivity;
import com.wessam.freshmarketdemo.ui.splash.presenter.SplashPresenter;
import com.wessam.freshmarketdemo.ui.splash.presenter.SplashPresenterImpl;

public class SplashActivity extends AppCompatActivity implements SplashView {

    private ActivitySplashBinding mBinding;
    private SplashPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_splash);

        mPresenter = new SplashPresenterImpl(this, SharedPreferenceManager.getInstance());

        mPresenter.decideNextActivity();

        animateSplashLogo();
        animateProgressbar();
    }

    /**
     * make zoom in animation to the logo image view.
     */
    private void animateSplashLogo() {
        Animation zoomInAnimation = AnimationUtils.loadAnimation(this, R.anim.zoom_in);
        zoomInAnimation.setStartOffset(500);
        mBinding.splashLogoImage.startAnimation(zoomInAnimation);
    }

    /**
     * make alpha animation to progress bar
     * to make progress bar appears after
     * logo animation finishes
     */
    private void animateProgressbar() {
        mBinding.splashProgressbar.setAlpha(0);
        mBinding.splashProgressbar.animate().alpha(1f).setStartDelay(1600).setDuration(200).start();
    }

    @Override
    public void navigateToOnBoardingActivity() {
        startActivity(new Intent(SplashActivity.this, OnBoardingActivity.class));
        finish();
    }

    @Override
    public void navigateToHomeActivity() {
        startActivity(new Intent(SplashActivity.this, HomeActivity.class));
        finish();
    }

}