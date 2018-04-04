package com.basestructure.modules.sideNavOne;

import android.app.Activity;

import dagger.Module;

/**
 * Created by innofied on 4/4/18.
 */
@Module
public class SideNavOneApplicationModule {
    private Activity activity;

    public SideNavOneApplicationModule(Activity activity) {
        this.activity = activity;
    }
}
