package com.creativeminds.testappflutur;

import android.graphics.Color;
import android.graphics.MaskFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import jp.wasabeef.blurry.Blurry;

public class BlurActivity extends AppCompatActivity {

    private Button button;
    private RelativeLayout relativeLayout;
    private TextView hello;
    private boolean isBlurred=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blur);

        button = findViewById(R.id.btnId);
        relativeLayout = findViewById(R.id.relativeLayout);

        hello= new TextView(BlurActivity.this);
        hello.setText("Hello World...!");
        hello.setGravity(Gravity.CENTER);
        hello.setTextSize(50);
        hello.setTextColor(Color.argb(80,255,255,255));

        RelativeLayout.LayoutParams layoutparams = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        layoutparams.addRule(RelativeLayout.CENTER_IN_PARENT);

        hello.setLayoutParams(layoutparams);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isBlurred) {
                    isBlurred = false;
                    relativeLayout.removeView(hello);
                    Blurry.delete((ViewGroup)relativeLayout);
                }else {
                    isBlurred = true;
                    Blurry.with(BlurActivity.this).radius(25).sampling(2).onto((ViewGroup) findViewById(R.id.relativeLayout));
                    relativeLayout.addView(hello);
                }
            }
        });
    }

}
