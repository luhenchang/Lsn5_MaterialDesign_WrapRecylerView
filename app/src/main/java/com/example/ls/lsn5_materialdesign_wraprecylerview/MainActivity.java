package com.example.ls.lsn5_materialdesign_wraprecylerview;

import android.support.v7.widget.LinearLayoutManager;
import android.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import android.view.ViewGroup.LayoutParams;
public class MainActivity extends AppCompatActivity {
    private RecyclerView recylerView;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
        recylerView = (RecyclerView) findViewById(R.id.recylerview2);
        /*TextView headerView = new TextView(this);
        //		TextView tv = headerView.findViewById(id);
        LayoutParams params = new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT);
        View view=LayoutInflater.from(this).inflate(R.layout.view,null);
        view.setLayoutParams(params);
        headerView.setLayoutParams(params);
        headerView.setText("我是HeaderView");
        recylerView.addHeaderView(view);


        TextView footview = new TextView(this);
        LayoutParams paramss = new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT);
        View views=LayoutInflater.from(this).inflate(R.layout.view2,null);
        view.setLayoutParams(params);
        footview.setLayoutParams(paramss);
        footview.setText("尾布局");
        recylerView.addFooterView(views);*/
        
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            list.add("item " + i);
        }

        MyAdapter2 adapter = new MyAdapter2(list,this);
        recylerView.setLayoutManager(new LinearLayoutManager(this));
        recylerView.setAdapter(adapter);

    }
}
