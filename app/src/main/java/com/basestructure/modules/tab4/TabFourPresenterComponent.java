package com.basestructure.modules.tab4;

import com.basestructure.dependencyInjection.PresenterComponent;
import com.basestructure.shared.ApplicationScope;

import dagger.Component;

/**
 * Created by innofied on 3/4/18.
 */

@ApplicationScope
@Component(dependencies = PresenterComponent.class, modules = TabFourApplicationModule.class)
public interface TabFourPresenterComponent {
    void inject(TabFourPresenter presenter);
}
