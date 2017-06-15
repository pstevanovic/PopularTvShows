package com.funnystep.populartvshows.ui.utils;

import com.funnystep.populartvshows.R;
import com.funnystep.populartvshows.ui.model.PosterQuality;
import com.squareup.picasso.Picasso;

import android.app.Activity;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.widget.ImageView;

public class Utils {

    private static final String POSTER_PATH = "http://image.tmdb.org/t/p/%s%s";

    private Utils() {
    }

    public static int getScreenWidth(Activity activity) {
        DisplayMetrics displaymetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        return displaymetrics.widthPixels;
    }

    public static int getScreenHeight(Activity activity) {
        DisplayMetrics displaymetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        return displaymetrics.heightPixels;
    }

    public static void loadSmallPoster(String poster, ImageView view) {
        if (view == null) return;

        String posterPath = getPosterUrl(poster, PosterQuality.QUALITY_342);

        Picasso.with(view.getContext())
                .load(posterPath)
                .error(R.drawable.default_poster)
                .placeholder(R.drawable.default_poster)
                .into(view);
    }

    public static void loadMediumPoster(String poster, ImageView view) {
        if (view == null) return;

        String posterPath = getPosterUrl(poster, PosterQuality.QUALITY_500);

        Picasso.with(view.getContext()).load(posterPath).into(view);
    }

    public static String getPosterUrl(String poster, @PosterQuality String quality) {
        return !TextUtils.isEmpty(poster) ? String.format(POSTER_PATH, quality, poster) : null;
    }
}
