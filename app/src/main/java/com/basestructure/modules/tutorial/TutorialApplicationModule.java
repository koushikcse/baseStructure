package com.basestructure.modules.tutorial;

import android.app.Activity;

import dagger.Module;

/**
 * Created by innofied on 30/3/18.
 */
@Module
public class TutorialApplicationModule {
    private Activity activity;

    public TutorialApplicationModule(Activity activity) {
        this.activity = activity;
    }
}
