package com.funnystep.populartvshows.ui.tvshowdetail;

import com.funnystep.populartvshows.ui.BasePresenter;
import com.funnystep.populartvshows.ui.BaseView;
import com.funnystep.populartvshows.ui.model.TvShowDetails;

import java.util.List;

interface TvShowDetailContract {

    interface View extends BaseView<Presenter> {

        void updateSelectedTvShowData(TvShowDetails tvShow);

        void updateTvShowData(TvShowDetails tvShow);

        void updateSimilarTvShowsData(List<TvShowDetails> similarTvShowslist);

        void showErrorMessage(String message);
    }

    interface Presenter extends BasePresenter {

        void onTvShowDisplayed(TvShowDetails tvShow, int position);
    }

}
