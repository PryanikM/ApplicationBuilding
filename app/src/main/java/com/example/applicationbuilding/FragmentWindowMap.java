package com.example.applicationbuilding;

import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Objects;

public class FragmentWindowMap extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_window_map, container, false);
    }

    public void setText(String text){
        ConstraintLayout constraintLayout = requireView().findViewById(R.id.infoLayout);
        TextView addressTxt = requireView().findViewById(R.id.addressTxt);
        constraintLayout.setVisibility(ConstraintLayout.VISIBLE);
        addressTxt.setText(text);
    }
}