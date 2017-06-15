package com.funnystep.populartvshows.ui.tvshowdetail;

import com.funnystep.populartvshows.R;
import com.funnystep.populartvshows.data.source.TvShowsRemoteDataSource;
import com.funnystep.populartvshows.ui.custom.ImageTouchListener;
import com.funnystep.populartvshows.ui.model.Converter;
import com.funnystep.populartvshows.ui.model.PosterQuality;
import com.funnystep.populartvshows.ui.model.TvShowBasic;
import com.funnystep.populartvshows.ui.model.TvShowDetails;
import com.funnystep.populartvshows.ui.utils.Utils;
import com.squareup.picasso.Picasso;

import android.content.DialogInterface;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

public class TvShowDetailActivity
        extends AppCompatActivity
        implements TvShowDetailContract.View, ViewPager.OnPageChangeListener, View.OnClickListener {

    private static final String TAG = TvShowDetailActivity.class.getSimpleName();

    public static final String TVSHOW_BASIC_DETAILS = "tvshow_basic_details";

    private TvShowDetailContract.Presenter mPresenter;
    private TvShowsPageAdapter mAdapter;

    private View mMainView;
    private CollapsingToolbarLayout mToolbarLayout;
    private ImageView mPoster;
    private ImageView mFullScreenPosterView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tvshow_detail);

        mToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("");
        }

        setAppBarHeight();

        mMainView = findViewById(R.id.tvshow_detail_main_view);
        mPoster = (ImageView) findViewById(R.id.tvshow_detail_poster);
        ViewPager viewPager = (ViewPager) findViewById(R.id.tvshow_pager);

        mAdapter = new TvShowsPageAdapter(this);
        viewPager.setAdapter(mAdapter);
        viewPager.addOnPageChangeListener(this);

        mPoster.setOnClickListener(this);

        TvShowBasic tvShow = getIntent().getExtras().getParcelable(TVSHOW_BASIC_DETAILS);

        if (tvShow == null) {
            Log.e(TAG, "Unexpected case - no TV Show details passed to Detail Activity");
            finish();
        } else {
            mPresenter = new TvShowDetailPresenter(this, tvShow.id, TvShowsRemoteDataSource.get());
            mPresenter.start();

            TvShowDetails tvShowDetails = Converter.convertToDetail(tvShow);
            updateHeader(tvShowDetails);
            mAdapter.setInitialData(tvShowDetails);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        setAppBarHeight();

        if (mFullScreenPosterView != null) {
            Log.d(TAG, "onConfigurationChanged - imageView exists");
            mFullScreenPosterView.getLayoutParams().height = Utils.getScreenHeight(this);
            mFullScreenPosterView.getLayoutParams().width = Utils.getScreenWidth(this);
        }
    }

    // TvShowDetailContract.View implementation

    @Override
    public void updateSelectedTvShowData(TvShowDetails tvShow) {
        updateHeader(tvShow);
        mAdapter.setInitialData(tvShow);
    }

    @Override
    public void updateTvShowData(TvShowDetails tvShow) {
        mAdapter.updateData(tvShow);
    }

    @Override
    public void updateSimilarTvShowsData(List<TvShowDetails> similarTvShowslist) {
        Log.d(TAG, "updateSimilarTvShowsData - count:" + similarTvShowslist.size());
        mAdapter.addData(similarTvShowslist);
    }

    @Override
    public void showErrorMessage(String message) {
        Snackbar.make(mMainView, getString(R.string.error_message, message), Snackbar.LENGTH_LONG).show();
    }

    // ViewPager.OnPageChangeListener implementation

    @Override
    public void onPageSelected(int position) {
        TvShowDetails tvShow = mAdapter.getDataAt(position);
        Log.d(TAG, "onPageSelected - pos:" + position + " " + tvShow.name);

        updateHeader(tvShow);
        mPresenter.onTvShowDisplayed(tvShow, position);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        // not used
    }

    @Override
    public void onPageScrollStateChanged(int state) {
        // not used
    }

    // View.OnClickListener

    @Override
    public void onClick(View view) {
        if (view.getId() == mPoster.getId()) {
            final String url = Utils.getPosterUrl((String) mPoster.getTag(), PosterQuality.QUALITY_FULL);
            if (url != null) {
                final ViewGroup posterLayout = (ViewGroup) LayoutInflater.from(this).inflate(R.layout.poster_fullsize_layout, null);

                AlertDialog.Builder builder = new AlertDialog.Builder(this, android.R.style.Theme_Black_NoTitleBar_Fullscreen);
                builder.setView(posterLayout)
                       .setOnCancelListener(new DialogInterface.OnCancelListener() {
                           @Override
                           public void onCancel(DialogInterface dialogInterface) {
                               mFullScreenPosterView = null;
                           }
                       }).create().show();

                mFullScreenPosterView = posterLayout.findViewById(R.id.poster_fullsize_imageview);
                mFullScreenPosterView.setOnTouchListener(new ImageTouchListener());

                Picasso.with(this)
                       .load(url)
                       .error(mPoster.getDrawable())
                       .into(mFullScreenPosterView);
            }
        }
    }

    // private methods

    private void setAppBarHeight() {
        View appBar = findViewById(R.id.app_bar);
        if (appBar != null)
            appBar.getLayoutParams().height = Utils.getScreenHeight(this) / 2;
    }

    private void updateHeader(TvShowDetails tvShow) {
        mToolbarLayout.setTitle(tvShow.name);
        Utils.loadMediumPoster(tvShow.backdropPath, mPoster);
        mPoster.setTag(tvShow.posterPath);
    }

}
