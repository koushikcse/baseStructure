package com.basestructure.modules.tutorial;

import com.basestructure.modules.view.presenter.PresenterStub;

/**
 * Created by innofied on 30/3/18.
 */

public class TutorialPresenter extends PresenterStub {
    private ITutorialActivity activity;

    public TutorialPresenter(ITutorialActivity activity) {
        this.activity = activity;
    }

    public interface ITutorialActivity{}
}
