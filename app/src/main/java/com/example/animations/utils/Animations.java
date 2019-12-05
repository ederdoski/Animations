package com.example.animations.utils;

import android.animation.AnimatorSet;
import android.util.Log;
import android.view.View;

public class Animations {

    private AnimatorSet viewRightOut;
    private AnimatorSet viewLeftIn;

    private AnimatorSet viewLeftOut;
    private AnimatorSet viewRightIn;

    private AnimatorSet fadeOut;
    private AnimatorSet fadeIn;

    private AnimatorSet slideUp;
    private AnimatorSet slideDown;

    private AnimatorSet slideUpModal;
    private AnimatorSet slideDownModal;

    private boolean isFullDataCardVisible;

    public void initCardAnimations(AnimatorSet mSetRightOut, AnimatorSet mSetLeftIn,
                                   AnimatorSet viewLeftOut, AnimatorSet viewRightIn) {

        this.viewRightOut   = mSetRightOut;
        this.viewLeftIn     = mSetLeftIn;
        this.viewLeftOut    = viewLeftOut;
        this.viewRightIn    = viewRightIn;
        isFullDataCardVisible = false;
    }

    public void initFadeAnimations(AnimatorSet fadeOut, AnimatorSet fadeIn) {
        this.fadeOut = fadeOut;
        this.fadeIn  = fadeIn;
    }

    public void initModalSlideAnimations(AnimatorSet slideUpModal, AnimatorSet slideDownModal) {
        this.slideUpModal    = slideUpModal;
        this.slideDownModal  = slideDownModal;
    }

    public void initSlideAnimations(AnimatorSet slideDown, AnimatorSet slideUp) {
        this.slideDown = slideDown;
        this.slideUp   = slideUp;
    }

    public void changeCameraDistance(float density, View cardFront, View cardBack) {
        int distance = 40000;
        float scale  = density * distance;

        cardFront.setCameraDistance(scale);
        cardBack.setCameraDistance(scale);
    }

    public void flipCard(View cardFront, View cardBack) {

        if (!isFullDataCardVisible) {
            flipRight(cardFront, cardBack);
        } else {
            flipLeft(cardFront, cardBack);
        }

        isFullDataCardVisible = !isFullDataCardVisible;
    }

    private void flipRight(View cardFront, View cardBack) {
        if(viewRightOut != null && viewLeftIn != null) {
            viewRightOut.setTarget(cardFront);
            viewLeftIn.setTarget(cardBack);
            viewRightOut.start();
            viewLeftIn.start();
        }else{
            showError();
        }
    }

    private void flipLeft(View cardFront, View cardBack) {
        if(viewRightOut != null && viewLeftIn != null) {
            viewLeftOut.setTarget(cardBack);
            viewRightIn.setTarget(cardFront);
            viewLeftOut.start();
            viewRightIn.start();
        }else{
            showError();
        }
    }

    public void fadeOut(View view) {
        if(fadeOut != null) {
            fadeOut.setTarget(view);
            fadeOut.start();
        }else{
            showError();
        }
    }

    public void fadeIn(View view) {
        if(fadeIn != null) {
            fadeIn.setTarget(view);
            fadeIn.start();
        }else{
            showError();
        }
    }

    public void slideUp(View view) {
        if(slideUp != null) {
            slideUp.setTarget(view);
            slideUp.start();
        }else{
            showError();
        }
    }

    public void slideDown(View view) {
        if(slideDown != null) {
            slideDown.setTarget(view);
            slideDown.start();
        }else{
            showError();
        }
    }

    public void slideUpModal(View view) {
        if(slideUpModal != null) {
            slideUpModal.setTarget(view);
            slideUpModal.start();
        }else{
            showError();
        }
    }

    public void slideDownModal(View view) {
        if(slideDownModal != null) {
            slideDownModal.setTarget(view);
            slideDownModal.start();
        }else{
            showError();
        }
    }

    private void showError() {
        Log.e(getClass().getName(), "Constructor no inicializado");
    }

}
