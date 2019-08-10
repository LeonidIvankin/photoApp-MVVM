package ru.leonidivankin.photoapp_mvvm.view;


import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ru.leonidivankin.photoapp_mvvm.R;
import ru.leonidivankin.photoapp_mvvm.databinding.FragmentDetailBinding;
import ru.leonidivankin.photoapp_mvvm.model.utils.IConstant;

public class DetailFragment extends Fragment {

    private static final String TAG = "DetailFragment";

    private FragmentDetailBinding binding;

    public DetailFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_detail, container, false);

        Bundle bundle = getArguments();
        if(bundle != null){
            int photoId = bundle.getInt(IConstant.EXTRA_KEY_PHOTO_ID);
            Log.d(TAG, "onCreateView: " + photoId);
        }

        return binding.getRoot();
    }

}
