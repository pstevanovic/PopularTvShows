package com.funnystep.populartvshows.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

public class TvShowSimilarResponse implements Parcelable {

    @SerializedName("page")
    @Expose
    public int page;
    @SerializedName("results")
    @Expose
    public List<Result> results = new ArrayList<>();
    @SerializedName("total_pages")
    @Expose
    public int totalPages;
    @SerializedName("total_results")
    @Expose
    public int totalResults;

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(page);
        dest.writeList(results);
        dest.writeValue(totalPages);
        dest.writeValue(totalResults);
    }

    public int describeContents() {
        return 0;
    }

    public final static Creator<TvShowSimilarResponse> CREATOR = new Creator<TvShowSimilarResponse>() {

        @SuppressWarnings({
                "unchecked"
        })
        public TvShowSimilarResponse createFromParcel(Parcel in) {
            TvShowSimilarResponse instance = new TvShowSimilarResponse();
            instance.page = ((int) in.readValue((int.class.getClassLoader())));
            in.readList(instance.results, (Result.class.getClassLoader()));
            instance.totalPages = ((int) in.readValue((int.class.getClassLoader())));
            instance.totalResults = ((int) in.readValue((int.class.getClassLoader())));
            return instance;
        }

        public TvShowSimilarResponse[] newArray(int size) {
            return (new TvShowSimilarResponse[size]);
        }

    };
}
