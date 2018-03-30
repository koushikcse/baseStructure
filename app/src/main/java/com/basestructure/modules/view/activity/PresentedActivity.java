package com.basestructure.modules.view.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.basestructure.dependencyInjection.ApplicationModule;
import com.basestructure.dependencyInjection.DaggerPresenterComponent;
import com.basestructure.dependencyInjection.PresenterComponent;
import com.basestructure.modules.view.presenter.Presenter;


/**
 * Created by innofied on 20/7/17.
 */

public abstract class PresentedActivity<T extends Presenter> extends DaggerActivity {

    private T presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        inject();
        presenter.onCreate();
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        presenter.onPostCreate();
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.onResume();
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        presenter.onPostResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        presenter.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }

    @Override
    protected void inject() {
        presenter = onCreatePresenter();
        PresenterComponent presenterComponent = DaggerPresenterComponent
                .builder()
                .applicationModule(new ApplicationModule(this))
                .build();
        injectPresenter(presenterComponent, presenter);
    }

    /**
     * Hide Key Board
     *
     * @param activity
     */
    public void hideKeyboard(Activity activity) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        View view = activity.getCurrentFocus();
        if (view == null) {
            view = new View(activity);
        }
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    protected abstract T onCreatePresenter();

    protected abstract void injectPresenter(PresenterComponent component, T presenter);

}
