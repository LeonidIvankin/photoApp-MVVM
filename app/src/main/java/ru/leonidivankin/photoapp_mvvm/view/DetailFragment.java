package ru.leonidivankin.photoapp_mvvm.view;


import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ru.leonidivankin.photoapp_mvvm.R;
import ru.leonidivankin.photoapp_mvvm.databinding.FragmentDetailBinding;
import ru.leonidivankin.photoapp_mvvm.model.entity.Photo;
import ru.leonidivankin.photoapp_mvvm.model.entity.User;
import ru.leonidivankin.photoapp_mvvm.model.utils.IConstant;
import ru.leonidivankin.photoapp_mvvm.viewModel.SingleViewModel;

public class DetailFragment extends Fragment {

    private static final String TAG = "DetailFragment";

    private FragmentDetailBinding binding;
    private SingleViewModel viewModel;

    public DetailFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_detail, container, false);
        binding.setViewModel(viewModel);

        viewModel = ViewModelProviders.of(getActivity()).get(SingleViewModel.class);

        Bundle bundle = getArguments();
        if(bundle != null){
            int photoId = bundle.getInt(IConstant.EXTRA_KEY_PHOTO_ID);
            viewModel.getPhoto().observe(this, resource -> {
                if(resource.isSuccess()){
                    Log.d(TAG, "onCreateView: " + resource);
                    Photo photo = resource.getResource();
                    if(photo != null){
                        Log.d(TAG, "onCreateView: " + photo);
                        Log.d(TAG, "onCreateView: " + photo.totalHits);

                        //todo организовать через подписку, а не через setUser()
                        binding.setPhoto(photo);
                    }
                } else {
                    Log.e(TAG, "onCreateView: " + resource.getError());
                }

            });
        }

        return binding.getRoot();
    }

}
