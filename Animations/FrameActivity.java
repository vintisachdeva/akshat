package com.bmpl.frameanimation;

import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class FrameActivity extends AppCompatActivity {

    ImageView imageView;
    Button startButton;

    //AnimationDrawable animationDrawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame);

        startButton = (Button)findViewById(R.id.startButton);
        imageView = (ImageView)findViewById(R.id.imageView);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Animation animation = AnimationUtils.loadAnimation(FrameActivity.this, R.anim.fade_in_animation);
                imageView.startAnimation(animation);
            }
        });

        /*imageView.setBackgroundResource(R.drawable.frame_animation);

        animationDrawable = (AnimationDrawable) imageView.getBackground();

        animationDrawable.start();*/

    }
}
