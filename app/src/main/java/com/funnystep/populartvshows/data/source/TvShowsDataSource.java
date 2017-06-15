package com.funnystep.populartvshows.data.source;

import com.funnystep.populartvshows.data.model.TvShowDetailResponse;
import com.funnystep.populartvshows.data.model.TvShowSimilarResponse;
import com.funnystep.populartvshows.data.model.TvShowsResponse;

public interface TvShowsDataSource {

    /**
     * Fetch popular TV shows and return data to callback
     * @param callback Callback interface
     * @param page Number of page to query
     */
    void fetchPopularTvShows(final PopularShowsCallback callback, int page);

    /**
     * Fetch TV show details and return data to callback
     * @param callback Callback interface
     * @param showId Show ID
     */
    void fetchTvShowDetails(final DetailsCallback callback, int showId);

    /**
     * Fetch similar TV shows for input show
     * @param callback Callback interface
     * @param showId Show ID
     * @param page Number of page to query
     */
    void fetchSimilarTvShows(final DetailsCallback callback, int showId, int page);

    /**
     * Callback interface for fetching popular TV show list
     */
    interface PopularShowsCallback {

        /**
         * Callback with data from server for fetching list of popular TV Shows
         * @param response POJO response from server
         */
        void onPopularTvShowsFetched(TvShowsResponse response);

        /**
         * Callback with error message
         * @param message Error message
         */
        void onDataFetchError(String message);
    }

    /**
     * Callback interface for TV show details and similar TV Shows
     */
    interface DetailsCallback {

        /**
         * Callback with data from server for fetching TV show details
         * @param response POJO response from server
         */
        void onTvShowDetailsFetched(TvShowDetailResponse response);

        /**
         * Callback with data from server for fetching similar TV shows
         * @param response POJO response from server
         */
        void onSimilarTvShowsFetched(TvShowSimilarResponse response);

        /**
         * Callback with error message
         * @param message Error message
         */
        void onDataFetchError(String message);

    }

}
