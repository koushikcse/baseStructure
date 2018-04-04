package com.basestructure.modules.sideNavOne;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;

import com.basestructure.R;
import com.basestructure.databinding.ActivitySidenavOneBinding;
import com.basestructure.dependencyInjection.PresenterComponent;
import com.basestructure.modules.home.DaggerHomePresenterComponent;
import com.basestructure.modules.home.HomeApplicationModule;
import com.basestructure.modules.home.HomePresenterComponent;
import com.basestructure.modules.view.activity.PresentedActivity;

/**
 * Created by innofied on 4/4/18.
 */

public class SideNavOneActivity extends PresentedActivity<SideNavOnePresenter>
        implements SideNavOnePresenter.ISideNavOneActivity{

    private ActivitySidenavOneBinding binding;
    private SideNavOnePresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this, R.layout.activity_sidenav_one);
        binding.collapsingToolbar.setTitle("SideNav one");
        setSupportActionBar(binding.toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_featured);
            actionBar.setDisplayShowTitleEnabled(false);
        }

    }

    @Override
    protected SideNavOnePresenter onCreatePresenter() {
        presenter=new SideNavOnePresenter(this);
        return presenter;
    }

    @Override
    protected void injectPresenter(PresenterComponent component, SideNavOnePresenter presenter) {
        SideNavOnePresenterComponent sideNavOnePresenterComponent = DaggerSideNavOnePresenterComponent.builder()
                .presenterComponent(component)
                .sideNavOneApplicationModule(new SideNavOneApplicationModule(this))
                .build();
        sideNavOnePresenterComponent.inject(presenter);
    }
}
