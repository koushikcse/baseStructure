package com.basestructure.utils;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Transformation;

/**
 * Created by innofied on 1/12/17.
 */

public class ExpanCollapseVerticallyAnimation extends Animation {

    private View animatedView;
    private int animatedViewHeight, type;

    public ExpanCollapseVerticallyAnimation(View view, int type) {
        setDuration(300);
        this.animatedView = view;
        animatedView.measure(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        animatedViewHeight = animatedView.getMeasuredHeight();
        this.type = type;
        if (this.type == 0) {
            animatedView.getLayoutParams().height = 0;
            animatedView.setVisibility(View.VISIBLE);
        }
    }

    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {
        super.applyTransformation(interpolatedTime, t);
        if (interpolatedTime < 1.0f) {
            if (type == 0) {
                animatedView.getLayoutParams().height = (int) (animatedViewHeight * interpolatedTime);
            } else {
                animatedView.getLayoutParams().height = animatedViewHeight - (int) (animatedViewHeight * interpolatedTime);
            }
            animatedView.requestLayout();
        } else {
            if (type == 0) {
                animatedView.getLayoutParams().height = animatedViewHeight;
                animatedView.requestLayout();
            } else {
                animatedView.getLayoutParams().height = 0;
                animatedView.setVisibility(View.GONE);
                animatedView.requestLayout();
                animatedView.getLayoutParams().height = animatedViewHeight;
            }
        }
    }
}

