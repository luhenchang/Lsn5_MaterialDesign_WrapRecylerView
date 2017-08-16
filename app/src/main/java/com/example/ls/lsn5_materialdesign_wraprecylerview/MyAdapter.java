package com.example.ls.lsn5_materialdesign_wraprecylerview;

import java.util.List;

import android.content.ClipData;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MyAdapter extends Adapter<MyAdapter.ViewHolder> {
	private List<String> list;
    private Context context;
	private ItemOnclickListenner itemOnclickListenner;
    public MyAdapter(List<String> list, Context context) {
		// TODO Auto-generated constructor stub
		this.list = list;
		this.context=context;
	}
    public interface ItemOnclickListenner{
        void ItemOnclick(View view,int position);
    }

    public void setItemOnclickListenner(ItemOnclickListenner itemOnclickListenner) {
        this.itemOnclickListenner = itemOnclickListenner;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

		public TextView tv;
		public ViewHolder(View view) {
			super(view);
			// TODO Auto-generated constructor stub
			tv = (TextView) view.findViewById(R.id.tv);
		}
		
	}

	@Override
	public int getItemCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public void onBindViewHolder(ViewHolder holder, final int position) {
		holder.tv.setText(list.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemOnclickListenner.ItemOnclick(v,position);
            }
        });
	}

	@Override
	public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		LayoutInflater layoutInflater = LayoutInflater.from(context);
		View view = layoutInflater.inflate(R.layout.listitem,null);
		ViewHolder holder = new ViewHolder(view);
		return holder;
	}
}
