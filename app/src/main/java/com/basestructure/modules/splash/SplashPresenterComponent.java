package com.basestructure.modules.splash;

import com.basestructure.dependencyInjection.PresenterComponent;
import com.basestructure.shared.ApplicationScope;

import dagger.Component;

/**
 * Created by innofied on 29/3/18.
 */

@ApplicationScope
@Component(dependencies = PresenterComponent.class, modules = SplashApplicationModule.class)
public interface SplashPresenterComponent {
    void inject(SplashPresenter presenter);
}
