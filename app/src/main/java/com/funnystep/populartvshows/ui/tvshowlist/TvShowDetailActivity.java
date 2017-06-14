package com.funnystep.populartvshows.ui.tvshowlist;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.funnystep.populartvshows.R;

public class TvShowDetailActivity extends AppCompatActivity {

    public static final String TVSHOW_BASIC_DETAILS = "tvshow_basic_details";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tv_show_detail);
    }
}
