package com.myapplicationdev.android.knowyourfactsps;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.crazyhitty.chdev.ks.rssmanager.RSS;
import com.crazyhitty.chdev.ks.rssmanager.RssReader;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Frag2 extends Fragment implements RssReader.RssCallback {
    TextView tvTitle,tvDesc;
    Button btnFrag2;
    LinearLayout bgFrag2;
    ImageView iv;
    ListView lvXML;
    CustomAdapter adapter;
    private String finaleUrl = "https://www.singstat.gov.sg/rss";
    private RssReader rssReader = new RssReader(this);
    public Frag2() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        rssReader.loadFeeds(finaleUrl);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_frag2, container, false);
        btnFrag2 = view.findViewById(R.id.fragBtn2);
        bgFrag2 = view.findViewById(R.id.linearFrag2);
        tvTitle = view.findViewById(R.id.fragFact2);
        tvDesc = view.findViewById(R.id.fragFact3);
        lvXML = view.findViewById(R.id.lvXML);


        iv = view.findViewById(R.id.iv);

//        obj = new HandleXML(finaleUrl);
//        obj.fetchXML();
//        while(obj.parsingComplete);
//        tvTitle.setText(obj.getTitle());
//        tvDesc.setText(obj.getDescription());

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

    @Override
    public void rssFeedsLoaded(List<RSS> rssList) {
        adapter = new CustomAdapter(getActivity(),R.layout.row_xml,rssList.get(0).getChannel().getItems());
        lvXML.setAdapter(adapter);
        Log.d("test",rssList.get(0).toString());
    }

    @Override
    public void unableToReadRssFeeds(String errorMessage) {

    }
}