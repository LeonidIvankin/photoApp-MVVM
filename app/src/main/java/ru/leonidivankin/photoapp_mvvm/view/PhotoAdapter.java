package ru.leonidivankin.photoapp_mvvm.view;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ru.leonidivankin.photoapp_mvvm.R;
import ru.leonidivankin.photoapp_mvvm.databinding.ItemMainBinding;
import ru.leonidivankin.photoapp_mvvm.model.entity.Hit;
import ru.leonidivankin.photoapp_mvvm.model.entity.Photo;
import ru.leonidivankin.photoapp_mvvm.viewModel.SingleViewModel;

public class PhotoAdapter extends RecyclerView.Adapter<PhotoHolder> {

    private SingleViewModel singleViewModel;
    private List<Hit> hitList;


    public PhotoAdapter(SingleViewModel singleViewModel) {
        this.singleViewModel = singleViewModel;
    }

    public void setHitList(List<Hit> hitList) {
        this.hitList = hitList;
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
        //todo to viewModel
        holder.bind(hitList.get(position), singleViewModel);
    }

    @Override
    public int getItemCount() {
        if (hitList != null) {
            return hitList.size();
        }
        return 0;
    }
}
