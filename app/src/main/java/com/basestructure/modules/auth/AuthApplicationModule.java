package com.basestructure.modules.auth;

import android.app.Activity;

import dagger.Module;

/**
 * Created by innofied on 29/3/18.
 */
@Module
public class AuthApplicationModule {
    private Activity activity;

    public AuthApplicationModule(Activity activity) {
        this.activity = activity;
    }
}
