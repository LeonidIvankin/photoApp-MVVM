package ru.leonidivankin.photoapp_mvvm.view;

import androidx.recyclerview.widget.RecyclerView;

import ru.leonidivankin.photoapp_mvvm.databinding.ItemMainBinding;
import ru.leonidivankin.photoapp_mvvm.model.entity.Hit;
import ru.leonidivankin.photoapp_mvvm.model.entity.Photo;
import ru.leonidivankin.photoapp_mvvm.viewModel.SingleViewModel;

public class PhotoHolder extends RecyclerView.ViewHolder {

    private ItemMainBinding binding;

    public PhotoHolder (ItemMainBinding binding){
        super(binding.getRoot());
        this.binding = binding;
    }

    public void bind(Hit hit, SingleViewModel singleViewModel){
        binding.setHit(hit);
        binding.setViewModel(singleViewModel);
        binding.executePendingBindings();
    }
}
