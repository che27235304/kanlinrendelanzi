package com.jiyun.com.newglide;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;
import com.bumptech.glide.request.target.Target;

import static android.R.attr.duration;

/**
 * Created by dell on 2017/10/12.
 */

public class MyAdapter extends BaseAdapter {
    private Context context;

    int a;
    private int[] str=new int[]{R.drawable.gif1,R.drawable.gif2,R.drawable.gif3,R.drawable.gif4,R.drawable.gif5};



    public MyAdapter(Main2Activity main2Activity) {
        this.context=main2Activity;
    }


    @Override
    public int getCount() {
        return str.length;
    }

    @Override
    public Object getItem(int i) {
        return str[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;

        if(view==null){
            holder=new ViewHolder();
            view= LayoutInflater.from(context).inflate(R.layout.item,null);
            holder.imageView=view.findViewById(R.id.imaima);
            view.setTag(holder);
        }else{
            holder= (ViewHolder) view.getTag();
        }

      Glide.with(context).load(str[i]).asBitmap().into(holder.imageView);








        return view;
    }

    class ViewHolder {
        ImageView imageView;
    }
}
