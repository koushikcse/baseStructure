package com.basestructure.modules.tutorial;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;

import com.basestructure.R;
import com.basestructure.databinding.ActivityTutorialBinding;
import com.basestructure.dependencyInjection.PresenterComponent;
import com.basestructure.modules.auth.login.LoginActivity;
import com.basestructure.modules.tutorial.adapter.TutorialPagerAdapter;
import com.basestructure.modules.view.activity.PresentedActivity;

/**
 * Created by innofied on 30/3/18.
 */

public class TutorialActivity extends PresentedActivity<TutorialPresenter> implements TutorialPresenter.ITutorialActivity {

    private ActivityTutorialBinding binding;
    private TutorialPresenter presenter;
    private TutorialPagerAdapter tutorialPagerAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_tutorial);
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        tutorialPagerAdapter = new TutorialPagerAdapter(this);
        binding.tutorialViewpager.setAdapter(tutorialPagerAdapter);
//        binding.tutorialViewpager.setPageTransformer(true, new ZoomOutPageTransformer());
        updateIndicators(0);
        binding.tutorialViewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                updateIndicators(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });

        binding.loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TutorialActivity.this, LoginActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);

            }
        });
    }

    private void updateIndicators(int position) {
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                20, 20
        );
        params.setMargins(5, 5, 5, 5);
        LinearLayout.LayoutParams params1 = new LinearLayout.LayoutParams(
                20, 20
        );
        params1.setMargins(5, 5, 5, 5);
        if (position == 0) {
            binding.firstView.setLayoutParams(params);
            binding.secondView.setLayoutParams(params1);
            binding.thirdView.setLayoutParams(params1);
            binding.firstView.setBackgroundResource(R.drawable.bg_tutorial_active);
            binding.secondView.setBackgroundResource(R.drawable.bg_tutorial_inactive);
            binding.thirdView.setBackgroundResource(R.drawable.bg_tutorial_inactive);
        } else if (position == 1) {
            binding.firstView.setLayoutParams(params1);
            binding.secondView.setLayoutParams(params);
            binding.thirdView.setLayoutParams(params1);
            binding.firstView.setBackgroundResource(R.drawable.bg_tutorial_inactive);
            binding.secondView.setBackgroundResource(R.drawable.bg_tutorial_active);
            binding.thirdView.setBackgroundResource(R.drawable.bg_tutorial_inactive);
        } else if (position == 2) {
            binding.firstView.setLayoutParams(params1);
            binding.secondView.setLayoutParams(params1);
            binding.thirdView.setLayoutParams(params);
            binding.firstView.setBackgroundResource(R.drawable.bg_tutorial_inactive);
            binding.secondView.setBackgroundResource(R.drawable.bg_tutorial_inactive);
            binding.thirdView.setBackgroundResource(R.drawable.bg_tutorial_active);
        }
    }

    @Override
    protected TutorialPresenter onCreatePresenter() {
        presenter = new TutorialPresenter(this);
        return presenter;
    }

    @Override
    protected void injectPresenter(PresenterComponent component, TutorialPresenter presenter) {
        TutorialPresenterComponent tutorialPresenterComponent = DaggerTutorialPresenterComponent.builder()
                .presenterComponent(component)
                .tutorialApplicationModule(new TutorialApplicationModule(this))
                .build();
        tutorialPresenterComponent.inject(presenter);
    }
}
