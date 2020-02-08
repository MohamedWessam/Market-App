package com.wessam.freshmarketdemo.ui.onboarding.presenter;

import com.wessam.freshmarketdemo.constants.SharedPrefConstants;
import com.wessam.freshmarketdemo.model.storage.SharedPreferenceManager;
import com.wessam.freshmarketdemo.ui.onboarding.OnBoardingView;

public class OnBoardingPresenterImpl implements OnBoardingPresenter {

    private OnBoardingView view;
    private SharedPreferenceManager preferenceManager;

    public OnBoardingPresenterImpl(OnBoardingView view, SharedPreferenceManager preferenceManager) {
        this.view = view;
        this.preferenceManager = preferenceManager;
    }

    @Override
    public void onGetStartedButtonClicked() {
        preferenceManager.put(SharedPrefConstants.IS_ON_BOARDING_SCREEN_DISPLAYED, true);
        view.navigateToHomeActivity();
    }

}
