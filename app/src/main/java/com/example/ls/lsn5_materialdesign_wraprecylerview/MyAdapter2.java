package com.example.ls.lsn5_materialdesign_wraprecylerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MyAdapter2 extends Adapter<MyAdapter2.ViewHolder> {
    private List<String> list;
    private Context context;

    public MyAdapter2(List<String> list, Context context) {
        // TODO Auto-generated constructor stub
        this.list = list;
        this.context = context;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        public TextView tv;

        public ViewHolder(View view, int viewType) {
            super(view);
            // TODO Auto-generated constructor stub
            if (viewType==RecyclerView.INVALID_TYPE) {
                imageView = (ImageView) view.findViewById(R.id.iv);
            } else {
                tv = (TextView) view.findViewById(R.id.tv);
            }
        }

    }

    @Override
    public int getItemCount() {
        // TODO Auto-generated method stub

        return list.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return RecyclerView.INVALID_TYPE;
        }
        return super.getItemViewType(position);

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if(holder.tv!=null) {
            holder.tv.setText(list.get(position));
        }else{


        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        if (viewType == RecyclerView.INVALID_TYPE) {
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            view = layoutInflater.inflate(R.layout.view2, null);
        } else {
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            view = layoutInflater.inflate(R.layout.listitem, null);

        }
        ViewHolder holder = new ViewHolder(view,viewType);
        return holder;
    }
}
