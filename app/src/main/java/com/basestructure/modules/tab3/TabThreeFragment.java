package com.basestructure.modules.tab3;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.basestructure.R;
import com.basestructure.databinding.FragmentTabThreeBinding;
import com.basestructure.dependencyInjection.PresenterComponent;
import com.basestructure.modules.tab2.TabTwoFragment;
import com.basestructure.modules.view.fragment.PresentedFragment;

/**
 * Created by innofied on 3/4/18.
 */

public class TabThreeFragment extends PresentedFragment<TabThreePresenter> implements TabThreePresenter.ITabThreeFragment {
    private FragmentTabThreeBinding binding;
    private TabThreePresenter presenter;

    private int fragCount;

    public static TabThreeFragment newInstance(int instance) {
        TabThreeFragment fragment = new TabThreeFragment();
        Bundle args = new Bundle();
        args.putInt(ARGS_INSTANCE, instance);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_tab_three, container, false);
        Bundle args = getArguments();
        if (args != null) {
            fragCount = args.getInt(ARGS_INSTANCE);
        }
        return binding.getRoot();
    }

    @Override
    protected TabThreePresenter onCreatePresenter() {
        presenter=new TabThreePresenter(this);
        return presenter;
    }

    @Override
    protected void injectPresenter(PresenterComponent component, TabThreePresenter presenter) {
        TabThreePresenterComponent tabThreePresenterComponent = DaggerTabThreePresenterComponent.builder()
                .presenterComponent(component)
                .tabThreeApplicationModule(new TabThreeApplicationModule(getActivity()))
                .build();
        tabThreePresenterComponent.inject(presenter);
    }
}
