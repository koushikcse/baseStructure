package com.basestructure.modules.Tab1;

import com.basestructure.modules.view.presenter.PresenterStub;

/**
 * Created by innofied on 3/4/18.
 */

public class TabOnePresenter extends PresenterStub {

    private ITabOneFragment fragment;

    public TabOnePresenter(ITabOneFragment fragment) {
        this.fragment = fragment;
    }

    public interface ITabOneFragment {}
}
