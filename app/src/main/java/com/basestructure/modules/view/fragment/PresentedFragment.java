package com.basestructure.modules.view.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.basestructure.dependencyInjection.ApplicationModule;
import com.basestructure.dependencyInjection.DaggerPresenterComponent;
import com.basestructure.dependencyInjection.PresenterComponent;
import com.basestructure.modules.view.presenter.Presenter;


public abstract class PresentedFragment<T extends Presenter> extends DaggerFragment {

    private T presenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        inject();
        presenter.onCreate();
    }

    /*@Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        presenter.onPostCreate();
    }*/

    @Override
    public void onResume() {
        super.onResume();
        presenter.onResume();
    }

    /*@Override
    public void onPostResume() {
        super.onPostResume();
        presenter.onPostResume();
    }*/

    @Override
    public void onPause() {
        super.onPause();
        presenter.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }

    @Override
    protected void inject() {
        presenter = onCreatePresenter();
        PresenterComponent presenterComponent = DaggerPresenterComponent
                .builder()
                .applicationModule(new ApplicationModule(getActivity()))
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

