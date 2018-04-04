package com.basestructure.modules.sideNavOne;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.view.View;

import com.basestructure.R;
import com.basestructure.databinding.ActivitySidenavOneBinding;
import com.basestructure.dependencyInjection.PresenterComponent;
import com.basestructure.modules.sideNavOne.adapter.SideNavOnePagerAdapter;
import com.basestructure.modules.view.activity.PresentedActivity;

/**
 * Created by innofied on 4/4/18.
 */

public class SideNavOneActivity extends PresentedActivity<SideNavOnePresenter>
        implements SideNavOnePresenter.ISideNavOneActivity {

    private ActivitySidenavOneBinding binding;
    private SideNavOnePresenter presenter;
    private SideNavOnePagerAdapter sideNavOnePagerAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_sidenav_one);
        binding.collapsingToolbar.setTitle("SideNav one");
        setSupportActionBar(binding.toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.white_back_arrow);
            actionBar.setDisplayShowTitleEnabled(false);
        }
        binding.toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        sideNavOnePagerAdapter = new SideNavOnePagerAdapter(getSupportFragmentManager());
        binding.viewpager.setAdapter(sideNavOnePagerAdapter);
        binding.tabs.setupWithViewPager(binding.viewpager);

        binding.nestedScroll.setFillViewport(true);
    }

    @Override
    protected SideNavOnePresenter onCreatePresenter() {
        presenter = new SideNavOnePresenter(this);
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
