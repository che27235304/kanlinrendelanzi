package com.jiyun.com.newglide;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;
import com.bumptech.glide.request.target.Target;


public class MainActivity extends AppCompatActivity {

    private ImageView image;
    long duration;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 6:

                    ima2.setVisibility(View.VISIBLE);
                    break;
            }
        }
    };
    private ImageView ima2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();


    }

    private void initView() {
        image = (ImageView) findViewById(R.id.image);
        ima2 = (ImageView) findViewById(R.id.ima2);
        ima2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ima2.setVisibility(View.GONE);
                //第一种
                Glide.with(MainActivity.this)
                        .load(R.drawable.gif2)
                        .asGif()
                        .into(image);
                ////第二种
                Glide.with(MainActivity.this).load(R.drawable.gif2).diskCacheStrategy(DiskCacheStrategy.SOURCE)
                        .listener(new RequestListener<Integer, GlideDrawable>() {


                            @Override
                            public boolean onException(Exception arg0, Integer arg1,
                                                       Target<GlideDrawable> arg2, boolean arg3) {
                                return false;
                            }

                            @Override
                            public boolean onResourceReady(GlideDrawable resource,
                                                           Integer model, Target<GlideDrawable> target,
                                                           boolean isFromMemoryCache, boolean isFirstResource) {
                                // 计算动画时长
//
//                                GifDrawable drawable = (GifDrawable) resource;
//                                GifDecoder decoder = drawable.getDecoder();
//                                for (int i = 0; i < drawable.getFrameCount(); i++) {
//                                    duration += decoder.getDelay(i);
//                                    decoder.getDelay(i);
//                                }
                                //发送延时消息，通知动画结束
//                                handler.sendEmptyMessageDelayed(6,
//                                        duration);
                                //handler.sendEmptyMessage(6);
                                return false;
                            }


                        }) //仅仅加载一次gif动画
                        .into(new GlideDrawableImageViewTarget(image, 2));


            }
        });
    }


}
