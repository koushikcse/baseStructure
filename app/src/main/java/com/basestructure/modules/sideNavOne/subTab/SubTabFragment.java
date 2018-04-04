package com.basestructure.modules.sideNavOne.subTab;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.basestructure.R;
import com.basestructure.databinding.FragmentSubtabBinding;
import com.basestructure.dependencyInjection.PresenterComponent;
import com.basestructure.modules.sideNavOne.DaggerSideNavOnePresenterComponent;
import com.basestructure.modules.sideNavOne.SideNavOneApplicationModule;
import com.basestructure.modules.sideNavOne.SideNavOnePresenterComponent;
import com.basestructure.modules.view.fragment.PresentedFragment;

/**
 * Created by innofied on 4/4/18.
 */

public class SubTabFragment extends PresentedFragment<SubTabPresenter> implements SubTabPresenter.ISubTabFragment{
    private FragmentSubtabBinding binding;
    private SubTabPresenter presenter;

    public static SubTabFragment newInstance(int instance) {
        SubTabFragment fragment = new SubTabFragment();
        Bundle args = new Bundle();
        args.putInt(ARGS_INSTANCE, instance);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding= DataBindingUtil.inflate(inflater, R.layout.fragment_subtab,container,false);
        return binding.getRoot();
    }

    @Override
    protected SubTabPresenter onCreatePresenter() {
        presenter=new SubTabPresenter(this);
        return presenter;
    }

    @Override
    protected void injectPresenter(PresenterComponent component, SubTabPresenter presenter) {
        SideNavOnePresenterComponent sideNavOnePresenterComponent = DaggerSideNavOnePresenterComponent.builder()
                .presenterComponent(component)
                .sideNavOneApplicationModule(new SideNavOneApplicationModule(getActivity()))
                .build();
        sideNavOnePresenterComponent.inject(presenter);
    }
}
