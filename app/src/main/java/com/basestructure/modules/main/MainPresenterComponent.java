package com.basestructure.modules.main;

import com.basestructure.dependencyInjection.PresenterComponent;
import com.basestructure.shared.ApplicationScope;

import dagger.Component;

/**
 * Created by innofied on 3/4/18.
 */

@ApplicationScope
@Component(dependencies = PresenterComponent.class, modules = MainApplicationModule.class)
public interface MainPresenterComponent {
    void inject(MainPresenter presenter);
}
