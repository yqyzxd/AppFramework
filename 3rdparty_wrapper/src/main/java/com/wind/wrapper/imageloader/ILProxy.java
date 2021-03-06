package com.wind.wrapper.imageloader;

import android.content.Context;
import android.widget.ImageView;

public class ILProxy extends SimpleImageLoader {
    private IImageLoader loader;
    public ILProxy(Context context){
        loader= GlideWrapper.with(context);
    }

    public static ILProxy with(Context context){
        return new ILProxy(context);
    }

    public IImageLoader placeholder(int placeholderDrawable){
        if (loader instanceof SimpleImageLoader){
            SimpleImageLoader simpleImageLoader= (SimpleImageLoader) loader;
            simpleImageLoader.placeholder(placeholderDrawable);
        }
        return this;
    }

    @Override
    public void show(String uri, ImageView iv) {
        loader.show(uri,iv);
    }

    @Override
    public void show(String uri, ILoadListener listener) {
        loader.show(uri,listener);
    }
}
