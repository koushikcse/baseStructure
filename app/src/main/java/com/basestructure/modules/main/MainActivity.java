package com.basestructure.modules.main;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationAdapter;
import com.basestructure.R;
import com.basestructure.databinding.ActivityMainBinding;
import com.basestructure.dependencyInjection.PresenterComponent;
import com.basestructure.modules.Tab1.TabOneFragment;
import com.basestructure.modules.home.HomeFragment;
import com.basestructure.modules.tab2.TabTwoFragment;
import com.basestructure.modules.tab3.TabThreeFragment;
import com.basestructure.modules.tab4.TabFourFragment;
import com.basestructure.modules.view.activity.PresentedActivity;
import com.basestructure.modules.view.fragment.BaseFragment;
import com.basestructure.modules.view.fragment.FragmentHistory;
import com.ncapdevi.fragnav.FragNavController;

public class MainActivity extends PresentedActivity<MainPresenter> implements BaseFragment.FragmentNavigation,
        FragNavController.TransactionListener,
        FragNavController.RootFragmentListener, MainPresenter.IMainActivity {

    private ActivityMainBinding binding;
    private MainPresenter presenter;
    private HomeFragment homeFragment;

    private AHBottomNavigationAdapter navigationAdapter;
    private FragNavController mNavController;
    private FragmentHistory fragmentHistory;
    private boolean isPushFragment = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        initBottomNav();
        fragmentHistory = new FragmentHistory();

        mNavController = FragNavController.newBuilder(savedInstanceState, getSupportFragmentManager(), R.id.fragment_frame)
                .transactionListener(this)
                .rootFragmentListener(this, 5)
                .build();

        switchTab(0);

    }

    @Override
    protected MainPresenter onCreatePresenter() {
        presenter = new MainPresenter(this);
        return presenter;
    }

    @Override
    protected void injectPresenter(PresenterComponent component, MainPresenter presenter) {
        MainPresenterComponent mainPresenterComponent = DaggerMainPresenterComponent.builder()
                .presenterComponent(component)
                .mainApplicationModule(new MainApplicationModule(this))
                .build();
        mainPresenterComponent.inject(presenter);

    }

    public void initBottomNav() {
        navigationAdapter = new AHBottomNavigationAdapter(this, R.menu.menu_bottom_navigation);
        navigationAdapter.setupWithBottomNavigation(binding.bottomNav);

        binding.bottomNav.setDefaultBackgroundColor(ContextCompat.getColor(this, R.color.colorPrimary));
        binding.bottomNav.setBehaviorTranslationEnabled(false);
        binding.bottomNav.setAccentColor(ContextCompat.getColor(this, R.color.colorWhite));
        binding.bottomNav.setInactiveColor(ContextCompat.getColor(this, R.color.colorGray));

        binding.bottomNav.setForceTint(false);

        binding.bottomNav.setCurrentItem(0);

        binding.bottomNav.setTitleState(AHBottomNavigation.TitleState.ALWAYS_SHOW);

        binding.bottomNav.setOnTabSelectedListener(new AHBottomNavigation.OnTabSelectedListener() {
            @Override
            public boolean onTabSelected(int position, boolean wasSelected) {
                if (isPushFragment) {
                    fragmentHistory.push(position);
                    switchTab(position);
                }
                return true;
            }
        });

    }

    private void switchTab(int position) {
        mNavController.switchTab(position);
        isPushFragment = true;
    }

    @Override
    public void pushFragment(Fragment fragment) {
        if (mNavController != null) {
            mNavController.pushFragment(fragment);
        }
    }

    @Override
    public Fragment getRootFragment(int position) {
        if (mNavController != null) {
            mNavController.clearStack();
        }

        switch (position) {
            case 0:
                return HomeFragment.newInstance(0);
            case 1:
                return TabOneFragment.newInstance(0);
            case 2:
                return TabTwoFragment.newInstance(0);
            case 3:
                return TabThreeFragment.newInstance(0);
            case 4:
                return TabFourFragment.newInstance(0);
        }
        throw new IllegalStateException("Need to send an index that we know");
    }

    @Override
    public void onTabTransaction(@Nullable Fragment fragment, int i) {

    }

    @Override
    public void onFragmentTransaction(Fragment fragment, FragNavController.TransactionType transactionType) {

    }
}
