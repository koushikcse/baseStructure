package com.basestructure.modules.tab2;

import com.basestructure.modules.view.presenter.PresenterStub;

/**
 * Created by innofied on 3/4/18.
 */

public class TabTwoPresenter extends PresenterStub {

    private ITabTwoFragment fragment;

    public TabTwoPresenter(ITabTwoFragment fragment) {
        this.fragment = fragment;
    }

    public interface ITabTwoFragment {}
}
