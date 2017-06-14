package com.funnystep.populartvshows.ui.model;

import android.support.annotation.StringDef;

import java.lang.annotation.Retention;

import static com.funnystep.populartvshows.ui.model.PosterQuality.QUALITY_092;
import static com.funnystep.populartvshows.ui.model.PosterQuality.QUALITY_154;
import static com.funnystep.populartvshows.ui.model.PosterQuality.QUALITY_185;
import static com.funnystep.populartvshows.ui.model.PosterQuality.QUALITY_342;
import static com.funnystep.populartvshows.ui.model.PosterQuality.QUALITY_500;
import static com.funnystep.populartvshows.ui.model.PosterQuality.QUALITY_780;
import static com.funnystep.populartvshows.ui.model.PosterQuality.QUALITY_FULL;
import static java.lang.annotation.RetentionPolicy.SOURCE;

@Retention(SOURCE)
@StringDef({QUALITY_092, QUALITY_154, QUALITY_185, QUALITY_342, QUALITY_500, QUALITY_780, QUALITY_FULL})
public @interface PosterQuality {

    // "w92", "w154", "w185", "w342", "w500", "w780", "original"

    String QUALITY_092 = "w92";
    String QUALITY_154 = "w154";
    String QUALITY_185 = "w185";
    String QUALITY_342 = "w342";
    String QUALITY_500 = "w500";
    String QUALITY_780 = "w780";
    String QUALITY_FULL = "original";

}
