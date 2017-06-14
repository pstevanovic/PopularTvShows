package com.funnystep.populartvshows.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import android.os.Parcel;
import android.os.Parcelable;

public class ProductionCompany implements Parcelable {

    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("id")
    @Expose
    public int id;

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(name);
        dest.writeValue(id);
    }

    public int describeContents() {
        return 0;
    }

    public final static Creator<ProductionCompany> CREATOR = new Creator<ProductionCompany>() {

        @SuppressWarnings({
                "unchecked"
        })
        public ProductionCompany createFromParcel(Parcel in) {
            ProductionCompany instance = new ProductionCompany();
            instance.name = ((String) in.readValue((String.class.getClassLoader())));
            instance.id = ((int) in.readValue((int.class.getClassLoader())));
            return instance;
        }

        public ProductionCompany[] newArray(int size) {
            return (new ProductionCompany[size]);
        }

    };
}
