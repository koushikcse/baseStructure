package com.basestructure.modules.home;

import com.basestructure.modules.view.presenter.PresenterStub;

/**
 * Created by innofied on 3/4/18.
 */

public class HomePresenter extends PresenterStub {
    private IHomeFragment fragment;

    public HomePresenter(IHomeFragment fragment) {
        this.fragment = fragment;
    }

    public interface IHomeFragment{}
}
