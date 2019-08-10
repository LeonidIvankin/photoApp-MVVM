package ru.leonidivankin.photoapp_mvvm.view;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.squareup.picasso.Picasso;

public class BindingAdapters {

    @BindingAdapter({"photoUrl"})
    public static void loadPhoto(ImageView imageView, String url){
        Picasso.get()
                .load(url)
                .into(imageView);
    }
}
