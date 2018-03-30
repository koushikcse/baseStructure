package com.basestructure.modules.tutorial;

import com.basestructure.dependencyInjection.PresenterComponent;
import com.basestructure.shared.ApplicationScope;

import dagger.Component;

/**
 * Created by innofied on 30/3/18.
 */

@ApplicationScope
@Component(dependencies = PresenterComponent.class, modules = TutorialApplicationModule.class)
public interface TutorialPresenterComponent {
    void inject(TutorialPresenter presenter);
}
