package ru.leonidivankin.photoapp.view;

import androidx.recyclerview.widget.RecyclerView;

import ru.leonidivankin.photoapp.databinding.ItemMainBinding;
import ru.leonidivankin.photoapp.model.Photo;
import ru.leonidivankin.photoapp.viewModel.MainViewModel;

public class PhotoHolder extends RecyclerView.ViewHolder {

    private ItemMainBinding binding;

    public PhotoHolder (ItemMainBinding binding){
        super(binding.getRoot());
        this.binding = binding;
    }

    public void bind(Photo photo, MainViewModel mainViewModel){
        binding.setPhoto(photo);
        binding.setViewModel(mainViewModel);
        binding.executePendingBindings();
    }
}
