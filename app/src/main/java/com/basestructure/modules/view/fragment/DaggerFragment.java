package com.basestructure.modules.view.fragment;

import android.os.Bundle;

public abstract class DaggerFragment extends BaseFragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        inject();
    }

    protected abstract void inject();

}
