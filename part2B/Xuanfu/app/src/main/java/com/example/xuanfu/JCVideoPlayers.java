package com.example.xuanfu;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;

/**
 * Created by chj on 2017/9/1.
 */

class JCVideoPlayers extends JCVideoPlayer
{
    public JCVideoPlayers(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {



        return true;
    }

    @Override
    public boolean dispatchTrackballEvent(MotionEvent event) {
        return true;
    }


    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return super.onInterceptTouchEvent(ev);
    }
}
