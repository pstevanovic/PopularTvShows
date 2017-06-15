package com.funnystep.populartvshows.ui.model;

import com.funnystep.populartvshows.data.model.CreatedBy;
import com.funnystep.populartvshows.data.model.Genre;
import com.funnystep.populartvshows.data.model.Network;
import com.funnystep.populartvshows.data.model.ProductionCompany;
import com.funnystep.populartvshows.data.model.Season;

import java.util.ArrayList;
import java.util.List;

public class TvShowDetails {

    public int id;
    public String name;
    public String originalName;
    public String type;
    public String status;
    public int numberOfEpisodes;
    public int numberOfSeasons;
    public String overview;
    public double popularity;
    public String posterPath;
    public double voteAverage;
    public int voteCount;
    public String firstAirDate;
    public String backdropPath;
    public List<CreatedBy> createdBy = new ArrayList<>();
    public List<Integer> episodeRunTime = new ArrayList<>();
    public List<Genre> genres = new ArrayList<>();
    public String homepage;
    public boolean inProduction;
    public List<String> languages = new ArrayList<>();
    public String lastAirDate;
    public List<Network> networks = new ArrayList<Network>();
    public List<String> originCountry = new ArrayList<>();
    public String originalLanguage;
    public List<ProductionCompany> productionCompanies = new ArrayList<>();
    public List<Season> seasons = new ArrayList<>();
    public boolean fullyLoaded;

    public void copyFrom(TvShowDetails other) {
        id = other.id;
        name = other.name;
        originalName = other.originalName;
        type = other.type;
        status = other.status;
        numberOfEpisodes = other.numberOfEpisodes;
        numberOfSeasons = other.numberOfSeasons;
        overview = other.overview;
        popularity = other.popularity;
        posterPath = other.posterPath;
        voteAverage = other.voteAverage;
        voteCount = other.voteCount;
        firstAirDate = other.firstAirDate;
        backdropPath = other.backdropPath;
        createdBy = other.createdBy;
        episodeRunTime = other.episodeRunTime;
        genres = other.genres;
        homepage = other.homepage;
        inProduction = other.inProduction;
        languages = other.languages;
        lastAirDate = other.lastAirDate;
        networks = other.networks;
        originCountry = other.originCountry;
        originalLanguage = other.originalLanguage;
        productionCompanies = other.productionCompanies;
        seasons = other.seasons;
        fullyLoaded = other.fullyLoaded;
    }

    @Override
    public int hashCode() {
        int hash = 1;
        hash = 31 * hash + id;
        hash = 31 * hash + numberOfEpisodes;
        hash = 31 * hash + numberOfSeasons;
        hash = (int) (31 * hash + popularity);
        hash = (int) (31 * hash + voteAverage);
        hash = 31 * hash + voteCount;
        hash = 31 * hash + (name == null ? 0 : name.hashCode());
        hash = 31 * hash + (name == null ? 0 : name.hashCode());
        hash = 31 * hash + (originalName == null ? 0 : originalName.hashCode());
        hash = 31 * hash + (type == null ? 0 : type.hashCode());
        hash = 31 * hash + (status == null ? 0 : status.hashCode());
        hash = 31 * hash + (overview == null ? 0 : overview.hashCode());
        hash = 31 * hash + (posterPath == null ? 0 : posterPath.hashCode());
        hash = 31 * hash + (firstAirDate == null ? 0 : firstAirDate.hashCode());
        hash = 31 * hash + (backdropPath == null ? 0 : backdropPath.hashCode());
        hash = 31 * hash + (homepage == null ? 0 : homepage.hashCode());
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof TvShowDetails)) return false;
        TvShowDetails other = (TvShowDetails) obj;
        return id == other.id;
    }
}
