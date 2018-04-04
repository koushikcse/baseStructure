package com.basestructure.modules.sideNavOne;

import com.basestructure.dependencyInjection.PresenterComponent;
import com.basestructure.modules.sideNavOne.subTab.SubTabPresenter;
import com.basestructure.shared.ApplicationScope;

import dagger.Component;

/**
 * Created by innofied on 4/4/18.
 */

@ApplicationScope
@Component(dependencies = PresenterComponent.class, modules = SideNavOneApplicationModule.class)
public interface SideNavOnePresenterComponent {
    void inject(SideNavOnePresenter presenter);

    void inject(SubTabPresenter presenter);
}
