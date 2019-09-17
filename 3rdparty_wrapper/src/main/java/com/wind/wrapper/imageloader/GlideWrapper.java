package com.wind.wrapper.imageloader;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;

public class GlideWrapper implements  IImageLoader{

    private Context mContext;
    private int mPlaceholderDrawable;
    private GlideWrapper(Context context){
       this.mContext=context;
    }

    public static GlideWrapper with(Context context){
        return new GlideWrapper(context);
    }

    public GlideWrapper placeholder(int placeholderDrawable){
        this.mPlaceholderDrawable=placeholderDrawable;
        return this;
    }
    @Override
    public void show(String uri, ImageView iv) {
        Glide.with(mContext)
                .load(uri)
                .placeholder(mPlaceholderDrawable)
                .into(iv);
    }

    @Override
    public void show(final String uri, final ILoadListener listener) {
        Glide.with(mContext)
                .load(uri)
                .placeholder(mPlaceholderDrawable)
                .into(new SimpleTarget<GlideDrawable>() {
                    @Override
                    public void onLoadFailed(Exception e, Drawable errorDrawable) {
                        super.onLoadFailed(e, errorDrawable);
                        listener.onLoadError(e);
                    }

                    @Override
                    public void onResourceReady(GlideDrawable resource, GlideAnimation<? super GlideDrawable> glideAnimation) {
                        listener.onLoadSuccess(uri,resource);
                    }
                });
    }
}
