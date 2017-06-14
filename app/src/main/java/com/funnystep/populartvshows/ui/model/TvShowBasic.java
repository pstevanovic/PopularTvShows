package com.funnystep.populartvshows.ui.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

public class TvShowBasic implements Parcelable {

    public String originalName;
    public int id;
    public String name;
    public int voteCount;
    public double voteAverage;
    public String posterPath;
    public String firstAirDate;
    public double popularity;
    public List<Integer> genreIds = new ArrayList<Integer>();
    public String originalLanguage;
    public String backdropPath;
    public String overview;
    public List<String> originCountry = new ArrayList<String>();

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.originalName);
        dest.writeInt(this.id);
        dest.writeString(this.name);
        dest.writeInt(this.voteCount);
        dest.writeDouble(this.voteAverage);
        dest.writeString(this.posterPath);
        dest.writeString(this.firstAirDate);
        dest.writeDouble(this.popularity);
        dest.writeList(this.genreIds);
        dest.writeString(this.originalLanguage);
        dest.writeString(this.backdropPath);
        dest.writeString(this.overview);
        dest.writeStringList(this.originCountry);
    }

    public TvShowBasic() {
    }

    protected TvShowBasic(Parcel in) {
        this.originalName = in.readString();
        this.id = in.readInt();
        this.name = in.readString();
        this.voteCount = in.readInt();
        this.voteAverage = in.readDouble();
        this.posterPath = in.readString();
        this.firstAirDate = in.readString();
        this.popularity = in.readDouble();
        this.genreIds = new ArrayList<Integer>();
        in.readList(this.genreIds, Integer.class.getClassLoader());
        this.originalLanguage = in.readString();
        this.backdropPath = in.readString();
        this.overview = in.readString();
        this.originCountry = in.createStringArrayList();
    }

    public static final Creator<TvShowBasic> CREATOR = new Creator<TvShowBasic>() {
        @Override
        public TvShowBasic createFromParcel(Parcel source) {
            return new TvShowBasic(source);
        }

        @Override
        public TvShowBasic[] newArray(int size) {
            return new TvShowBasic[size];
        }
    };
}
