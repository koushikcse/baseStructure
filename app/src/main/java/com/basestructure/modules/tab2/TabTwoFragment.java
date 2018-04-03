package com.basestructure.modules.tab2;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.basestructure.R;
import com.basestructure.databinding.FragmentTabOneBinding;
import com.basestructure.databinding.FragmentTabTwoBinding;
import com.basestructure.dependencyInjection.PresenterComponent;
import com.basestructure.modules.Tab1.TabOneFragment;
import com.basestructure.modules.view.fragment.PresentedFragment;

/**
 * Created by innofied on 3/4/18.
 */

public class TabTwoFragment extends PresentedFragment<TabTwoPresenter> implements TabTwoPresenter.ITabTwoFragment {

    private FragmentTabTwoBinding binding;
    private TabTwoPresenter presenter;
    private int fragCount;

    public static TabTwoFragment newInstance(int instance) {
        TabTwoFragment fragment = new TabTwoFragment();
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
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_tab_two, container, false);
        Bundle args = getArguments();
        if (args != null) {
            fragCount = args.getInt(ARGS_INSTANCE);
        }
        return binding.getRoot();
    }

    @Override
    protected TabTwoPresenter onCreatePresenter() {
        presenter = new TabTwoPresenter(this);
        return presenter;
    }

    @Override
    protected void injectPresenter(PresenterComponent component, TabTwoPresenter presenter) {
        TabTwoPresenterComponent tabTwoPresenterComponent = DaggerTabTwoPresenterComponent.builder()
                .presenterComponent(component)
                .tabTwoApplicationModule(new TabTwoApplicationModule(getActivity()))
                .build();
        tabTwoPresenterComponent.inject(presenter);
    }
}
