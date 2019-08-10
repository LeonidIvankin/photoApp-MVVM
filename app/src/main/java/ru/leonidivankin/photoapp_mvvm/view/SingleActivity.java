package ru.leonidivankin.photoapp_mvvm.view;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import ru.leonidivankin.photoapp_mvvm.R;
import ru.leonidivankin.photoapp_mvvm.databinding.ActivitySingleBinding;
import ru.leonidivankin.photoapp_mvvm.model.utils.IConstant;
import ru.leonidivankin.photoapp_mvvm.viewModel.SingleViewModel;

public class SingleActivity extends AppCompatActivity {

    private static final String TAG = "SingleActivity";

    private NavController navController;
    private SingleViewModel viewModel;
    private ActivitySingleBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_single);
        viewModel = ViewModelProviders.of(this).get(SingleViewModel.class);
        navController = Navigation.findNavController(this, R.id.frame_layout_activity_single);

        viewModel.getPhotoId().observe(this, photoId -> {
            Log.d(TAG, "onCreate: " + photoId);
            Bundle bundle = new Bundle();
            bundle.putInt(IConstant.EXTRA_KEY_PHOTO_ID, photoId);
            navController.navigate(R.id.action_mainFragment_to_detailFragment, bundle);
        });
    }

}
