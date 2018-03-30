package com.basestructure.modules.splash;

import com.basestructure.modules.view.presenter.PresenterStub;
import com.basestructure.shared.Constants;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by innofied on 29/3/18.
 */

public class SplashPresenter extends PresenterStub {
    private ISplashActivity activity;

    public SplashPresenter(ISplashActivity activity) {
        this.activity = activity;
    }

    @Override
    public void onCreate() {
//        super.onCreate();
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                activity.gotoTutorialActivity();
            }
        }, Constants.SPLASH_TIMER);
    }

    public interface ISplashActivity{
        void gotoTutorialActivity();
    }
}
