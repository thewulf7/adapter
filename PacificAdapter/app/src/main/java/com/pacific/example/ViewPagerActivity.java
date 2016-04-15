package com.pacific.example;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.pacific.adapter.PagerAdapterHelper;
import com.pacific.adapter.ViewPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerActivity extends AppCompatActivity {

    private ViewPagerAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);
        adapter = new ViewPagerAdapter<String>(this) {
            @Override
            protected void convert(PagerAdapterHelper helper, String item) {
                helper.setBackgroundRes(R.id.img_view, R.drawable.exa);
            }

            @Override
            protected View createView(ViewGroup container, int position) {
                FrameLayout fl = new FrameLayout(context);
                ImageView imageView = new ImageView(context);
                FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(480, 480, Gravity.CENTER);
                imageView.setId(R.id.img_view);
                fl.addView(imageView);
                imageView.setLayoutParams(lp);
                return fl;
            }
        };
        ((ViewPager) findViewById(R.id.view_pager)).setAdapter(adapter);
        List<String> urls = new ArrayList<>();
        urls.add("0");
        urls.add("1");
        urls.add("2");
        urls.add("3");
        urls.add("4");
        urls.add("5");
        urls.add("6");
        urls.add("7");
        urls.add("8");
        urls.add("9");
        urls.add("11");
        urls.add("12");
        urls.add("13");
        urls.add("14");
        urls.add("15");
        urls.add("16");
        urls.add("17");
        urls.add("18");
        urls.add("19");
        adapter.addAll(urls);
    }
}
