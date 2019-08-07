package ru.leonidivankin.photoapp_mvvm.view;

import androidx.recyclerview.widget.RecyclerView;

import ru.leonidivankin.photoapp_mvvm.databinding.ItemMainBinding;
import ru.leonidivankin.photoapp_mvvm.model.Photo;
import ru.leonidivankin.photoapp_mvvm.viewModel.PhotoViewModel;

public class PhotoHolder extends RecyclerView.ViewHolder {

    private ItemMainBinding binding;

    public PhotoHolder (ItemMainBinding binding){
        super(binding.getRoot());
        this.binding = binding;
    }

    public void bind(Photo photo, PhotoViewModel photoViewModel){
        binding.setPhoto(photo);
        binding.setViewModel(photoViewModel);
        binding.executePendingBindings();
    }
}
