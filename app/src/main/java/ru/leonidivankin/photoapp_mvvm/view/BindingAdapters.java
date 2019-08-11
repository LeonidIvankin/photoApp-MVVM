package ru.leonidivankin.photoapp_mvvm.view;

import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

import ru.leonidivankin.photoapp_mvvm.idlingResource.EspressoIdlingResource;

public class BindingAdapters {

    private static final String TAG = "BindingAdapters";

    @BindingAdapter({"photoUrl"})
    public static void loadPhoto(ImageView imageView, String url) {
        EspressoIdlingResource.increment();
        Glide.with(imageView.getContext())
                .addDefaultRequestListener(new RequestListener<Object>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Object> target, boolean isFirstResource) {
                        EspressoIdlingResource.decrement();
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(Object resource, Object model, Target<Object> target, DataSource dataSource, boolean isFirstResource) {
                        EspressoIdlingResource.decrement();
                        return false;
                    }
                })
                .load(url)
                .into(imageView);
    }
}
