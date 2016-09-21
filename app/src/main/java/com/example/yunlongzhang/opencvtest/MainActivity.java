package com.example.yunlongzhang.opencvtest;

import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.yunlongzhang.opencvtest.Helper.OpenCVHelper;
import com.example.yunlongzhang.opencvtest.view.FloatingWindowView;

public class MainActivity extends AppCompatActivity {

    FloatingWindowView floatingWindowView;

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView img = (ImageView) findViewById(R.id.img);

        Bitmap bitmap = ((BitmapDrawable) getResources().getDrawable(
                R.drawable.node)).getBitmap();
        int w = bitmap.getWidth(), h = bitmap.getHeight();
        int[] pix = new int[w * h];
        bitmap.getPixels(pix, 0, w, 0, 0, w, h);
        int [] resultPixes= OpenCVHelper.gray(pix,w,h);
        Bitmap result = Bitmap.createBitmap(w,h, Bitmap.Config.RGB_565);
        result.setPixels(resultPixes, 0, w, 0, 0,w, h);
        img.setImageBitmap(result);

        Button bt = (Button) findViewById(R.id.distance);
        Button btfloat = (Button) findViewById(R.id.float_view);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntent = new Intent(MainActivity.this, CamaraActivity.class);
                startActivity(mIntent);
            }
        });
        btfloat.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                if (floatingWindowView == null) {
                    floatingWindowView = new FloatingWindowView(getBaseContext());
                    floatingWindowView.show();
                    ((Button)(view)).setText("关闭悬浮窗");
                    Log.e("TAG", "关闭悬浮窗1");
                } else {
                    if (floatingWindowView.getViewStatus()) {
                        floatingWindowView.hide();
                        ((Button)(view)).setText("打开悬浮窗");
                        Log.e("TAG", "打开悬浮窗");

                    } else {
                        floatingWindowView.show();
                        ((Button)(view)).setText("关闭悬浮窗");
                        Log.e("TAG", "关闭悬浮窗2");
                    }
                }
            }
        });
    }
}
