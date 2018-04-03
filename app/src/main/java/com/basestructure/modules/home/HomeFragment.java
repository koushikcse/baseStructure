package com.basestructure.modules.home;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.basestructure.R;
import com.basestructure.databinding.FragmentHomeBinding;
import com.basestructure.dependencyInjection.PresenterComponent;
import com.basestructure.modules.view.fragment.PresentedFragment;

/**
 * Created by innofied on 3/4/18.
 */

public class HomeFragment extends PresentedFragment<HomePresenter> implements HomePresenter.IHomeFragment {

    private FragmentHomeBinding binding;
    private HomePresenter presenter;
    private int fragCount;


    public static HomeFragment newInstance(int instance) {
        HomeFragment fragment = new HomeFragment();
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
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false);
        Bundle args = getArguments();
        if (args != null) {
            fragCount = args.getInt(ARGS_INSTANCE);
        }
        return binding.getRoot();
    }

    @Override
    protected HomePresenter onCreatePresenter() {
        presenter = new HomePresenter(this);
        return presenter;
    }

    @Override
    protected void injectPresenter(PresenterComponent component, HomePresenter presenter) {
        HomePresenterComponent homePresenterComponent = DaggerHomePresenterComponent.builder()
                .presenterComponent(component)
                .homeApplicationModule(new HomeApplicationModule(getActivity()))
                .build();
        homePresenterComponent.inject(presenter);
    }
}
