package com.example.ls.lsn5_materialdesign_wraprecylerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ls.lsn5_materialdesign_wraprecylerview.wraprecylerview.WrapRecylerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {
    private WrapRecylerView recylerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recylerView = (WrapRecylerView) findViewById(R.id.recylerview);
        TextView headerView = new TextView(this);
        //		TextView tv = headerView.findViewById(id);
        LayoutParams params = new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT);
        View view=LayoutInflater.from(this).inflate(R.layout.view,null);
        view.setLayoutParams(params);
        headerView.setLayoutParams(params);
        headerView.setText("我是第一个HeaderView");
        recylerView.addHeaderView(view);

        LayoutParams params4 = new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT);
        View view4=LayoutInflater.from(this).inflate(R.layout.view3,null);
        view.setLayoutParams(params4);
        headerView.setLayoutParams(params4);
        headerView.setText("我是HeaderView");
        recylerView.addHeaderView(view4);

        LayoutParams params3 = new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT);
        View view3=LayoutInflater.from(this).inflate(R.layout.view5,null);
        view.setLayoutParams(params3);
        headerView.setLayoutParams(params3);
        headerView.setText("我是HeaderView");
        recylerView.addHeaderView(view3);



        TextView footview = new TextView(this);
        LayoutParams paramss = new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT);
        View views=LayoutInflater.from(this).inflate(R.layout.view2,null);
        view.setLayoutParams(params);
        footview.setLayoutParams(paramss);
        footview.setText("尾布局");
        recylerView.addFooterView(views);
        LayoutParams params6 = new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT);
        View view6=LayoutInflater.from(this).inflate(R.layout.view5,null);
        view.setLayoutParams(params6);
        headerView.setLayoutParams(params6);
        headerView.setText("我是HeaderView");
        recylerView.addFooterView(view6);

        LayoutParams paramss11 = new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT);
        View view11=LayoutInflater.from(this).inflate(R.layout.view,null);
        view.setLayoutParams(paramss11);
        headerView.setLayoutParams(paramss11);
        headerView.setText("我是第一个HeaderView");
        recylerView.addFooterView(view11);
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            list.add("item " + i);
        }

        MyAdapter adapter = new MyAdapter(list,this);
        recylerView.setLayoutManager(new LinearLayoutManager(this));
        recylerView.setAdapter(adapter);
        adapter.setItemOnclickListenner(new MyAdapter.ItemOnclickListenner() {
            @Override
            public void ItemOnclick(View view,int position) {
                Toast.makeText(MainActivity2.this, "view="+position, Toast.LENGTH_SHORT).show();
            }
        });

    }
}
