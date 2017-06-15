package com.funnystep.populartvshows.ui.tvshows;

import com.funnystep.populartvshows.ui.BasePresenter;
import com.funnystep.populartvshows.ui.BaseView;
import com.funnystep.populartvshows.ui.model.TvShowBasic;

import java.util.List;

interface TvShowsContract {

    interface View extends BaseView<Presenter> {

        /**
         * Refreshes UI with data for popular TV shows
         * @param data POJO data
         * @param clearPrevious clear previuos results
         */
        void updateData(List<TvShowBasic> data, boolean clearPrevious);

        /**
         * Shows error message
         * @param message string message
         */
        void showErrorMessage(String message);
    }

    interface Presenter extends BasePresenter {

        /**
         * Fetch Popular TV shows, page 1
         */
        void fetchTvShows();

        /**
         * Fetch next page of popular TV shows
         */
        void fetchAnotherPage();

        /**
         * List with data scrolled, this method will call fetchAnotherPage
         * if the scroll is near end of the current list
         * @param visibleItems visible items in list
         * @param totalItems total items in list
         * @param firstVisibleItem index of first visible item
         */
        void onListScrolled(int visibleItems, int totalItems, int firstVisibleItem);
    }

}
