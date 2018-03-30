package com.basestructure.modules.tutorial.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.basestructure.R;
import com.basestructure.databinding.TutorialOneBinding;
import com.basestructure.databinding.TutorialThreeBinding;
import com.basestructure.databinding.TutorialTwoBinding;


/**
 * Created by koushik on 15/6/17.
 */

public class TutorialPagerAdapter extends PagerAdapter {
    private Context context;
    private TutorialOneBinding tutorialOneBinding;
    private TutorialTwoBinding tutorialTwoBinding;
    private TutorialThreeBinding tutorialThreeBinding;

    public TutorialPagerAdapter(Context context) {
        this.context = context;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        tutorialOneBinding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.tutorial_one, container, false);

        container.addView(tutorialOneBinding.getRoot());

        tutorialTwoBinding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.tutorial_two, container, false);

        container.addView(tutorialTwoBinding.getRoot());

        tutorialThreeBinding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.tutorial_three, container, false);

        container.addView(tutorialThreeBinding.getRoot());

        switch (position) {
            case 0:
                return tutorialOneBinding.getRoot();

            case 1:
                return tutorialTwoBinding.getRoot();

            case 2:
                return tutorialThreeBinding.getRoot();
        }
        return null;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

}
