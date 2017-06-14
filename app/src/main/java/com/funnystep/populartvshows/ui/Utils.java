package com.funnystep.populartvshows.ui;

import android.text.TextUtils;
import android.widget.ImageView;

import com.funnystep.populartvshows.R;
import com.funnystep.populartvshows.ui.model.PosterQuality;
import com.squareup.picasso.Picasso;

public class Utils {

    private static final String POSTER_PATH = "http://image.tmdb.org/t/p/%s%s";

    private Utils() {
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

    private static String getPosterUrl(String poster, @PosterQuality String quality) {
        return !TextUtils.isEmpty(poster) ? String.format(POSTER_PATH, quality, poster) : null;
    }
}
