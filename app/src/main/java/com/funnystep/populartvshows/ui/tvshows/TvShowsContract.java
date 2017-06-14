package com.funnystep.populartvshows.ui.tvshows;

import com.funnystep.populartvshows.ui.BasePresenter;
import com.funnystep.populartvshows.ui.BaseView;
import com.funnystep.populartvshows.ui.model.TvShowBasic;

import java.util.List;

interface TvShowsContract {

    interface View extends BaseView<Presenter> {

        void updateData(List<TvShowBasic> data, boolean clearPrevious);

        void showErrorMessage(String message);
    }

    interface Presenter extends BasePresenter {

        void fetchTvShows();

        void fetchAnotherPage();

        void onListScrolled(int visibleItems, int totalItems, int firstVisibleItem);
    }

}
