package com.alex.waveview;


import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;

public class WaveView extends View {
    private int firstwidth = 0;
    private int firstheight = 0;
    private int baseLine = 0;// 基线，用于控制水位上涨的，这里是写死了没动，你可以不断的设置改变。
    private Paint mPaint;
    private int waveHeight = 100;// 波浪的最高度
    private int waveWidth;//波长
    private float offset = 0f;//偏移量

    private int mWaveLength;
    private int mScreenWidth;
    private int mScreenHeight;
    private int mCenterY;
    private  int mWaveCount;
    private int offset2;

    private Path mPath;
    private Paint paint;

    public WaveView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    /**
     * 不断的更新偏移量，并且循环。
     */
    private void updateXControl() {
        //设置一个波长的偏移
        ValueAnimator mAnimator = ValueAnimator.ofFloat(0, waveWidth);
        mAnimator.setInterpolator(new LinearInterpolator());
        mAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {

            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float animatorValue = (float) animation.getAnimatedValue();
                offset = animatorValue;//不断的设置偏移量，并重画
                postInvalidate();
            }
        });
        mAnimator.setDuration(1000);
        mAnimator.setRepeatCount(ValueAnimator.INFINITE);
        mAnimator.start();

        ValueAnimator mValueAnimatior = ValueAnimator.ofInt(0, mWaveLength);
        mValueAnimatior.setDuration(1000);
        mValueAnimatior.setInterpolator(new LinearInterpolator());
        mValueAnimatior.setRepeatCount(ValueAnimator.INFINITE);
        mValueAnimatior.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                offset2 = (int) animation.getAnimatedValue();
                invalidate();
            }
        });
        mValueAnimatior.start();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(getPath(), mPaint);
        int itemWidth = waveWidth / 2;//半个波长
        mPath.reset();
        mPath.moveTo(-mWaveLength,mCenterY);
  /*      for (int i = 0; i < mWaveCount; i++) {
            mPath.quadTo(-mWaveLength * 3/ 4 + i * mWaveLength + offset,mCenterY + 60,-mWaveLength / 2 + i * mWaveLength + offset2,mCenterY);
            mPath.quadTo(-mWaveLength / 4 + i * mWaveLength + offset,mCenterY - 60,i * mWaveLength + offset2,mCenterY);
        }*/
        mPath.moveTo(-itemWidth * 3, baseLine);//起始坐标
        //核心的代码就是这里
        for (int i = -3; i < 2; i++) {
            int startX = i * itemWidth;
            mPath.quadTo(
                    startX + itemWidth / 2 + offset2,//控制点的X,（起始点X + itemWidth/2 + offset)
                    getWaveHeigh(i),//控制点的Y
                    startX + itemWidth + offset2,//结束点的X
                    mCenterY//结束点的Y
            );//只需要处理完半个波长，剩下的有for循环自已就添加了。
        }
        mPath.lineTo(mScreenWidth,mScreenHeight);
        mPath.lineTo(0,mScreenHeight);
        mPath.close();
        canvas.drawPath(mPath,paint);
    }

    //初始化paint，没什么可说的。
    private void initView() {
        mPaint = new Paint();
        mPaint.setColor(getResources().getColor(R.color.mcolor));
        mPaint.setStyle(android.graphics.Paint.Style.FILL);

        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setStrokeWidth(9);
        paint.setColor(getResources().getColor(R.color.mcolor2));
        mWaveLength = 1200;
    }
    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        firstwidth = getMeasuredWidth();//获取屏幕宽度
        firstheight = getMeasuredHeight();//获取屏幕高度
        waveWidth = firstwidth;
        baseLine = firstheight / 2;
        // 需要计算出屏幕能容纳多少个波形
        mPath = new Path();
        mScreenHeight = getMeasuredHeight();
        mScreenWidth = getMeasuredWidth();
        mCenterY = getMeasuredHeight()/ 2;
        mWaveCount = (int) Math.round(mScreenWidth / mWaveLength + 1.5); // 计算波形的个数
        updateXControl();
    }

    /**
     * 核心代码，计算path
     *
     * @return
     */
    private Path getPath() {
        int itemWidth = waveWidth / 2;//半个波长
        Path mPath = new Path();
        mPath.moveTo(-itemWidth * 3, baseLine-10);//起始坐标
        //核心的代码就是这里
        for (int i = -3; i < 2; i++) {
            int startX = i * itemWidth;
            mPath.quadTo(
                    startX + itemWidth / 2 + offset,//控制点的X,（起始点X + itemWidth/2 + offset)
                    getWaveHeigh(i),//控制点的Y
                    startX + itemWidth + offset,//结束点的X
                    baseLine//结束点的Y
            );//只需要处理完半个波长，剩下的有for循环自已就添加了。
        }
        //下面这三句话很重要，它是形成了一封闭区间，让曲线以下的面积填充一种颜色，大家可以把这3句话注释了看看效果。
        mPath.lineTo(firstwidth, firstheight);
        mPath.lineTo(0, firstheight);
        mPath.close();
        return mPath;
    }

    //奇数峰值是正的，偶数峰值是负数
    private int getWaveHeigh(int num) {
        if (num % 2 == 0) {
            return baseLine + waveHeight;
        }
        return baseLine - waveHeight;
    }
}