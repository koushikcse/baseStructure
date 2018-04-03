package com.basestructure.modules.home;

import android.app.Activity;

import dagger.Module;

/**
 * Created by innofied on 3/4/18.
 */
@Module
public class HomeApplicationModule {
    private Activity activity;

    public HomeApplicationModule(Activity activity) {
        this.activity = activity;
    }
}
