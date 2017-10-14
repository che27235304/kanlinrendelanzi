package com.jiyun.com.newglide;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;
import com.bumptech.glide.request.target.Target;

public class Main3Activity extends AppCompatActivity {
    int duration;
    private int[] str = new int[]{R.drawable.gif1, R.drawable.gif2, R.drawable.gif3, R.drawable.gif4, R.drawable.gif5};
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1:
                    duration=0;
                    Glide.with(Main3Activity.this).load(str[1]).diskCacheStrategy(DiskCacheStrategy.SOURCE)
                            .listener(new RequestListener<Integer, GlideDrawable>() {
                                @Override
                                public boolean onException(Exception e, Integer model, Target<GlideDrawable> target, boolean isFirstResource) {
                                    return false;
                                }

                                @Override
                                public boolean onResourceReady(GlideDrawable resource, Integer model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                                    GifDrawable drawable = (GifDrawable) resource;
                                    GifDecoder decoder = drawable.getDecoder();

                                    for (int i = 0; i < drawable.getFrameCount(); i++) {
                                        duration += decoder.getDelay(i);
                                        decoder.getDelay(i);
                                    }

                                    handler.sendEmptyMessageDelayed(2,
                                            duration);

                                    return false;
                                }
                            }).into(new GlideDrawableImageViewTarget(ima2, 1));
                    break;
                case 2:
                    duration=0;
                    Glide.with(Main3Activity.this).load(str[2]).diskCacheStrategy(DiskCacheStrategy.SOURCE)
                            .listener(new RequestListener<Integer, GlideDrawable>() {
                                @Override
                                public boolean onException(Exception e, Integer model, Target<GlideDrawable> target, boolean isFirstResource) {
                                    return false;
                                }

                                @Override
                                public boolean onResourceReady(GlideDrawable resource, Integer model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                                    GifDrawable drawable = (GifDrawable) resource;
                                    GifDecoder decoder = drawable.getDecoder();

                                    for (int i = 0; i < drawable.getFrameCount(); i++) {
                                        duration += decoder.getDelay(i);
                                        decoder.getDelay(i);
                                    }

                                    handler.sendEmptyMessageDelayed(3,
                                            duration);

                                    return false;
                                }
                            }).into(new GlideDrawableImageViewTarget(ima3, 1));
                    break;
                case 3:
                    duration=0;
                    Glide.with(Main3Activity.this).load(str[3]).diskCacheStrategy(DiskCacheStrategy.SOURCE)
                            .listener(new RequestListener<Integer, GlideDrawable>() {
                                @Override
                                public boolean onException(Exception e, Integer model, Target<GlideDrawable> target, boolean isFirstResource) {
                                    return false;
                                }

                                @Override
                                public boolean onResourceReady(GlideDrawable resource, Integer model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                                    GifDrawable drawable = (GifDrawable) resource;
                                    GifDecoder decoder = drawable.getDecoder();

                                    for (int i = 0; i < drawable.getFrameCount(); i++) {
                                        duration += decoder.getDelay(i);
                                        decoder.getDelay(i);
                                    }

                                    handler.sendEmptyMessageDelayed(4,
                                            duration);

                                    return false;
                                }
                            }).into(new GlideDrawableImageViewTarget(ima4, 1));
                    break;
                case 4:
                    duration=0;
                    Glide.with(Main3Activity.this).load(str[4]).diskCacheStrategy(DiskCacheStrategy.SOURCE)
                            .listener(new RequestListener<Integer, GlideDrawable>() {
                                @Override
                                public boolean onException(Exception e, Integer model, Target<GlideDrawable> target, boolean isFirstResource) {
                                    return false;
                                }

                                @Override
                                public boolean onResourceReady(GlideDrawable resource, Integer model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                                    GifDrawable drawable = (GifDrawable) resource;
                                    GifDecoder decoder = drawable.getDecoder();

                                    for (int i = 0; i < drawable.getFrameCount(); i++) {
                                        duration += decoder.getDelay(i);
                                        decoder.getDelay(i);
                                    }

                                    handler.sendEmptyMessageDelayed(5,
                                            duration);

                                    return false;
                                }
                            }).into(new GlideDrawableImageViewTarget(ima5, 1));
                    break;
                case 5:
                    duration=0;
                    break;


            }
        }
    };
    private ImageView ima1;
    private ImageView ima2;
    private ImageView ima3;
    private ImageView ima4;
    private ImageView ima5;
    private ImageView ima6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        initView();
        Glide.with(this).load(str[0]).asBitmap().into(ima1);
        Glide.with(this).load(str[1]).asBitmap().into(ima2);
        Glide.with(this).load(str[2]).asBitmap().into(ima3);
        Glide.with(this).load(str[3]).asBitmap().into(ima4);
        Glide.with(this).load(str[4]).asBitmap().into(ima5);
        Glide.with(this).load(str[0]).diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .listener(new RequestListener<Integer, GlideDrawable>() {
                    @Override
                    public boolean onException(Exception e, Integer model, Target<GlideDrawable> target, boolean isFirstResource) {
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(GlideDrawable resource, Integer model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                        GifDrawable drawable = (GifDrawable) resource;
                        GifDecoder decoder = drawable.getDecoder();

                        for (int i = 0; i < drawable.getFrameCount(); i++) {
                            duration += decoder.getDelay(i);
                            decoder.getDelay(i);
                        }

                        handler.sendEmptyMessageDelayed(1,
                                duration);

                        return false;
                    }
                }).into(new GlideDrawableImageViewTarget(ima1, 1));

    }

    private void initView() {
        ima1 = (ImageView) findViewById(R.id.ima1);
        ima2 = (ImageView) findViewById(R.id.ima2);
        ima3 = (ImageView) findViewById(R.id.ima3);
        ima4 = (ImageView) findViewById(R.id.ima4);
        ima5 = (ImageView) findViewById(R.id.ima5);
        ima6 = (ImageView) findViewById(R.id.ima6);
    }
}
