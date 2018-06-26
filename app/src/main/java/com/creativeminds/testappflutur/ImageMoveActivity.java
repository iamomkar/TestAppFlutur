package com.creativeminds.testappflutur;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

public class ImageMoveActivity extends AppCompatActivity {

    private ImageView imageView;

    private float x,y;
    @Override
    @SuppressLint("ClickableViewAccessibility")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_move);

        imageView =findViewById(R.id.image);


        imageView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                switch (event.getActionMasked()) {
                    case MotionEvent.ACTION_DOWN:
                        x = view.getX() - event.getRawX();
                        y = view.getY() - event.getRawY();
                        break;
                    case MotionEvent.ACTION_MOVE:
                        float nX = event.getRawX() + x;
                        float nY = event.getRawY() + y;
                        view.animate().x(nX).y(nY).setDuration(0).start();
                        Log.d("Position"," X = "+nX+" , Y = "+nY);
                        break;
                    default:
                        return false;
                }
                return true;
            }
        });
    }
}
