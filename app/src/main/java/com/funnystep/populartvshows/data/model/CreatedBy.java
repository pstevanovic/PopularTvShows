package com.funnystep.populartvshows.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import android.os.Parcel;
import android.os.Parcelable;

public class CreatedBy implements Parcelable {

    @SerializedName("id")
    @Expose
    public int id;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("gender")
    @Expose
    public int gender;
    @SerializedName("profile_path")
    @Expose
    public String profilePath;

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(name);
        dest.writeValue(gender);
        dest.writeValue(profilePath);
    }

    public int describeContents() {
        return 0;
    }

    public final static Creator<CreatedBy> CREATOR = new Creator<CreatedBy>() {

        @SuppressWarnings({
                "unchecked"
        })
        public CreatedBy createFromParcel(Parcel in) {
            CreatedBy instance = new CreatedBy();
            instance.id = ((int) in.readValue((int.class.getClassLoader())));
            instance.name = ((String) in.readValue((String.class.getClassLoader())));
            instance.gender = ((int) in.readValue((int.class.getClassLoader())));
            instance.profilePath = ((String) in.readValue((String.class.getClassLoader())));
            return instance;
        }

        public CreatedBy[] newArray(int size) {
            return (new CreatedBy[size]);
        }

    };
}
