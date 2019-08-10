package ru.leonidivankin.photoapp_mvvm.view;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import ru.leonidivankin.photoapp_mvvm.R;
import ru.leonidivankin.photoapp_mvvm.viewModel.MainViewModel;

public class SingleActivity extends AppCompatActivity {

    private static final String TAG = "SingleActivity";

    private NavController navController;
    private MainViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single);

        viewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        navController = Navigation.findNavController(this, R.id.frame_layout_activity_single);

        viewModel.getPhotoId().observe(this, value -> {
            Log.d(TAG, "onCreate: " + value);
            navController.navigate(R.id.detailFragment);
//            navController.navigate(R.id.detailFragment);
        });
    }

}
