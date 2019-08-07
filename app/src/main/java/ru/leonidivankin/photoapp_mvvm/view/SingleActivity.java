package ru.leonidivankin.photoapp_mvvm.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.os.Bundle;

import ru.leonidivankin.photoapp_mvvm.R;

public class SingleActivity extends AppCompatActivity {

    private NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single);

        navController = Navigation.findNavController(this, R.id.frame_layout_activity_single);
    }
}
