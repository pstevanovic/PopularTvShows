package com.funnystep.populartvshows.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

public class TvShowDetailResponse implements Parcelable {

    @SerializedName("backdrop_path")
    @Expose
    public String backdropPath;
    @SerializedName("created_by")
    @Expose
    public List<CreatedBy> createdBy = new ArrayList<>();
    @SerializedName("episode_run_time")
    @Expose
    public List<Integer> episodeRunTime = new ArrayList<>();
    @SerializedName("first_air_date")
    @Expose
    public String firstAirDate;
    @SerializedName("genres")
    @Expose
    public List<Genre> genres = new ArrayList<>();
    @SerializedName("homepage")
    @Expose
    public String homepage;
    @SerializedName("id")
    @Expose
    public int id;
    @SerializedName("in_production")
    @Expose
    public boolean inProduction;
    @SerializedName("languages")
    @Expose
    public List<String> languages = new ArrayList<>();
    @SerializedName("last_air_date")
    @Expose
    public String lastAirDate;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("networks")
    @Expose
    public List<Network> networks = new ArrayList<Network>();
    @SerializedName("number_of_episodes")
    @Expose
    public int numberOfEpisodes;
    @SerializedName("number_of_seasons")
    @Expose
    public int numberOfSeasons;
    @SerializedName("origin_country")
    @Expose
    public List<String> originCountry = new ArrayList<>();
    @SerializedName("original_language")
    @Expose
    public String originalLanguage;
    @SerializedName("original_name")
    @Expose
    public String originalName;
    @SerializedName("overview")
    @Expose
    public String overview;
    @SerializedName("popularity")
    @Expose
    public double popularity;
    @SerializedName("poster_path")
    @Expose
    public String posterPath;
    @SerializedName("production_companies")
    @Expose
    public List<ProductionCompany> productionCompanies = new ArrayList<>();
    @SerializedName("seasons")
    @Expose
    public List<Season> seasons = new ArrayList<>();
    @SerializedName("status")
    @Expose
    public String status;
    @SerializedName("type")
    @Expose
    public String type;
    @SerializedName("vote_average")
    @Expose
    public double voteAverage;
    @SerializedName("vote_count")
    @Expose
    public int voteCount;

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(backdropPath);
        dest.writeList(createdBy);
        dest.writeList(episodeRunTime);
        dest.writeValue(firstAirDate);
        dest.writeList(genres);
        dest.writeValue(homepage);
        dest.writeValue(id);
        dest.writeValue(inProduction);
        dest.writeList(languages);
        dest.writeValue(lastAirDate);
        dest.writeValue(name);
        dest.writeList(networks);
        dest.writeValue(numberOfEpisodes);
        dest.writeValue(numberOfSeasons);
        dest.writeList(originCountry);
        dest.writeValue(originalLanguage);
        dest.writeValue(originalName);
        dest.writeValue(overview);
        dest.writeValue(popularity);
        dest.writeValue(posterPath);
        dest.writeList(productionCompanies);
        dest.writeList(seasons);
        dest.writeValue(status);
        dest.writeValue(type);
        dest.writeValue(voteAverage);
        dest.writeValue(voteCount);
    }

    public int describeContents() {
        return 0;
    }

    public final static Creator<TvShowDetailResponse> CREATOR = new Creator<TvShowDetailResponse>() {

        @SuppressWarnings({
                "unchecked"
        })
        public TvShowDetailResponse createFromParcel(Parcel in) {
            TvShowDetailResponse instance = new TvShowDetailResponse();
            instance.backdropPath = ((String) in.readValue((String.class.getClassLoader())));
            in.readList(instance.createdBy, (CreatedBy.class.getClassLoader()));
            in.readList(instance.episodeRunTime, (Integer.class.getClassLoader()));
            instance.firstAirDate = ((String) in.readValue((String.class.getClassLoader())));
            in.readList(instance.genres, (Genre.class.getClassLoader()));
            instance.homepage = ((String) in.readValue((String.class.getClassLoader())));
            instance.id = ((int) in.readValue((int.class.getClassLoader())));
            instance.inProduction = ((boolean) in.readValue((boolean.class.getClassLoader())));
            in.readList(instance.languages, (String.class.getClassLoader()));
            instance.lastAirDate = ((String) in.readValue((String.class.getClassLoader())));
            instance.name = ((String) in.readValue((String.class.getClassLoader())));
            in.readList(instance.networks, (Network.class.getClassLoader()));
            instance.numberOfEpisodes = ((int) in.readValue((int.class.getClassLoader())));
            instance.numberOfSeasons = ((int) in.readValue((int.class.getClassLoader())));
            in.readList(instance.originCountry, (String.class.getClassLoader()));
            instance.originalLanguage = ((String) in.readValue((String.class.getClassLoader())));
            instance.originalName = ((String) in.readValue((String.class.getClassLoader())));
            instance.overview = ((String) in.readValue((String.class.getClassLoader())));
            instance.popularity = ((double) in.readValue((double.class.getClassLoader())));
            instance.posterPath = ((String) in.readValue((String.class.getClassLoader())));
            in.readList(instance.productionCompanies, (ProductionCompany.class.getClassLoader()));
            in.readList(instance.seasons, (Season.class.getClassLoader()));
            instance.status = ((String) in.readValue((String.class.getClassLoader())));
            instance.type = ((String) in.readValue((String.class.getClassLoader())));
            instance.voteAverage = ((int) in.readValue((int.class.getClassLoader())));
            instance.voteCount = ((int) in.readValue((int.class.getClassLoader())));
            return instance;
        }

        public TvShowDetailResponse[] newArray(int size) {
            return (new TvShowDetailResponse[size]);
        }

    };

}
