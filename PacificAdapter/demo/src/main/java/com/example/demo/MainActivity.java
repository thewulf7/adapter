package com.example.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.example.demo.entity.Item;
import com.example.demo.entity.ItemDataBinding;
import com.pacific.adapter.AbsAdapter;
import com.pacific.adapter.AdapterUtil;
import com.pacific.adapter.ViewHolder;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    AbsAdapter adapter;
    Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.lv);
        adapter = new AbsAdapter();
        adapter.addOnClickListener(R.layout.item_data_binding, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ViewHolder holder = AdapterUtil.getHolder(v);
                if (toast != null) {
                    toast.cancel();
                }
                toast = Toast.makeText(
                        MainActivity.this,
                        String.valueOf(holder.getCurrentPosition()),
                        Toast.LENGTH_LONG);
                toast.show();
            }
        });
        listView.setAdapter(adapter);
        loadItem2();
    }

    private void loadItem() {
        ArrayList<Item> list = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            list.add(new Item("item index is : " + i));
        }
        adapter.addAll(AdapterUtil.toItems(list));
    }

    private void loadItem2() {
        List<ItemDataBinding> list = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            list.add(new ItemDataBinding("item index is : " + i));
        }
        adapter.addAll(AdapterUtil.toItems(list));
    }
}
