package com.example.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import com.example.demo.entity.ExampleItem;
import com.pacific.adapter.AbsAdapter;
import com.pacific.adapter.AdapterCompact;
import com.pacific.adapter.SimpleItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    AbsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.lv);
        adapter = new AbsAdapter();
        adapter.addOnClickListener(R.layout.item_list_view, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ExampleItem item = AdapterCompact.getItem(v);
                int position = AdapterCompact.getPosition(v);
                Log.e("_____", String.valueOf(item.getTitle()));
                Log.e("_____", String.valueOf(position));
            }
        });
        listView.setAdapter(adapter);
        loadItem();
    }

    private void loadItem() {
        List<SimpleItem> list = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            list.add(new ExampleItem("item index is : " + i));
        }
        adapter.addAll(list);
    }
}
