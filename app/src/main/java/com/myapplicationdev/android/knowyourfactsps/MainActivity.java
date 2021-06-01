package com.myapplicationdev.android.knowyourfactsps;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Fragment> al;
    MyFragmentPagerAdapter adapter;
    ViewPager vPager;

    Button btnLater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vPager = findViewById(R.id.viewpager1);

        btnLater = findViewById(R.id.btnLater);


        FragmentManager fm = getSupportFragmentManager();

        al = new ArrayList<Fragment>();
        al.add(new Frag1());
        al.add(new Frag2());

        adapter = new MyFragmentPagerAdapter(fm, al);

        vPager.setAdapter(adapter);

        btnLater.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        case R.id:
        newGame();
        return true;
        case R.id.help:
        showHelp();
        return true;
        default:
        return super.onOptionsItemSelected(item);
    }
}