package com.basestructure.modules.auth.signup;

import com.basestructure.modules.view.presenter.PresenterStub;

/**
 * Created by innofied on 29/3/18.
 */

public class SignupPresenter extends PresenterStub {
    private ISignupActivity activity;

    public SignupPresenter(ISignupActivity activity) {
        this.activity = activity;
    }

    public interface ISignupActivity{}
}
