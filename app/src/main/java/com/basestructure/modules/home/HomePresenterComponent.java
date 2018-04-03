package com.basestructure.modules.home;

import com.basestructure.dependencyInjection.PresenterComponent;
import com.basestructure.modules.tab4.TabFourApplicationModule;
import com.basestructure.shared.ApplicationScope;

import dagger.Component;

/**
 * Created by innofied on 3/4/18.
 */

@ApplicationScope
@Component(dependencies = PresenterComponent.class, modules = HomeApplicationModule.class)
public interface HomePresenterComponent {
    void inject(HomePresenter presenter);
}
