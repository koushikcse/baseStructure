package com.basestructure.modules.splash;

import android.app.Activity;

import dagger.Module;

/**
 * Created by innofied on 29/3/18.
 */
@Module
public class SplashApplicationModule {
    private Activity activity;

    public SplashApplicationModule(Activity activity) {
        this.activity = activity;
    }
}
