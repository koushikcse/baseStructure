package com.basestructure.modules.tab3;

import com.basestructure.dependencyInjection.PresenterComponent;
import com.basestructure.shared.ApplicationScope;

import dagger.Component;

/**
 * Created by innofied on 3/4/18.
 */

@ApplicationScope
@Component(dependencies = PresenterComponent.class, modules = TabThreeApplicationModule.class)
public interface TabThreePresenterComponent {
    void inject(TabThreePresenter presenter);
}
