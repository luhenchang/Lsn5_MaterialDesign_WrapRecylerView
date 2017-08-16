package com.example.ls.lsn5_materialdesign_wraprecylerview.wraprecylerview;


import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;

/**
 * Created by ls on 2017/8/16.
 */

public class WrapRecylerView extends RecyclerView {
    private ArrayList<View> mHeaderListArray = new ArrayList<View>();
    private ArrayList<View> mFooterListArray = new ArrayList<View>();
    private Adapter mAdapter;
    public WrapRecylerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public void addHeaderView(View v) {
        mHeaderListArray.add(v);
        if (mAdapter != null) {
            if (!(mAdapter instanceof HeaderViewRecylerViewAdapter)) {
                mAdapter=new HeaderViewRecylerViewAdapter(mHeaderListArray, mFooterListArray, mAdapter);
            }
        }
    }

    public void addFooterView(View v) {
        mFooterListArray.add(v);
        // Wrap the adapter if it wasn't already wrapped.
        if (mAdapter != null) {
            if (!(mAdapter instanceof HeaderViewRecylerViewAdapter)) {
               mAdapter= new HeaderViewRecylerViewAdapter(mHeaderListArray, mFooterListArray, mAdapter);

            }
        }
    }

    @Override
    public void setAdapter(Adapter adapter) {
        if (mHeaderListArray.size() > 0 || mFooterListArray.size() > 0) {
            mAdapter = new HeaderViewRecylerViewAdapter(mHeaderListArray, mFooterListArray, adapter);
        } else {
            mAdapter = adapter;
        }
        super.setAdapter(mAdapter);
    }
}
