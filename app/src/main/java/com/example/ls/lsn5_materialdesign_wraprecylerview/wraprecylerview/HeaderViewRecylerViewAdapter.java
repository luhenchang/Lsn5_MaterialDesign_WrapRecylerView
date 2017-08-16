package com.example.ls.lsn5_materialdesign_wraprecylerview.wraprecylerview;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by ls on 2017/8/16.
 */

public class HeaderViewRecylerViewAdapter extends RecyclerView.Adapter {
    private ArrayList<View> mHeaderListArray;
    private ArrayList<View> mFooterListArray;
    private RecyclerView.Adapter mAdapter;
    private int position;
    public HeaderViewRecylerViewAdapter(ArrayList<View> mHeaderListArray, ArrayList<View> mFooterListArray, RecyclerView.Adapter mAdapter) {
        if (mHeaderListArray == null) {
            this.mHeaderListArray = new ArrayList<View>();
        } else {
            this.mHeaderListArray = mHeaderListArray;
        }
        if (mFooterListArray == null) {
            this.mFooterListArray = new ArrayList<View>();
        } else {
            this.mFooterListArray = mFooterListArray;
        }
        this.mAdapter = mAdapter;
    }

    @Override
    public int getItemViewType(int position) {

        // Header (negative positions will throw an IndexOutOfBoundsException)
        int numHeaders = getHeadersCount();
        int numFooters=getFootersCount();
        if (position < numHeaders) {
            this.position=position;
            return RecyclerView.INVALID_TYPE;
        }

        // Adapter
        final int adjPosition = position - numHeaders;
        int adapterCount = 0;
        if (mAdapter != null) {
            adapterCount = mAdapter.getItemCount();
            if (adjPosition < adapterCount) {
                this.position=adjPosition;
                return mAdapter.getItemViewType(adjPosition);
            }
        }
        this.position=position-numHeaders-adapterCount;
        // Footer (off-limits positions will throw an IndexOutOfBoundsException)
        return RecyclerView.INVALID_TYPE - 1;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == RecyclerView.INVALID_TYPE) {
            return new HeaderViewHolder(mHeaderListArray.get(position));
        } else if (viewType == (RecyclerView.INVALID_TYPE - 1)) {
            return new HeaderViewHolder(mFooterListArray.get(position));
        }
        return mAdapter.onCreateViewHolder(parent, viewType);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        int numHeaders = getHeadersCount();
        if (position < numHeaders) {
            return;
        }
        //adapter列表部分
        final int adjPosition = position - numHeaders;
        int adapterCount = 0;
        if (mAdapter != null) {
            adapterCount = mAdapter.getItemCount();
            if (adjPosition < adapterCount) {
                mAdapter.onBindViewHolder(holder, adjPosition);
                return;
            }
        }

        // Footer (off-limits positions will throw an IndexOutOfBoundsException)
    }

    @Override
    public int getItemCount() {
        if (mAdapter != null) {
            return getFootersCount() + getHeadersCount() + mAdapter.getItemCount();
        } else {
            return getFootersCount() + getHeadersCount();
        }
    }

    public int getHeadersCount() {
        return mHeaderListArray.size();
    }

    public int getFootersCount() {
        return mFooterListArray.size();
    }

    public static class HeaderViewHolder extends RecyclerView.ViewHolder {

        public HeaderViewHolder(View itemView) {
            super(itemView);
        }
    }
}
