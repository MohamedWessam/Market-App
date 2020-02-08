package com.wessam.freshmarketdemo.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.Transformation;

/**
 * Custom dotted circular progressbar
 */

public class DottedCircularProgressbar extends View {

    private static final int dotRadius = 6; //Normal dot radius
    private static final int bounceDotRadius = 9; //Expanded Dot Radius
    private static int dotPosition = 1; //to get identified in which position dot has to expand its radius
    private static final int dotAmount = 10; //specify how many dots you need in a progressbar
    private static final int circleRadius = 30; //specify the circle radius
    private Paint progressPaint;

    public DottedCircularProgressbar(Context context, AttributeSet attrs) {
        super(context, attrs);
        progressPaint = new Paint();
        progressPaint.setColor(Color.parseColor("#F1F1F1")); // specify dot color
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        //Animation called when attaching to the window
        startAnimation();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //take the point to the center of the screen
        canvas.translate(this.getWidth() / 2, this.getHeight() / 2);

        //call create dot method
        createDotInCircle(canvas, progressPaint);
    }

    private void createDotInCircle(Canvas canvas, Paint progressPaint) {
        //angle for each dot angle = (360/number of dots)
        int angle = 36;
        for (int i = 1; i <= dotAmount; i++) {
            // angle should be in radians  i.e formula (angle *(Math.PI / 180))
            float x = (float) (circleRadius * (Math.cos((angle * i) * (Math.PI / 180))));
            float y = (float) (circleRadius * (Math.sin((angle * i) * (Math.PI / 180))));

            if (i == dotPosition) canvas.drawCircle(x, y, bounceDotRadius, progressPaint);
            else canvas.drawCircle(x, y, dotRadius, progressPaint);
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        //Dynamically setting width and height to progressbar 70 is circle radius, dotRadius * 3 to cover the width and height of Progressbar
        int width  = 60 + (dotRadius * 3);
        int height = 60 + (dotRadius * 3);

        setMeasuredDimension(width, height);
    }

    private void startAnimation() {
        BounceAnimation bounceAnimation = new BounceAnimation();
        bounceAnimation.setDuration(150);
        bounceAnimation.setRepeatCount(Animation.INFINITE);
        bounceAnimation.setInterpolator(new LinearInterpolator());
        bounceAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                dotPosition++;
                //when dotPosition == dotAmount , then start again applying animation from 0th position
                if (dotPosition > dotAmount) dotPosition = 1;
            }
        });
        startAnimation(bounceAnimation);
    }

    private class BounceAnimation extends Animation {

        @Override
        protected void applyTransformation(float interpolatedTime, Transformation t) {
            super.applyTransformation(interpolatedTime, t);
            //call invalidate to redraw the view again.
            invalidate();
        }
    }

}