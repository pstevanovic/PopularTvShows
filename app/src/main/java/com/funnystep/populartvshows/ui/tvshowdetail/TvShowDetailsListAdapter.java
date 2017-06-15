package com.funnystep.populartvshows.ui.tvshowdetail;

import com.funnystep.populartvshows.R;

import android.support.v4.util.Pair;
import android.support.v7.widget.RecyclerView;
import android.text.util.Linkify;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

class TvShowDetailsListAdapter extends RecyclerView.Adapter<TvShowDetailsListAdapter.TvShowDetailViewHolder> {

    private List<Pair<String, String>> mData = new ArrayList<>();

    @Override
    public TvShowDetailViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.name_value_list_item, parent, false);
        return new TvShowDetailViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TvShowDetailViewHolder holder, int position) {
        Pair<String, String> data = mData.get(position);
        holder.mName.setText(data.first);
        holder.mValue.setText(data.second != null ? data.second : "");

        if (data.second != null
                && (data.second.startsWith("http://") || data.second.startsWith("https://"))) {
            Linkify.addLinks(holder.mValue, Linkify.WEB_URLS);
        }
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public void setData(List<Pair<String, String>> details) {
        mData.clear();
        mData.addAll(details);
        notifyDataSetChanged();
    }

    class TvShowDetailViewHolder extends RecyclerView.ViewHolder {
        TextView mName;
        TextView mValue;

        TvShowDetailViewHolder(View itemView) {
            super(itemView);

            mName = itemView.findViewById(R.id.name_value_name);
            mValue = itemView.findViewById(R.id.name_value_value);
        }

    }

}