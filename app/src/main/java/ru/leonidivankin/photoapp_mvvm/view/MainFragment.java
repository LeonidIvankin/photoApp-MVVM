package ru.leonidivankin.photoapp_mvvm.view;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import ru.leonidivankin.photoapp_mvvm.R;

public class MainFragment extends Fragment {

    private static final String TAG = "MainFragment";

//    NavController navController;


    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        Button button = view.findViewById(R.id.button_fragment_main);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                navController.navigate();

                Log.d(TAG, "onClick: ");
            }
        });

        return view;
    }

}
