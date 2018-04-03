package com.basestructure.modules.Tab1;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.basestructure.R;
import com.basestructure.databinding.FragmentTabOneBinding;
import com.basestructure.dependencyInjection.PresenterComponent;
import com.basestructure.modules.home.HomeFragment;
import com.basestructure.modules.view.fragment.PresentedFragment;

/**
 * Created by innofied on 3/4/18.
 */

public class TabOneFragment extends PresentedFragment<TabOnePresenter> implements TabOnePresenter.ITabOneFragment {

    private FragmentTabOneBinding binding;
    private TabOnePresenter presenter;
    private int fragCount;


    public static TabOneFragment newInstance(int instance) {
        TabOneFragment fragment = new TabOneFragment();
        Bundle args = new Bundle();
        args.putInt(ARGS_INSTANCE, instance);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_tab_one, container, false);
        Bundle args = getArguments();
        if (args != null) {
            fragCount = args.getInt(ARGS_INSTANCE);
        }  return binding.getRoot();
    }

    @Override
    protected TabOnePresenter onCreatePresenter() {
        presenter = new TabOnePresenter(this);
        return presenter;
    }

    @Override
    protected void injectPresenter(PresenterComponent component, TabOnePresenter presenter) {
        TabOnePresenterComponent tabOnePresenterComponent = DaggerTabOnePresenterComponent.builder()
                .presenterComponent(component)
                .tabOneApplicationModule(new TabOneApplicationModule(getActivity()))
                .build();
        tabOnePresenterComponent.inject(presenter);
    }
}
