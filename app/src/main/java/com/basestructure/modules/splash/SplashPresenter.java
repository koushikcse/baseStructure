package com.basestructure.modules.splash;

import com.basestructure.modules.view.presenter.PresenterStub;

/**
 * Created by innofied on 29/3/18.
 */

public class SplashPresenter extends PresenterStub {
    private ISplashActivity activity;

    public SplashPresenter(ISplashActivity activity) {
        this.activity = activity;
    }

    public interface ISplashActivity{}
}
