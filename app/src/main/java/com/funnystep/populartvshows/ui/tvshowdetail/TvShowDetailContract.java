package com.funnystep.populartvshows.ui.tvshowdetail;

import com.funnystep.populartvshows.ui.BasePresenter;
import com.funnystep.populartvshows.ui.BaseView;
import com.funnystep.populartvshows.ui.model.TvShowDetails;

import java.util.List;

interface TvShowDetailContract {

    interface View extends BaseView<Presenter> {

        /**
         * Refreshes UI with data for initially selected TV show
         * @param tvShow POJO data
         */
        void updateSelectedTvShowData(TvShowDetails tvShow);

        /**
         * Refreshes UI with data for TV show
         * @param tvShow POJO data
         */
        void updateTvShowData(TvShowDetails tvShow);

        /**
         * Refreshes UI with data for list with similar TV shows
         * @param similarTvShowslist list with POJO data
         */
        void updateSimilarTvShowsData(List<TvShowDetails> similarTvShowslist);

        /**
         * Shows error message
         * @param message string message
         */
        void showErrorMessage(String message);
    }

    interface Presenter extends BasePresenter {

        /**
         * Specific TV show is displayed on screen.
         * This method will fetch selected TV show details and similar TV shows if necessary
         * @param tvShow displayed tv show
         * @param position position in view pager
         */
        void onTvShowDisplayed(TvShowDetails tvShow, int position);
    }

}
