package com.basestructure.modules.tab4;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.basestructure.R;
import com.basestructure.databinding.FragmentTabFourBinding;
import com.basestructure.dependencyInjection.PresenterComponent;
import com.basestructure.modules.view.fragment.PresentedFragment;

/**
 * Created by innofied on 3/4/18.
 */

public class TabFourFragment extends PresentedFragment<TabFourPresenter> implements TabFourPresenter.ITabFourFragment {
    private FragmentTabFourBinding binding;
    private TabFourPresenter presenter;

    private int fragCount;

    public static TabFourFragment newInstance(int instance) {
        TabFourFragment fragment = new TabFourFragment();
        Bundle args = new Bundle();
        args.putInt(ARGS_INSTANCE, instance);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_tab_four, container, false);
        Bundle args = getArguments();
        if (args != null) {
            fragCount = args.getInt(ARGS_INSTANCE);
        }
        return binding.getRoot();
    }

    @Override
    protected TabFourPresenter onCreatePresenter() {
        presenter = new TabFourPresenter(this);
        return presenter;
    }

    @Override
    protected void injectPresenter(PresenterComponent component, TabFourPresenter presenter) {
        TabFourPresenterComponent tabFourPresenterComponent = DaggerTabFourPresenterComponent.builder()
                .presenterComponent(component)
                .tabFourApplicationModule(new TabFourApplicationModule(getActivity()))
                .build();
        tabFourPresenterComponent.inject(presenter);
    }
}
