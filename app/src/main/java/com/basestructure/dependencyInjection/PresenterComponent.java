package com.basestructure.dependencyInjection;


import com.basestructure.network.EventBus;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by innofied on 4/5/17.
 */
@Singleton
@Component(modules = ApplicationModule.class)
public interface PresenterComponent {

    EventBus getEventBus();
}
