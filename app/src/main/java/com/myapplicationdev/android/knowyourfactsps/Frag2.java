package com.myapplicationdev.android.knowyourfactsps;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.squareup.picasso.Picasso;

import java.util.Random;

public class Frag2 extends Fragment {

    Button btnFrag2;
    LinearLayout bgFrag2;
    ImageView iv;

    public Frag2() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_frag2, container, false);
        btnFrag2 = view.findViewById(R.id.fragBtn2);
        bgFrag2 = view.findViewById(R.id.linearFrag2);
        iv = view.findViewById(R.id.iv);

        String imageUrl = "https://wtffunfact.com/wp-content/uploads/2021/05/WTF-Fun-Fact-Presidents-Without-Pets.png";
        Picasso.with(this.getActivity()).load(imageUrl).into(iv);



        btnFrag2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random rnd = new Random();
                int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
                bgFrag2.setBackgroundColor(color);
            }
        });
        return view;
    }
}