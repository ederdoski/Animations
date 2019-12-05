package com.example.animations;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.example.animations.utils.Animations;

public class MainActivity extends AppCompatActivity {

    private Animations mAnimations;
    private FrameLayout cardFront;
    private FrameLayout cardBack;
    private Button btnFade;
    private Button btnSlide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cardFront = findViewById(R.id.cardFront);
        cardBack  =  findViewById(R.id.cardBack);
        btnFade   =  findViewById(R.id.btnFade);
        btnSlide  =  findViewById(R.id.btnSlide);

        btnListeners();
        initAnimations();
    }

    private void initAnimations() {

        AnimatorSet animRightOut  = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.card_right_out_animation);
        AnimatorSet animLeftIn    = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.card_left_in_animation);
        AnimatorSet animLeftOut   = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.card_left_out_animation);
        AnimatorSet animRightIn   = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.card_right_in_animation);
        AnimatorSet animFadeOut   = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.fade_out_animation);
        AnimatorSet animFadeIn    = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.fade_in_animation);
        AnimatorSet animSlideUp   = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.slide_up_animation);
        AnimatorSet animSlideDown = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.slide_down_animation);

        mAnimations = new Animations();

        mAnimations.initCardAnimations(animRightOut, animLeftIn, animLeftOut, animRightIn);
        mAnimations.initSlideAnimations(animSlideDown, animSlideUp);
        mAnimations.initFadeAnimations(animFadeOut, animFadeIn);

        mAnimations.changeCameraDistance(getResources().getDisplayMetrics().density, cardFront, cardBack);
    }

    private void btnListeners() {
        cardFront.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flipCardToBack();
            }
        });

        cardBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flipCardToFront();
            }
        });

        btnFade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fadeAnimation();
            }
        });

        btnSlide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                slideAnimation();
            }
        });
    }

    private void slideAnimation() {
        mAnimations.slideDown(btnSlide);


        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mAnimations.slideUp(btnSlide);
            }
        }, 600);
    }

    private void fadeAnimation() {
        mAnimations.fadeOut(btnFade);

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mAnimations.fadeIn(btnFade);
            }
        }, 400);

    }

    private void flipCardToBack() {
        mAnimations.flipCard(cardFront, cardBack);
    }

    private void flipCardToFront() {
        mAnimations.flipCard(cardFront, cardBack);
    }


}
