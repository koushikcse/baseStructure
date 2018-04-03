package com.basestructure.modules.main;

import com.basestructure.modules.view.presenter.PresenterStub;

/**
 * Created by innofied on 3/4/18.
 */

public class MainPresenter extends PresenterStub{
    private IMainActivity activity;

    public MainPresenter(IMainActivity activity) {
        this.activity = activity;
    }

    public interface IMainActivity{}
}
