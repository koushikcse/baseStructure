package com.basestructure.modules.auth;

import com.basestructure.dependencyInjection.PresenterComponent;
import com.basestructure.modules.auth.login.LoginPresenter;
import com.basestructure.modules.auth.signup.SignupPresenter;
import com.basestructure.shared.ApplicationScope;

import dagger.Component;

/**
 * Created by innofied on 29/3/18.
 */

@ApplicationScope
@Component(dependencies = PresenterComponent.class, modules = AuthApplicationModule.class)
public interface AuthPresenterComponent {
    void inject(LoginPresenter presenter);

    void inject(SignupPresenter presenter);
}
