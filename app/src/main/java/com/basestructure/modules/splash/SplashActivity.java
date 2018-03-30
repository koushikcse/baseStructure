package com.basestructure.modules.splash;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Window;
import android.view.WindowManager;

import com.basestructure.R;
import com.basestructure.databinding.ActivitySplashBinding;
import com.basestructure.dependencyInjection.PresenterComponent;
import com.basestructure.modules.tutorial.TutorialActivity;
import com.basestructure.modules.view.activity.PresentedActivity;

/**
 * Created by innofied on 29/3/18.
 */

public class SplashActivity extends PresentedActivity<SplashPresenter> implements SplashPresenter.ISplashActivity {
    private SplashPresenter presenter;
    private ActivitySplashBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_splash);

        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
    }

    @Override
    protected SplashPresenter onCreatePresenter() {
        presenter = new SplashPresenter(this);
        return presenter;
    }

    @Override
    protected void injectPresenter(PresenterComponent component, SplashPresenter presenter) {
        SplashPresenterComponent splashPresenterComponent = DaggerSplashPresenterComponent.builder()
                .presenterComponent(component)
                .splashApplicationModule(new SplashApplicationModule(this))
                .build();
        splashPresenterComponent.inject(presenter);
    }

    @Override
    public void gotoTutorialActivity() {
        startActivity(new Intent(this, TutorialActivity.class));
    }
}
