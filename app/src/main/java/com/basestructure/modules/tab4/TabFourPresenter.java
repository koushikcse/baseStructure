package com.basestructure.modules.tab4;

import com.basestructure.modules.view.presenter.PresenterStub;

/**
 * Created by innofied on 3/4/18.
 */

public class TabFourPresenter extends PresenterStub {
    private ITabFourFragment fragment;

    public TabFourPresenter(ITabFourFragment fragment) {
        this.fragment = fragment;
    }

    public interface ITabFourFragment{}
}
