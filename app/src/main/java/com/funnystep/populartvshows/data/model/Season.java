package com.funnystep.populartvshows.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import android.os.Parcel;
import android.os.Parcelable;

public class Season implements Parcelable {

    @SerializedName("air_date")
    @Expose
    public String airDate;
    @SerializedName("episode_count")
    @Expose
    public int episodeCount;
    @SerializedName("id")
    @Expose
    public int id;
    @SerializedName("poster_path")
    @Expose
    public String posterPath;
    @SerializedName("season_number")
    @Expose
    public int seasonNumber;

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(airDate);
        dest.writeValue(episodeCount);
        dest.writeValue(id);
        dest.writeValue(posterPath);
        dest.writeValue(seasonNumber);
    }

    public int describeContents() {
        return 0;
    }

    public final static Creator<Season> CREATOR = new Creator<Season>() {

        @SuppressWarnings({
                "unchecked"
        })
        public Season createFromParcel(Parcel in) {
            Season instance = new Season();
            instance.airDate = ((String) in.readValue((String.class.getClassLoader())));
            instance.episodeCount = ((int) in.readValue((int.class.getClassLoader())));
            instance.id = ((int) in.readValue((int.class.getClassLoader())));
            instance.posterPath = ((String) in.readValue((String.class.getClassLoader())));
            instance.seasonNumber = ((int) in.readValue((int.class.getClassLoader())));
            return instance;
        }

        public Season[] newArray(int size) {
            return (new Season[size]);
        }

    };
}
