package com.wessam.freshmarketdemo.ui.splash.presenter;

import android.os.Handler;

import com.wessam.freshmarketdemo.constants.SharedPrefConstants;
import com.wessam.freshmarketdemo.model.storage.SharedPreferenceManager;
import com.wessam.freshmarketdemo.ui.splash.SplashView;

public class SplashPresenterImpl implements SplashPresenter {

    private SplashView view;
    private SharedPreferenceManager preferenceManager;
    private static final int SPLASH_DELAY_TIME = 3500;

    public SplashPresenterImpl(SplashView view, SharedPreferenceManager preferenceManager) {
        this.view = view;
        this.preferenceManager = preferenceManager;
    }

    /**
     * check if the on boarding screen had been displayed before
     */
    @Override
    public void decideNextActivity() {
        new Handler().postDelayed(() -> {

            if (preferenceManager.getBoolean(SharedPrefConstants.IS_ON_BOARDING_SCREEN_DISPLAYED, false))
                view.navigateToHomeActivity();
            else
                view.navigateToOnBoardingActivity();

        }, SPLASH_DELAY_TIME);
    }

}
