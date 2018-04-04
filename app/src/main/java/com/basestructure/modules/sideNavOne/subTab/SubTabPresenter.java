package com.basestructure.modules.sideNavOne.subTab;

import com.basestructure.modules.view.presenter.PresenterStub;

/**
 * Created by innofied on 4/4/18.
 */

public class SubTabPresenter extends PresenterStub {
    private ISubTabFragment fragment;

    public SubTabPresenter(ISubTabFragment fragment) {
        this.fragment = fragment;
    }

    public interface ISubTabFragment{}
}
