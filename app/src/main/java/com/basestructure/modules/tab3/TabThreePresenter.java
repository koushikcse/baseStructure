package com.basestructure.modules.tab3;

import com.basestructure.modules.view.presenter.PresenterStub;

/**
 * Created by innofied on 3/4/18.
 */

public class TabThreePresenter extends PresenterStub {
    private ITabThreeFragment fragment;

    public TabThreePresenter(ITabThreeFragment fragment) {
        this.fragment = fragment;
    }

    public interface ITabThreeFragment{}
}
