package com.funnystep.populartvshows.ui.tvshows;

import com.funnystep.populartvshows.data.model.Result;
import com.funnystep.populartvshows.data.model.TvShowsResponse;
import com.funnystep.populartvshows.data.source.TvShowsDataSource;
import com.funnystep.populartvshows.ui.model.Converter;
import com.funnystep.populartvshows.ui.model.TvShowBasic;

import java.util.ArrayList;
import java.util.List;

class TvShowsListPresenter
        implements TvShowsContract.Presenter,
        TvShowsDataSource.PopularShowsCallback {
    private static final String TAG = TvShowsListPresenter.class.getSimpleName();

    private static final int VISIBLE_THRESHOLD = 5;

    private final TvShowsContract.View mView;
    private final TvShowsDataSource mDataSource;
    private int mLastPageLoaded = 0;
    private int mTotalPages = 0;
    private boolean mLoading = false;

    TvShowsListPresenter(TvShowsContract.View view, TvShowsDataSource dataSource) {
        mView = view;
        mDataSource = dataSource;
    }

    // TvShowsContract.Presenter implementation

    @Override
    public void start() {
        fetchTvShows();
    }

    @Override
    public void fetchTvShows() {
        mLastPageLoaded = 0;
        mLoading = true;
        mDataSource.fetchPopularTvShows(this, mLastPageLoaded + 1);
    }

    @Override
    public void fetchAnotherPage() {
        if (mLastPageLoaded < mTotalPages) {
            mLoading = true;
            mDataSource.fetchPopularTvShows(this, mLastPageLoaded + 1);
        }
    }

    @Override
    public void onListScrolled(int visibleItems, int totalItems, int firstVisibleItem) {
        if (!mLoading && (totalItems - visibleItems) <= (firstVisibleItem + VISIBLE_THRESHOLD)) {
            fetchAnotherPage();
        }
    }

    // TvShowsDataSource.PopularShowsCallback implementation

    @Override
    public void onPopularTvShowsFetched(TvShowsResponse response) {
        mLastPageLoaded = response.page;
        mTotalPages = response.totalPages;

        List<TvShowBasic> fetchedShows = new ArrayList<>();
        for (Result result : response.results) {
            fetchedShows.add(Converter.convertResponseToBasic(result));
        }

        mView.updateData(fetchedShows, mLastPageLoaded == 1);
        mLoading = false;
    }

    @Override
    public void onDataFetchError(String message) {
        mView.showErrorMessage(message);
    }

}
