package com.basestructure.modules.tab2;

import com.basestructure.dependencyInjection.PresenterComponent;
import com.basestructure.shared.ApplicationScope;

import dagger.Component;

/**
 * Created by innofied on 3/4/18.
 */

@ApplicationScope
@Component(dependencies = PresenterComponent.class, modules = TabTwoApplicationModule.class)
public interface TabTwoPresenterComponent {
    void inject(TabTwoPresenter presenter);
}
