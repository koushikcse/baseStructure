package com.basestructure.modules.auth.login;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.basestructure.R;
import com.basestructure.databinding.ActivityLoginBinding;
import com.basestructure.dependencyInjection.PresenterComponent;
import com.basestructure.modules.auth.AuthApplicationModule;
import com.basestructure.modules.auth.AuthPresenterComponent;
import com.basestructure.modules.auth.DaggerAuthPresenterComponent;
import com.basestructure.modules.view.activity.PresentedActivity;

/**
 * Created by innofied on 29/3/18.
 */

public class LoginActivity extends PresentedActivity<LoginPresenter> implements LoginPresenter.ILoginActivity {
    private ActivityLoginBinding binding;
    private LoginPresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login);
    }

    @Override
    protected LoginPresenter onCreatePresenter() {
        presenter = new LoginPresenter(this);
        return presenter;
    }

    @Override
    protected void injectPresenter(PresenterComponent component, LoginPresenter presenter) {
        AuthPresenterComponent authPresenterComponent = DaggerAuthPresenterComponent.builder()
                .presenterComponent(component)
                .authApplicationModule(new AuthApplicationModule(this))
                .build();
        authPresenterComponent.inject(presenter);
    }
}
