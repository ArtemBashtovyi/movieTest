package com.example.felix.movietest.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;



/**
 * Created by felix on 9/25/17.
 *
 */


public class Movie implements Parcelable {

    @SerializedName("id")
    private int id;

    @SerializedName("title")
    private String name;

    private String imageUrl;

    private double popularity;

    @SerializedName("vote_count")
    private double voteCount;

    @SerializedName("vote_average")
    private double voteAverage;

    protected Movie(Parcel in) {
        name = in.readString();
        imageUrl = in.readString();
        popularity = in.readDouble();
        voteCount = in.readDouble();
        voteAverage = in.readDouble();
    }


    public Movie() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public double getPopularity() {
        return popularity;
    }

    public void setPopularity(double popularity) {
        this.popularity = popularity;
    }

    public double getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(double voteCount) {
        this.voteCount = voteCount;
    }

    public double getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(double voteAverage) {
        this.voteAverage = voteAverage;
    }

    public static final Creator<Movie> CREATOR = new Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel in) {
            return new Movie(in);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(imageUrl);
        parcel.writeDouble(popularity);
        parcel.writeDouble(voteCount);
        parcel.writeDouble(voteAverage);
    }
}
