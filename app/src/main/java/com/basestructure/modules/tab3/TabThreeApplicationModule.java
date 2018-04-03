package com.basestructure.modules.tab3;

import android.app.Activity;

import dagger.Module;

/**
 * Created by innofied on 3/4/18.
 */
@Module
public class TabThreeApplicationModule {
    private Activity activity;

    public TabThreeApplicationModule(Activity activity) {
        this.activity = activity;
    }
}
