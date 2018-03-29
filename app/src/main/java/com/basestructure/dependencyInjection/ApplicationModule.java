package com.basestructure.dependencyInjection;

import android.app.Activity;
import android.content.Context;


import com.basestructure.network.EventBus;
import com.basestructure.network.RxBus;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by innofied on 4/5/17.
 */
@Module
public class ApplicationModule {

    private Activity activity;

    public ApplicationModule(Activity activity) {
        this.activity = activity;
    }

    @Provides
    Context getApplicationContext() {
        return activity.getApplicationContext();
    }

    @Singleton
    @Provides
    EventBus getEventBus() {
        return new RxBus();
    }

}