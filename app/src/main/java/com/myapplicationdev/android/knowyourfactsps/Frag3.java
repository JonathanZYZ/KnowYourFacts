package com.myapplicationdev.android.knowyourfactsps;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.Random;


public class Frag3 extends Fragment {
Button btnChange;
LinearLayout layout;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_frag3, container, false);
        // Inflate the layout for this fragment
        btnChange = view.findViewById(R.id.btnChangeColour);
        layout = view.findViewById(R.id.layoutFrag);
        btnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Random rdmColor = new Random();
                int color = Color.argb(255, rdmColor.nextInt(256), rdmColor.nextInt(256), rdmColor.nextInt(256));
                layout.setBackgroundColor(color);
            }
        });
        return view;
    }
}