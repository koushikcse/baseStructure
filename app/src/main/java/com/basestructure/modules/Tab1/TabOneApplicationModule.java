package com.basestructure.modules.Tab1;

import android.app.Activity;

import dagger.Module;

/**
 * Created by innofied on 3/4/18.
 */
@Module
public class TabOneApplicationModule {
    private Activity activity;

    public TabOneApplicationModule(Activity activity) {
        this.activity = activity;
    }
}
