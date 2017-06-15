package com.funnystep.populartvshows.ui.tvshowdetail;

import com.funnystep.populartvshows.R;
import com.funnystep.populartvshows.ui.model.Converter;
import com.funnystep.populartvshows.ui.model.TvShowDetails;

import android.content.Context;
import android.support.v4.util.Pair;
import android.support.v4.view.PagerAdapter;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class TvShowsPageAdapter extends PagerAdapter {
    private static final String TAG = TvShowsPageAdapter.class.getSimpleName();

    private final Context mContext;
    private List<TvShowDetails> mData = new ArrayList<>();
    private Set<Integer> mObsoleteData = new HashSet<>();

    TvShowsPageAdapter(Context context) {
        mContext = context;
    }

    void setInitialData(TvShowDetails data) {
        mData.clear();
        mData.add(data);
        mObsoleteData.add(data.id);
        notifyDataSetChanged();
    }

    void addData(List<TvShowDetails> data) {
        mData.addAll(data);
        notifyDataSetChanged();
    }

    void updateData(TvShowDetails tvShow) {
        for (int i = 0; i < mData.size(); i++) {
            if (mData.get(i).id == tvShow.id) {
                mData.get(i).copyFrom(tvShow);
                mObsoleteData.add(tvShow.id);
                notifyDataSetChanged();
                break;
            }
        }
    }

    @Override
    public int getItemPosition(Object object) {
        Integer tag = (Integer) ((View) object).getTag();
        if (mObsoleteData.contains(tag)) {
            return POSITION_NONE;
        } else {
            return super.getItemPosition(object);
        }
    }

    TvShowDetails getDataAt(int position) {
        return mData.get(position);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        Log.d(TAG, "instantiateItem - pos:" + position);
        TvShowDetails tvShow = mData.get(position);

        LayoutInflater inflater = LayoutInflater.from(mContext);
        RecyclerView detailsList = (RecyclerView) inflater.inflate(R.layout.tvshow_data_layout, container, false);
        detailsList.setTag(tvShow.id);

        TvShowDetailsListAdapter detailsAdapter = new TvShowDetailsListAdapter();
        detailsList.setAdapter(detailsAdapter);

        List<Pair<String, String>> details = Converter.convertToNameValueList(tvShow, mContext);
        detailsAdapter.setData(details);
        mObsoleteData.remove(tvShow.id);

        container.addView(detailsList);
        return detailsList;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object view) {
        container.removeView((View) view);
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }
}
