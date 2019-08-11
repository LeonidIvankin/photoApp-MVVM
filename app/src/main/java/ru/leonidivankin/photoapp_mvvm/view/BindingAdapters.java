package ru.leonidivankin.photoapp_mvvm.view;

import android.util.Log;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.squareup.picasso.Callback;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

import ru.leonidivankin.photoapp_mvvm.idlingResource.EspressoIdlingResource;

public class BindingAdapters {

    private static final String TAG = "BindingAdapters";

    @BindingAdapter({"photoUrl"})
    public static void loadPhoto(ImageView imageView, String url){
        EspressoIdlingResource.increment();
        Picasso.get()
                .load(url)
                .networkPolicy(NetworkPolicy.OFFLINE)
                .into(imageView, new Callback() {
                    @Override
                    public void onSuccess() {
                        EspressoIdlingResource.decrement();
                    }

                    @Override
                    public void onError(Exception e) {
                        EspressoIdlingResource.decrement();
                        Log.e(TAG, "onError: " + e);
                    }
                });
    }
}
