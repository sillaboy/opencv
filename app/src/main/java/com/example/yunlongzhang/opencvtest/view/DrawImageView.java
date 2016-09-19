package com.example.yunlongzhang.opencvtest.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Created by yunlong.zhang on 2016/9/11.
 */
public class DrawImageView extends ImageView {

    Paint mpaint;

    public DrawImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void initVars() {
        mpaint.setAntiAlias(true);
        mpaint.setColor(Color.RED);
        mpaint.setStyle(Paint.Style.STROKE);
        mpaint.setStrokeWidth(2.5f);
        mpaint.setAlpha(100);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawRect(new Rect(100,200,400,500),mpaint);
    }
}
