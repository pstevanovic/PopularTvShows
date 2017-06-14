package com.funnystep.populartvshows.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import android.os.Parcel;
import android.os.Parcelable;

public class Genre implements Parcelable {

    @SerializedName("id")
    @Expose
    public int id;
    @SerializedName("name")
    @Expose
    public String name;

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(name);
    }

    public int describeContents() {
        return 0;
    }

    public final static Creator<Genre> CREATOR = new Creator<Genre>() {

        @SuppressWarnings({
                "unchecked"
        })
        public Genre createFromParcel(Parcel in) {
            Genre instance = new Genre();
            instance.id = ((int) in.readValue((int.class.getClassLoader())));
            instance.name = ((String) in.readValue((String.class.getClassLoader())));
            return instance;
        }

        public Genre[] newArray(int size) {
            return (new Genre[size]);
        }

    };
}
