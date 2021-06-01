package com.myapplicationdev.android.knowyourfactsps;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.crazyhitty.chdev.ks.rssmanager.Channel;
import com.crazyhitty.chdev.ks.rssmanager.RSS;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends ArrayAdapter<Channel.Item> {
    Context context;
    List<Channel.Item> rss;
    int resource;
    TextView tvTitle,tvDescription;
    public CustomAdapter(@NonNull Context context, int resource, List<Channel.Item> rss) {
        super(context, resource, rss);
        this.context = context;
        this.resource = resource;
        this.rss = rss;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(resource, parent, false);

        tvTitle = rowView.findViewById(R.id.tvTitle);
        tvDescription = rowView.findViewById(R.id.tvDescription);

        Channel.Item rssReader = rss.get(position);
        tvTitle.setText(rssReader.getTitle());
        tvDescription.setText(rssReader.getDescription());
        return rowView;
    }
}
