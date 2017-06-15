package com.funnystep.populartvshows.ui.tvshowdetail;

import com.funnystep.populartvshows.data.model.Result;
import com.funnystep.populartvshows.data.model.TvShowDetailResponse;
import com.funnystep.populartvshows.data.model.TvShowSimilarResponse;
import com.funnystep.populartvshows.data.source.TvShowsDataSource;
import com.funnystep.populartvshows.ui.model.Converter;
import com.funnystep.populartvshows.ui.model.TvShowDetails;

import java.util.ArrayList;
import java.util.List;

class TvShowDetailPresenter
        implements TvShowDetailContract.Presenter,
        TvShowsDataSource.DetailsCallback {

    private static final int VISIBLE_THRESHOLD = 2;

    private final TvShowDetailContract.View mView;
    private final TvShowsDataSource mDataSource;
    private final int mTvShowId;
    private int mTotalLoaded = 0;
    private int mSimilarTvShowsLastPage = 0;
    private int mSimilarTvShowsTotalPages = 1;
    private boolean mLoading;

    TvShowDetailPresenter(TvShowDetailContract.View view, int tvShowId, TvShowsDataSource dataSource) {
        mView = view;
        mTvShowId = tvShowId;
        mDataSource = dataSource;
    }

    // TvShowDetailContract.Presenter implementation

    @Override
    public void start() {
        mDataSource.fetchTvShowDetails(this, mTvShowId);
    }

    @Override
    public void onTvShowDisplayed(TvShowDetails tvShow, int position) {
        if (!tvShow.fullyLoaded)
            mDataSource.fetchTvShowDetails(this, tvShow.id);

        if (!mLoading
                && mSimilarTvShowsLastPage < mSimilarTvShowsTotalPages
                && mTotalLoaded - position <= VISIBLE_THRESHOLD) {

            mLoading = true;
            mDataSource.fetchSimilarTvShows(this, mTvShowId, mSimilarTvShowsLastPage + 1);
        }
    }

    // TvShowsDataSource.PopularShowsCallback implementation

    @Override
    public void onTvShowDetailsFetched(TvShowDetailResponse response) {
        TvShowDetails tvShow = Converter.convertResponse(response);
        if (tvShow.id == mTvShowId) {
            mDataSource.fetchSimilarTvShows(this, mTvShowId, mSimilarTvShowsLastPage + 1);
            mView.updateSelectedTvShowData(tvShow);
        } else
            mView.updateTvShowData(tvShow);
    }

    @Override
    public void onSimilarTvShowsFetched(TvShowSimilarResponse response) {
        mSimilarTvShowsLastPage++;
        mSimilarTvShowsTotalPages = response.totalPages;
        mTotalLoaded = mTotalLoaded + response.results.size();

        List<TvShowDetails> similarTvShowsList = new ArrayList<>();

        for (Result result : response.results) {
            similarTvShowsList.add(Converter.convertResponseToDetails(result));
        }

        mLoading = false;

        mView.updateSimilarTvShowsData(similarTvShowsList);
    }

    @Override
    public void onDataFetchError(String message) {
        mView.showErrorMessage(message);
    }

}
