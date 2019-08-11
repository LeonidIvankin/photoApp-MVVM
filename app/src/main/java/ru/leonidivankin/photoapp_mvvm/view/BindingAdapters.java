package ru.leonidivankin.photoapp_mvvm.view;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;

public class BindingAdapters {

    @BindingAdapter({"photoUrl"})
    public static void loadPhoto(ImageView imageView, String url) {
        Glide.with(imageView.getContext())
                .load(url)
                .into(imageView);
    }
}
