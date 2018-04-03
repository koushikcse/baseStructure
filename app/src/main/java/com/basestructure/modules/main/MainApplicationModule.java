package com.basestructure.modules.main;

import android.app.Activity;

import dagger.Module;

/**
 * Created by innofied on 3/4/18.
 */
@Module
public class MainApplicationModule {
    private Activity activity;

    public MainApplicationModule(Activity activity) {
        this.activity = activity;
    }
}
