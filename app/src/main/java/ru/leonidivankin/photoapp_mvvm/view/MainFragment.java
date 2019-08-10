package ru.leonidivankin.photoapp_mvvm.view;


import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import ru.leonidivankin.photoapp_mvvm.databinding.FragmentMainBinding;
import ru.leonidivankin.photoapp_mvvm.R;
import ru.leonidivankin.photoapp_mvvm.model.entity.Hit;
import ru.leonidivankin.photoapp_mvvm.model.entity.Photo;
import ru.leonidivankin.photoapp_mvvm.model.utils.IConstant;
import ru.leonidivankin.photoapp_mvvm.viewModel.SingleViewModel;

public class MainFragment extends Fragment {

    private static final String TAG = "MainFragment";

    private FragmentMainBinding binding;
    private SingleViewModel viewModel;
    private PhotoAdapter adapter;

    public MainFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        viewModel = ViewModelProviders.of(getActivity()).get(SingleViewModel.class);
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false);
        initRecyclerView(binding);

        //todo переместить запрос во viewModel
        viewModel.getPhoto().observe(this, resource -> {
            if(resource.isSuccess()){
                Log.d(TAG, "onCreateView: " + resource);
                Photo photo = resource.getResource();
                if(photo != null){
                    adapter.setHitList(photo.hits);
                    adapter.notifyDataSetChanged();
                }
            } else {
                Log.e(TAG, "onCreateView: " + resource.getError());
            }

        });

        return binding.getRoot();
    }

    private void initRecyclerView(FragmentMainBinding binding) {
        RecyclerView recyclerView = binding.recyclerViewFragmentMain;
        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), IConstant.RECYCLER_COLUMN_COUNT);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new PhotoAdapter(viewModel);
        recyclerView.setAdapter(adapter);
    }

}
