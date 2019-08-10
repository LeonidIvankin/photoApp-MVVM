package ru.leonidivankin.photoapp_mvvm.view;


import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import ru.leonidivankin.photoapp_mvvm.R;
import ru.leonidivankin.photoapp_mvvm.model.Photo;
import ru.leonidivankin.photoapp_mvvm.model.utils.IConstant;
import ru.leonidivankin.photoapp_mvvm.viewModel.MainViewModel;
import ru.leonidivankin.photoapp_mvvm.databinding.FragmentMainBinding;

public class MainFragment extends Fragment {

    private static final String TAG = "MainFragment";

    private FragmentMainBinding binding;
    private MainViewModel viewModel;




    public MainFragment() {
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        List<Photo> list = new ArrayList<>();

        for (int i = 1; i <= 16; i++) {
            list.add(new Photo(i, "photo" + i));
        }

        viewModel = ViewModelProviders.of(getActivity()).get(MainViewModel.class);

        //todo simplify
//        View view = inflater.inflate(R.layout.fragment_main, container, false);

        //todo simplify
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false);


        initRecyclerView(list, binding);

        return binding.getRoot();
    }

    private void initRecyclerView(List<Photo> list, FragmentMainBinding binding) {
        RecyclerView recyclerView = binding.recyclerViewFragmentMain;
        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), IConstant.RECYCLER_COLUMN_COUNT);
        recyclerView.setLayoutManager(layoutManager);

        PhotoAdapter adapter = new PhotoAdapter(viewModel, list);
        recyclerView.setAdapter(adapter);
    }

}
