package com.funnystep.populartvshows.ui.model;

import com.funnystep.populartvshows.R;
import com.funnystep.populartvshows.data.model.*;

import android.content.Context;
import android.support.v4.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class Converter {

    private static final String SEPARATOR = ", ";

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

    public static TvShowDetails convertResponse(TvShowDetailResponse response) {
        TvShowDetails tvShow = new TvShowDetails();
        if (response == null) return tvShow;

        tvShow.id = response.id;
        tvShow.name = response.name;
        tvShow.originalName = response.originalName;
        tvShow.type = response.type;
        tvShow.status = response.status;
        tvShow.numberOfEpisodes = response.numberOfEpisodes;
        tvShow.numberOfSeasons = response.numberOfSeasons;
        tvShow.overview = response.overview;
        tvShow.popularity = response.popularity;
        tvShow.posterPath = response.posterPath;
        tvShow.voteAverage = response.voteAverage;
        tvShow.voteCount = response.voteCount;
        tvShow.firstAirDate = response.firstAirDate;
        tvShow.backdropPath = response.backdropPath;
        tvShow.createdBy = response.createdBy;
        tvShow.episodeRunTime = response.episodeRunTime;
        tvShow.genres = response.genres;
        tvShow.homepage = response.homepage;
        tvShow.inProduction = response.inProduction;
        tvShow.languages = response.languages;
        tvShow.lastAirDate = response.lastAirDate;
        tvShow.networks = response.networks;
        tvShow.originCountry = response.originCountry;
        tvShow.originalLanguage = response.originalLanguage;
        tvShow.productionCompanies = response.productionCompanies;
        tvShow.seasons = response.seasons;
        tvShow.fullyLoaded = true;

        return tvShow;
    }

    public static TvShowDetails convertToDetail(TvShowBasic tvShowBasic) {
        TvShowDetails tvShowDetails = new TvShowDetails();
        if (tvShowBasic == null) return tvShowDetails;

        tvShowDetails.id = tvShowBasic.id;
        tvShowDetails.name = tvShowBasic.name;
        tvShowDetails.originalName = tvShowBasic.originalName;
        tvShowDetails.overview = tvShowBasic.overview;
        tvShowDetails.popularity = tvShowBasic.popularity;
        tvShowDetails.posterPath = tvShowBasic.posterPath;
        tvShowDetails.voteAverage = tvShowBasic.voteAverage;
        tvShowDetails.voteCount = tvShowBasic.voteCount;
        tvShowDetails.firstAirDate = tvShowBasic.firstAirDate;
        tvShowDetails.backdropPath = tvShowBasic.backdropPath;
        tvShowDetails.originCountry = tvShowBasic.originCountry;
        tvShowDetails.originalLanguage = tvShowBasic.originalLanguage;

        return tvShowDetails;
    }

    public static TvShowDetails convertResponseToDetails(Result result) {
        TvShowDetails tvShow = new TvShowDetails();
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
        tvShow.backdropPath = result.backdropPath;

        return tvShow;
    }

    public static List<Pair<String, String>> convertToNameValueList(TvShowDetails tvShow, Context context) {
        List<Pair<String, String>> details = new ArrayList<>();
        StringBuilder strBuilder = new StringBuilder();

        details.add(new Pair<>(context.getString(R.string.original_name), tvShow.originalName));

        strBuilder.setLength(0);
        if (tvShow.genres != null && !tvShow.genres.isEmpty()) {
            for (Genre genre : tvShow.genres)
                strBuilder.append(genre.name).append(SEPARATOR);
            strBuilder.setLength(strBuilder.length() - SEPARATOR.length());
        }
        details.add(new Pair<>(context.getString(R.string.genre), strBuilder.toString()));

        details.add(new Pair<>(context.getString(R.string.overview), tvShow.overview));
        details.add(new Pair<>(context.getString(R.string.popularity), String.valueOf((long) tvShow.popularity) + " %"));
        details.add(new Pair<>(context.getString(R.string.votes), String.valueOf(tvShow.voteAverage) + " / " + tvShow.voteCount));
        details.add(new Pair<>(context.getString(R.string.type), tvShow.type));
        details.add(new Pair<>(context.getString(R.string.status), tvShow.status));
        details.add(new Pair<>(context.getString(R.string.seasons_episodes),
                               (tvShow.seasons != null ? tvShow.seasons.size() : context.getString(R.string.unknown)) + " / " + tvShow.numberOfEpisodes));

        details.add(new Pair<>(context.getString(R.string.air_date), context.getString(R.string.air_date_first_last, tvShow.firstAirDate, tvShow.lastAirDate)));

        strBuilder.setLength(0);
        if (tvShow.createdBy != null && !tvShow.createdBy.isEmpty()) {
            for (CreatedBy createdBy : tvShow.createdBy)
                strBuilder.append(createdBy.name).append(SEPARATOR);
            strBuilder.setLength(strBuilder.length() - SEPARATOR.length());
        }
        details.add(new Pair<>(context.getString(R.string.created_by), strBuilder.toString()));

        strBuilder.setLength(0);
        if (tvShow.networks != null && !tvShow.networks.isEmpty()) {
            for (Network network : tvShow.networks)
                strBuilder.append(network.name).append(SEPARATOR);
            strBuilder.setLength(strBuilder.length() - SEPARATOR.length());
        }
        details.add(new Pair<>(context.getString(R.string.networks), strBuilder.toString()));

        strBuilder.setLength(0);
        if (tvShow.productionCompanies != null && !tvShow.productionCompanies.isEmpty()) {
            for (ProductionCompany company : tvShow.productionCompanies)
                strBuilder.append(company.name).append(SEPARATOR);
            strBuilder.setLength(strBuilder.length() - SEPARATOR.length());
        }
        details.add(new Pair<>(context.getString(R.string.production), strBuilder.toString()));

        details.add(new Pair<>(context.getString(R.string.original_language), tvShow.originalLanguage));

        strBuilder.setLength(0);
        if (tvShow.languages != null && !tvShow.languages.isEmpty()) {
            for (String language : tvShow.languages)
                strBuilder.append(language).append(SEPARATOR);
            strBuilder.setLength(strBuilder.length() - SEPARATOR.length());
        }
        details.add(new Pair<>(context.getString(R.string.languages), strBuilder.toString()));

        details.add(new Pair<>(context.getString(R.string.homepage), tvShow.homepage));

        return details;
    }

}
