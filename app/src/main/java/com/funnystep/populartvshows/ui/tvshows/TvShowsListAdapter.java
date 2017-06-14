package com.funnystep.populartvshows.ui.tvshows;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.funnystep.populartvshows.R;
import com.funnystep.populartvshows.ui.Utils;
import com.funnystep.populartvshows.ui.model.TvShowBasic;

import java.util.ArrayList;
import java.util.List;

class TvShowsListAdapter extends RecyclerView.Adapter<TvShowsListAdapter.TvShowListViewHolder> {

    private ListItemClickListener mItemClickListener;
    private final List<TvShowBasic> mData = new ArrayList<>();

    void setListInteractionListener(ListItemClickListener listener) {
        mItemClickListener = listener;
    }

    TvShowBasic getTvShow(int position) {
        return mData.get(position);
    }

    void clearData() {
        int end = mData.size();
        mData.clear();
        notifyItemRangeRemoved(0, end);
    }

    void setData(List<TvShowBasic> data) {
        mData.clear();
        mData.addAll(data);
        notifyDataSetChanged();
    }

    void addData(List<TvShowBasic> data) {
        mData.addAll(data);
        notifyItemRangeInserted(mData.size() - data.size(), mData.size());
    }

    @Override
    public TvShowListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.tvshow_grid_content, parent, false);
        return new TvShowListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final TvShowListViewHolder holder, int position) {
        TvShowBasic tvShow = mData.get(position);

        holder.mTitleView.setText(tvShow.name);
        holder.mRatingsView.setText(String.valueOf(tvShow.voteAverage));
        holder.setOnClickListener(mItemClickListener);

        Utils.loadSmallPoster(tvShow.backdropPath, holder.mPosterView);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    class TvShowListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        final ImageView mPosterView;
        final TextView mTitleView;
        final TextView mRatingsView;

        private ListItemClickListener mOnItemClickListener;

        TvShowListViewHolder(View view) {
            super(view);

            mPosterView = view.findViewById(R.id.tvshow_poster);
            mTitleView = view.findViewById(R.id.tvshow_title);
            mRatingsView = view.findViewById(R.id.tvshow_rate);

            view.setOnClickListener(this);
        }

        void setOnClickListener(ListItemClickListener itemClickListener) {
            mOnItemClickListener = itemClickListener;
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mTitleView.getText() + "'";
        }

        // View.OnClickListener implementation

        @Override
        public void onClick(View view) {
            if (mOnItemClickListener != null)
                mOnItemClickListener.onListItemClicked(getAdapterPosition());
        }
    }

    interface ListItemClickListener {
        void onListItemClicked(int position);
    }
}
