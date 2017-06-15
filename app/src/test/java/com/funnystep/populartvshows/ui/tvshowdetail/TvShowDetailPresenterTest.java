package com.funnystep.populartvshows.ui.tvshowdetail;

import com.funnystep.populartvshows.data.model.TvShowDetailResponse;
import com.funnystep.populartvshows.data.model.TvShowSimilarResponse;
import com.funnystep.populartvshows.data.source.TvShowsDataSource;
import com.funnystep.populartvshows.ui.model.Converter;
import com.funnystep.populartvshows.ui.model.TvShowDetails;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;

public class TvShowDetailPresenterTest {

    private static final int SHOW_ID = 1;

    @Mock
    private TvShowDetailContract.View mView;

    @Mock
    private TvShowsDataSource mDataSource;

    private TvShowDetailPresenter mPresenter;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mPresenter = new TvShowDetailPresenter(mView, SHOW_ID, mDataSource);
    }

    @After
    public void tearUp() {
        mPresenter = null;
    }

    @Test
    public void test_initial_tv_show_details_fetch_callback() {
        TvShowDetailResponse response = new TvShowDetailResponse();
        response.id = SHOW_ID;

        mPresenter.onTvShowDetailsFetched(response);

        // verify that similar TV shows fetch called
        Mockito.verify(mDataSource).fetchSimilarTvShows(mPresenter, SHOW_ID, 1);

        // verify view data update
        Mockito.verify(mView).updateSelectedTvShowData(Converter.convertResponse(response));
    }

    @Test
    public void test_similar_tv_show_details_fetch_callback() {
        TvShowDetailResponse response = new TvShowDetailResponse();
        response.id = SHOW_ID + 10; // some other id

        mPresenter.onTvShowDetailsFetched(response);

        Mockito.verify(mDataSource, Mockito.never()).fetchSimilarTvShows(mPresenter, SHOW_ID, response.id);
        Mockito.verify(mView).updateTvShowData(Converter.convertResponse(response));
    }

    @Test
    public void test_similar_tv_shows_fetch_callback() {
        TvShowSimilarResponse response = new TvShowSimilarResponse();
        response.page = 1;
        response.totalPages = 10;
        response.totalResults = 190;

        mPresenter.onSimilarTvShowsFetched(response);

        Mockito.verify(mView).updateSimilarTvShowsData(new ArrayList<TvShowDetails>());
    }

    @Test
    public void test_fetch_error_callback() {
        String errorMsg = "Error msg";
        mPresenter.onDataFetchError(errorMsg);

        Mockito.verify(mView).showErrorMessage(errorMsg);
    }

    @Test
    public void test_presenter_start() {
        mPresenter.start();

        Mockito.verify(mDataSource).fetchTvShowDetails(mPresenter, SHOW_ID);
    }

    @Test
    public void test_show_details_fetch() {
        TvShowDetails tvShow = new TvShowDetails();
        tvShow.id = SHOW_ID + 100;
        tvShow.fullyLoaded = false;

        mPresenter.onTvShowDisplayed(tvShow, 100);

        Mockito.verify(mDataSource).fetchTvShowDetails(mPresenter, tvShow.id);
    }

    @Test
    public void test_show_details_already_fetch() {
        TvShowDetails tvShow = new TvShowDetails();
        tvShow.id = SHOW_ID + 100;
        tvShow.fullyLoaded = true; // already loaded

        mPresenter.onTvShowDisplayed(tvShow, 100);

        Mockito.verify(mDataSource, Mockito.never()).fetchTvShowDetails(mPresenter, tvShow.id);
    }

    @Test
    public void test_paging_fetch() {
        TvShowDetails tvShow = new TvShowDetails();
        tvShow.id = SHOW_ID + 100;
        tvShow.fullyLoaded = false;

        mPresenter.onTvShowDisplayed(tvShow, 1);

        Mockito.verify(mDataSource).fetchSimilarTvShows(mPresenter, SHOW_ID, 1);
    }

}
