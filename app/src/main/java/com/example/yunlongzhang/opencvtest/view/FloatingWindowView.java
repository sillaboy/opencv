package com.example.yunlongzhang.opencvtest.view;

import android.content.Context;
import android.graphics.PixelFormat;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.ViewConfiguration;
import android.view.WindowManager;
import android.widget.LinearLayout;

import com.example.yunlongzhang.opencvtest.R;

public class FloatingWindowView extends LinearLayout {

	private int mTouchSlop;
	
	private WindowManager wm;
	private WindowManager.LayoutParams params;
	private boolean isShow;

	public FloatingWindowView(Context context, AttributeSet attrs,
			int defStyleAttr) {
		super(context, attrs, defStyleAttr);

		initView();
	}

	public FloatingWindowView(Context context, AttributeSet attrs) {
		super(context, attrs);

		initView();
	}

	public FloatingWindowView(Context context) {
		super(context);

		initView();
	}

	private void initView() {
		ViewConfiguration config = ViewConfiguration.get(getContext());
		mTouchSlop = config.getScaledTouchSlop();
		
		setClipChildren(false);
		LayoutInflater.from(getContext()).inflate(
				R.layout.transparent, this);

		wm = (WindowManager) getContext().getSystemService(
				Context.WINDOW_SERVICE);
		DisplayMetrics metrics = new DisplayMetrics();
		wm.getDefaultDisplay().getMetrics(metrics);
		params = new WindowManager.LayoutParams();
	
		params.type = WindowManager.LayoutParams.TYPE_TOAST;
		params.format = PixelFormat.RGBA_8888;

		params.flags = WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN |
		WindowManager.LayoutParams.FLAG_LAYOUT_INSET_DECOR |
		WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS |
		WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE |
		WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE;
	}

	/*
	@Override
	public boolean dispatchTouchEvent(MotionEvent ev) {
		Log.e("TAG", "dispatchTouchEvent:" + ev.getX() + ev.getY());
		return true;
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		Log.e("TAG", "onTouchEvent:" + event.getX() + event.getY());
		return false;
	}*/

	public void show() {
		if (isShow) {
			return;
		}
		isShow = true;

		wm.addView(FloatingWindowView.this, params);
	}

	public void hide() {
		if (isShow) {
			wm.removeView(FloatingWindowView.this);
			isShow = false;
		}
	}

	public boolean getViewStatus() {
		return isShow;
	}

}
