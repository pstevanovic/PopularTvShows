package com.funnystep.populartvshows.ui.tvshows;

import com.funnystep.populartvshows.Stubs;
import com.funnystep.populartvshows.data.model.TvShowsResponse;
import com.funnystep.populartvshows.data.source.TvShowsDataSource;
import com.funnystep.populartvshows.ui.model.TvShowBasic;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;

public class TvShowsListPresenterTest {

    @Mock
    private TvShowsContract.View mView;

    @Mock
    private TvShowsDataSource mDataSource;

    private TvShowsListPresenter mPresenter;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mPresenter = new TvShowsListPresenter(mView, mDataSource);
    }

    @After
    public void tearUp() {
        mPresenter = null;
    }

    @Test
    public void test_first_page_fetch_callback() {
        TvShowsResponse response = Stubs.getFirstPageResponse();

        mPresenter.onPopularTvShowsFetched(response);

        Mockito.verify(mView).updateData(new ArrayList<TvShowBasic>(), true);
    }

    @Test
    public void test_next_page_fetch_callback() {
        TvShowsResponse response = Stubs.getNextPageResponse();

        mPresenter.onPopularTvShowsFetched(response);

        Mockito.verify(mView).updateData(new ArrayList<TvShowBasic>(), false);
    }

    @Test
    public void test_fetch_error_callback() {
        String errorMsg = "Error msg";
        mPresenter.onDataFetchError(errorMsg);

        Mockito.verify(mView).showErrorMessage(errorMsg);
    }

    @Test
    public void test_first_page_fetch() {
        mPresenter.fetchTvShows();

        Mockito.verify(mDataSource).fetchPopularTvShows(mPresenter, 1);
    }

    @Test
    public void test_next_page_fetch() {
        mPresenter.fetchTvShows();
        mPresenter.onPopularTvShowsFetched(Stubs.getFirstPageResponse());
        mPresenter.fetchAnotherPage();

        Mockito.verify(mDataSource).fetchPopularTvShows(mPresenter, 2);
    }

    @Test
    public void test_paging_fetch() {
        mPresenter.fetchTvShows();
        mPresenter.onPopularTvShowsFetched(Stubs.getFirstPageResponse());

        mPresenter.onListScrolled(10, 20, 1);

        Mockito.verify(mDataSource, Mockito.never()).fetchPopularTvShows(mPresenter, 2);

        mPresenter.onListScrolled(10, 20, 10);

        Mockito.verify(mDataSource, Mockito.times(1)).fetchPopularTvShows(mPresenter, 2);
    }


}
