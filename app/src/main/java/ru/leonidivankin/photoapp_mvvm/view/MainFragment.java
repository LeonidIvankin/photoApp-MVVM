package ru.leonidivankin.photoapp_mvvm.view;


import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import ru.leonidivankin.photoapp_mvvm.R;
import ru.leonidivankin.photoapp_mvvm.databinding.FragmentMainBinding;
import ru.leonidivankin.photoapp_mvvm.model.Photo;

public class MainFragment extends Fragment {

    private static final String TAG = "MainFragment";

    private NavController navController;


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

        //todo simplify
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        //todo simplify
        FragmentMainBinding binding = DataBindingUtil.setContentView(getActivity(), R.layout.fragment_main);
        RecyclerView recyclerView = binding.recyclerViewFragmentMain;
        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 2);
        recyclerView.setLayoutManager(layoutManager);
        PhotoAdapter adapter = new PhotoAdapter();
        adapter.setDate(list);
        recyclerView.setAdapter(adapter);



//        navController = Navigation.findNavController(getActivity(), R.id.frame_layout_activity_single);
//
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                navController.navigate(R.id.action_mainFragment_to_detailFragment);
//
//                Log.d(TAG, "onClick: ");
//            }
//        });

        return view;
    }

}
