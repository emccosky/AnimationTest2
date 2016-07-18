package com.example.personal2.myapplication;

import android.graphics.Point;
import android.graphics.Rect;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        t.start();
    }

    public void setParms(int i){
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, android.app.ActionBar.LayoutParams.WRAP_CONTENT);
        params.setMargins(0,i,0,0);
        ((TextView)findViewById(R.id.test)).setLayoutParams(params);
    }

    public void animateCancer() throws InterruptedException {
        DisplayMetrics metrics = this.getResources().getDisplayMetrics();
        int height = metrics.heightPixels;

        Log.d("ccvxvf", "" + height);
        while(true){
            for (int i = 0; i < height; i++) {
                final int j = i;
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        setParms(j);
                    }
                });
                Thread.sleep(2);
            }
            for (int i = height; i > 0; i--) {
                final int j = i;
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        setParms(j);
                    }
                });
                Thread.sleep(2);
            }
        }
    }

    Thread t = new Thread(new Runnable() {
        @Override
        public void run() {
            try {
                animateCancer();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    });
}

