package ru.leonidivankin.photoapp_mvvm.view;


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import javax.inject.Inject;

import ru.leonidivankin.photoapp_mvvm.R;
import ru.leonidivankin.photoapp_mvvm.databinding.FragmentMainBinding;
import ru.leonidivankin.photoapp_mvvm.model.utils.IConstant;
import ru.leonidivankin.photoapp_mvvm.model.utils.NetworkStatus;
import ru.leonidivankin.photoapp_mvvm.viewModel.SingleViewModel;
import toothpick.Toothpick;

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

        Toothpick.inject(this, Toothpick.openScope(IConstant.TOOTH_PICK_SCOPE));

        viewModel = ViewModelProviders.of(getActivity()).get(SingleViewModel.class);
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false);
        initRecyclerView(binding);

        viewModel.getPhoto().observe(this, listHits -> {
            adapter.setHitList(listHits);
            adapter.notifyDataSetChanged();
        });

        viewModel.getEMessageLiveData().observe(this, eMessage -> {
            String message = getString(eMessage);
            Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
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
