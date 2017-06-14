package com.funnystep.populartvshows.ui.model;

import com.funnystep.populartvshows.data.model.Result;

public class Converter {

    private Converter() {
    }

    public static TvShowBasic convertResponseToBasic(Result result) {
        TvShowBasic tvShow = new TvShowBasic();
        if (result == null) return tvShow;

        tvShow.id = result.id;
        tvShow.name = result.name;
        tvShow.originalName = result.originalName;
        tvShow.posterPath = result.posterPath;
        tvShow.overview = result.overview;
        tvShow.firstAirDate = result.firstAirDate;
        tvShow.originalLanguage = result.originalLanguage;
        tvShow.originCountry = result.originCountry;
        tvShow.popularity = result.popularity;
        tvShow.voteAverage = result.voteAverage;
        tvShow.voteCount = result.voteCount;
        tvShow.genreIds = result.genreIds;
        tvShow.backdropPath = result.backdropPath;

        return tvShow;
    }

}
