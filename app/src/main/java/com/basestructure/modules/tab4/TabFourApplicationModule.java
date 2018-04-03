package com.basestructure.modules.tab4;

import android.app.Activity;

import dagger.Module;

/**
 * Created by innofied on 3/4/18.
 */
@Module
public class TabFourApplicationModule {
    private Activity activity;

    public TabFourApplicationModule(Activity activity) {
        this.activity = activity;
    }
}
