package com.basestructure.modules.auth.login;

import com.basestructure.modules.view.presenter.PresenterStub;

/**
 * Created by innofied on 29/3/18.
 */

public class LoginPresenter extends PresenterStub{
    private ILoginActivity activity;

    public LoginPresenter(ILoginActivity activity) {
        this.activity = activity;
    }

    public interface ILoginActivity{}

}
