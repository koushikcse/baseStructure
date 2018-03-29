package com.basestructure.modules.view.presenter;

public interface Presenter  {
    void onCreate();

    void onPostCreate();

    void onResume();

    void onPostResume();

    void onPause();

    void onDestroy();
}