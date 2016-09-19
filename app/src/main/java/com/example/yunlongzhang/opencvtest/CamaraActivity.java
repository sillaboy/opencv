package com.example.yunlongzhang.opencvtest;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.SurfaceView;

import com.example.yunlongzhang.opencvtest.view.DrawImageView;

/**
 * Created by yunlong.zhang on 2016/9/11.
 */
public class CamaraActivity extends Activity {

    DrawImageView layer_view;
    SurfaceView sv_view;

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.camara_activity);
        init();
    }

    private void init() {
        layer_view = (DrawImageView) findViewById(R.id.dv_overlay);
        sv_view = (SurfaceView) findViewById(R.id.sv_cam_prev);
    }
}
