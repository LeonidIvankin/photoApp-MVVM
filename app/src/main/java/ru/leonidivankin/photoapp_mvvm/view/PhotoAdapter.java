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

public class PhotoAdapter extends RecyclerView.Adapter<PhotoHolder> {

    private List<Photo> list = new ArrayList<>();

    public void setDate(List<Photo> list){
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
        holder.bind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
