
package com.funnystep.populartvshows.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

public class TvShowsResponse implements Parcelable {

    @SerializedName("page")
    @Expose
    public int page;
    @SerializedName("total_results")
    @Expose
    public int totalResults;
    @SerializedName("total_pages")
    @Expose
    public int totalPages;
    @SerializedName("results")
    @Expose
    public List<Result> results = new ArrayList<Result>();

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(page);
        dest.writeValue(totalResults);
        dest.writeValue(totalPages);
        dest.writeList(results);
    }

    public int describeContents() {
        return 0;
    }

    public final static Creator<TvShowsResponse> CREATOR = new Creator<TvShowsResponse>() {

        @SuppressWarnings({
                "unchecked"
        })
        public TvShowsResponse createFromParcel(Parcel in) {
            TvShowsResponse instance = new TvShowsResponse();
            instance.page = ((int) in.readValue((int.class.getClassLoader())));
            instance.totalResults = ((int) in.readValue((int.class.getClassLoader())));
            instance.totalPages = ((int) in.readValue((int.class.getClassLoader())));
            in.readList(instance.results, (Result.class.getClassLoader()));
            return instance;
        }

        public TvShowsResponse[] newArray(int size) {
            return (new TvShowsResponse[size]);
        }

    };
}
