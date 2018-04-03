package com.basestructure.modules.tab2;

import android.app.Activity;

import dagger.Module;

/**
 * Created by innofied on 3/4/18.
 */
@Module
public class TabTwoApplicationModule {
    private Activity activity;

    public TabTwoApplicationModule(Activity activity) {
        this.activity = activity;
    }
}
