
package com.funnystep.populartvshows.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

public class Result implements Parcelable {

    @SerializedName("original_name")
    @Expose
    public String originalName;
    @SerializedName("id")
    @Expose
    public int id;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("vote_count")
    @Expose
    public int voteCount;
    @SerializedName("vote_average")
    @Expose
    public double voteAverage;
    @SerializedName("poster_path")
    @Expose
    public String posterPath;
    @SerializedName("first_air_date")
    @Expose
    public String firstAirDate;
    @SerializedName("popularity")
    @Expose
    public double popularity;
    @SerializedName("genre_ids")
    @Expose
    public List<Integer> genreIds = new ArrayList<Integer>();
    @SerializedName("original_language")
    @Expose
    public String originalLanguage;
    @SerializedName("backdrop_path")
    @Expose
    public String backdropPath;
    @SerializedName("overview")
    @Expose
    public String overview;
    @SerializedName("origin_country")
    @Expose
    public List<String> originCountry = new ArrayList<String>();

    public final static Creator<Result> CREATOR = new Creator<Result>() {

        @SuppressWarnings({
                "unchecked"
        })
        public Result createFromParcel(Parcel in) {
            Result instance = new Result();
            instance.originalName = ((String) in.readValue((String.class.getClassLoader())));
            instance.id = ((int) in.readValue((int.class.getClassLoader())));
            instance.name = ((String) in.readValue((String.class.getClassLoader())));
            instance.voteCount = ((int) in.readValue((int.class.getClassLoader())));
            instance.voteAverage = ((double) in.readValue((double.class.getClassLoader())));
            instance.posterPath = ((String) in.readValue((String.class.getClassLoader())));
            instance.firstAirDate = ((String) in.readValue((String.class.getClassLoader())));
            instance.popularity = ((double) in.readValue((double.class.getClassLoader())));
            in.readList(instance.genreIds, (Integer.class.getClassLoader()));
            instance.originalLanguage = ((String) in.readValue((String.class.getClassLoader())));
            instance.backdropPath = ((String) in.readValue((String.class.getClassLoader())));
            instance.overview = ((String) in.readValue((String.class.getClassLoader())));
            in.readList(instance.originCountry, (String.class.getClassLoader()));
            return instance;
        }

        public Result[] newArray(int size) {
            return (new Result[size]);
        }

    };

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(originalName);
        dest.writeValue(id);
        dest.writeValue(name);
        dest.writeValue(voteCount);
        dest.writeValue(voteAverage);
        dest.writeValue(posterPath);
        dest.writeValue(firstAirDate);
        dest.writeValue(popularity);
        dest.writeList(genreIds);
        dest.writeValue(originalLanguage);
        dest.writeValue(backdropPath);
        dest.writeValue(overview);
        dest.writeList(originCountry);
    }

    public int describeContents() {
        return 0;
    }

}
