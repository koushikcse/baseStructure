package com.basestructure.modules.Tab1;

import com.basestructure.dependencyInjection.PresenterComponent;
import com.basestructure.shared.ApplicationScope;

import dagger.Component;

/**
 * Created by innofied on 3/4/18.
 */

@ApplicationScope
@Component(dependencies = PresenterComponent.class, modules = TabOneApplicationModule.class)
public interface TabOnePresenterComponent {
    void inject(TabOnePresenter presenter);
}
