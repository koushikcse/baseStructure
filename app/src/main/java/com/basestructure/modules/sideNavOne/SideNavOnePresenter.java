package com.basestructure.modules.sideNavOne;

import com.basestructure.modules.view.presenter.PresenterStub;

/**
 * Created by innofied on 4/4/18.
 */

public class SideNavOnePresenter extends PresenterStub {
    private ISideNavOneActivity activity;

    public SideNavOnePresenter(ISideNavOneActivity activity) {
        this.activity = activity;
    }

    public interface ISideNavOneActivity{}
}
