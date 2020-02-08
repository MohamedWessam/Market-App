package com.wessam.freshmarketdemo.model.storage;

import android.content.Context;
import android.content.SharedPreferences;

import com.wessam.freshmarketdemo.App;
import com.wessam.freshmarketdemo.constants.SharedPrefConstants;

public final class SharedPreferenceManager {

    private static SharedPreferenceManager INSTANCE;
    private SharedPreferences mSharedPreferences;

    private SharedPreferenceManager() {
        mSharedPreferences = App.getInstance().getApplicationContext()
                .getSharedPreferences(SharedPrefConstants.PREFERENCE_NAME, Context.MODE_PRIVATE);
    }

    public static SharedPreferenceManager getInstance() {
        if (INSTANCE == null) {
            synchronized (SharedPreferenceManager.class) {
                if (INSTANCE == null) INSTANCE = new SharedPreferenceManager();
            }
        }
        return INSTANCE;
    }

    public void put(String key, String value) {
        mSharedPreferences.edit().putString(key, value).apply();
    }

    public void put(String key, int value) {
        mSharedPreferences.edit().putInt(key, value).apply();
    }

    public void put(String key, boolean value) {
        mSharedPreferences.edit().putBoolean(key, value).apply();
    }

    public String getString(String key, String defaultValue) {
        return mSharedPreferences.getString(key, defaultValue);
    }

    public int getInt(String key, int defaultValue) {
        return mSharedPreferences.getInt(key, defaultValue);
    }

    public Boolean getBoolean(String key, Boolean defaultValue) {
        return mSharedPreferences.getBoolean(key, defaultValue);
    }

}
