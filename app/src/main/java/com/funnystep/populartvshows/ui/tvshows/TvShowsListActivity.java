package com.funnystep.populartvshows.ui.tvshows;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.funnystep.populartvshows.R;
import com.funnystep.populartvshows.data.source.TvShowsRemoteDataSource;
import com.funnystep.populartvshows.ui.model.TvShowBasic;
import com.funnystep.populartvshows.ui.tvshowdetail.TvShowDetailActivity;

import java.util.List;

public class TvShowsListActivity
        extends AppCompatActivity
        implements TvShowsContract.View, SwipeRefreshLayout.OnRefreshListener, TvShowsListAdapter.ListItemClickListener {
    private static final String TAG = TvShowsListActivity.class.getSimpleName();

    private TvShowsContract.Presenter mPresenter;

    private TvShowsListAdapter mAdapter;

    private View mMainView;
    private SwipeRefreshLayout mSwipeRefresh;
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tvshow_list);

        mMainView = findViewById(R.id.tvshow_list_main_view);

        mPresenter = new TvShowsListPresenter(this, TvShowsRemoteDataSource.get());
        mPresenter.start();

        mSwipeRefresh = (SwipeRefreshLayout) findViewById(R.id.tvshow_list_swiperefresh);
        mSwipeRefresh.setOnRefreshListener(this);

        mAdapter = new TvShowsListAdapter();
        mAdapter.setListInteractionListener(this);

        mRecyclerView = (RecyclerView) findViewById(R.id.tvshow_list);
        mRecyclerView.setAdapter(mAdapter);

        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                if (dy <= 0) return;

                int visibleItems = recyclerView.getChildCount();
                int totalItems = recyclerView.getLayoutManager().getItemCount();
                int firstVisibleItem = ((GridLayoutManager) recyclerView.getLayoutManager()).findFirstVisibleItemPosition();

                mPresenter.onListScrolled(visibleItems, totalItems, firstVisibleItem);
            }
        });
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        int position = ((GridLayoutManager) mRecyclerView.getLayoutManager()).findFirstVisibleItemPosition();
        int gridSize = newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE ? 3 : 2;

        mRecyclerView.setLayoutManager(new GridLayoutManager(this, gridSize));
        mRecyclerView.scrollToPosition(position);
    }

    // SwipeRefreshLayout.OnRefreshListener

    @Override
    public void onRefresh() {
        Log.d(TAG, "onRefresh - refresh list");
        mAdapter.clearData();
        mPresenter.fetchTvShows();
    }

    // TvShowsListAdapter.ListItemClickListener

    @Override
    public void onListItemClicked(int position) {
        TvShowBasic show = mAdapter.getTvShow(position);

        Intent intent = new Intent(this, TvShowDetailActivity.class);
        intent.putExtra(TvShowDetailActivity.TVSHOW_BASIC_DETAILS, show);

        startActivity(intent);
    }

    // TvShowsContract.View

    @Override
    public void updateData(List<TvShowBasic> data, boolean clearPrevious) {
        mSwipeRefresh.setRefreshing(false);
        if (clearPrevious)
            mAdapter.setData(data);
        else
            mAdapter.addData(data);
    }

    @Override
    public void showErrorMessage(String message) {
        Snackbar.make(mMainView, getString(R.string.error_message, message), Snackbar.LENGTH_LONG).show();
    }
}
