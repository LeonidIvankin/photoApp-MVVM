package ru.leonidivankin.photoapp_mvvm.view;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import ru.leonidivankin.photoapp_mvvm.R;
import ru.leonidivankin.photoapp_mvvm.databinding.ItemMainBinding;
import ru.leonidivankin.photoapp_mvvm.model.Photo;
import ru.leonidivankin.photoapp_mvvm.viewModel.PhotoViewModel;

public class PhotoAdapter extends RecyclerView.Adapter<PhotoHolder> {

    private PhotoViewModel photoViewModel;
    private List<Photo> list;


    public PhotoAdapter(PhotoViewModel photoViewModel, List<Photo> list) {
        this.photoViewModel = photoViewModel;
        this.list = list;
    }


    @NonNull
    @Override
    public PhotoHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemMainBinding binding = DataBindingUtil.inflate(inflater, R.layout.item_main, parent, false);
        return new PhotoHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull PhotoHolder holder, int position) {
        holder.bind(list.get(position), photoViewModel);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
