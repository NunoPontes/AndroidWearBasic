package com.nunop.provaconceito1;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.wearable.view.WatchViewStub;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends Activity {

    private TextView mTextView;
    private Button btnLabel, btnImg;
    private ImageView imView;
    private View vTeste;

    public int randomcolor()
    {
        //Returns random color
        Random rnd = new Random();
        return Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
    }

    public void onButtonClicked(View target)
    {
        int heigth, width;
        heigth = imView.getLayoutParams().height;
        width = imView.getLayoutParams().width;

        imView.setImageResource(R.drawable.right);
        imView.setMaxHeight(heigth);
        imView.setMaxWidth(width);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final WatchViewStub stub = (WatchViewStub) findViewById(R.id.watch_view_stub);
        stub.setOnLayoutInflatedListener(new WatchViewStub.OnLayoutInflatedListener() {
            @Override
            public void onLayoutInflated(WatchViewStub stub) {
                mTextView = (TextView) stub.findViewById(R.id.tvTeste);
                btnLabel = (Button) findViewById(R.id.btnLabel);
                btnImg = (Button) findViewById(R.id.btnImg);
                imView = (ImageView) findViewById(R.id.imageView);
                vTeste = findViewById(R.id.viewTeste);

                btnImg.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onButtonClicked(v);
                    }
                });

                btnLabel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mTextView.setTextColor(randomcolor());
                    }
                });

                vTeste.setOnTouchListener(new OnSwipeTouchListener(getApplicationContext()) {
                    @Override
                    public void onSwipeLeft() {
                        vTeste.setBackgroundColor(randomcolor());
                    }
                });
            }
        });
    }
}