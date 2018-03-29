package com.basestructure.utils;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Transformation;

/**
 * Created by innofied on 10/5/17.
 */

public class ExpandCollapseAnimation extends Animation {

    private View animatedView;
    private int animatedViewWidth, type;

    public ExpandCollapseAnimation(View view, int type) {
        setDuration(300);
        this.animatedView = view;
        animatedView.measure(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        animatedViewWidth = animatedView.getMeasuredWidth();
        this.type = type;
        if (this.type == 0) {
            animatedView.getLayoutParams().width = 0;
            animatedView.setVisibility(View.VISIBLE);
        }
    }

    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {
        super.applyTransformation(interpolatedTime, t);
        if (interpolatedTime < 1.0f) {
            if (type == 0) {
                animatedView.getLayoutParams().width = (int) (animatedViewWidth * interpolatedTime);
            } else {
                animatedView.getLayoutParams().width = animatedViewWidth - (int) (animatedViewWidth * interpolatedTime);
            }
            animatedView.requestLayout();
        } else {
            if (type == 0) {
                animatedView.getLayoutParams().width = animatedViewWidth;
                animatedView.requestLayout();
            } else {
                animatedView.getLayoutParams().width = 0;
                animatedView.setVisibility(View.GONE);
                animatedView.requestLayout();
                animatedView.getLayoutParams().width = animatedViewWidth;
            }
        }
    }

}

