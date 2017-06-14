package com.funnystep.populartvshows.data.source;

import com.funnystep.populartvshows.data.model.TvShowDetailResponse;
import com.funnystep.populartvshows.data.model.TvShowSimilarResponse;
import com.funnystep.populartvshows.data.model.TvShowsResponse;

public interface TvShowsDataSource {

    void fetchPopularTvShows(final PopularShowsCallback callback, int page);

    void fetchTvShowDetails(final DetailsCallback callback, int showId);

    void fetchSimilarTvShows(final DetailsCallback callback, int showId, int page);

    /**
     * Callback interface
     */
    interface PopularShowsCallback {

        void onPopularTvShowsFetched(TvShowsResponse response);

        void onDataFetchError(String message);
    }

    interface DetailsCallback {

        void onTvShowDetailsFetched(TvShowDetailResponse response);

        void onSimilarTvShowsFetched(TvShowSimilarResponse response);

        void onDataFetchError(String message);

    }

}
