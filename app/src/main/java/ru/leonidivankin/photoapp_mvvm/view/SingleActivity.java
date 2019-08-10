package ru.leonidivankin.photoapp_mvvm.view;

import android.os.Bundle;

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


    private SingleViewModel viewModel;
    private ActivitySingleBinding binding;
    private NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_single);
        viewModel = ViewModelProviders.of(this).get(SingleViewModel.class);
        navController = Navigation.findNavController(this, R.id.frame_layout_activity_single);

        viewModel.getHitId().observe(this, hitId -> {
            if(navController.getCurrentDestination().getId() == R.id.mainFragment){
                Bundle bundle = new Bundle();
                bundle.putInt(IConstant.EXTRA_KEY_HIT_ID, hitId);
                navController.navigate(R.id.action_mainFragment_to_detailFragment, bundle);
            }
        });


    }

}
