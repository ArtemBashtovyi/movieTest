package com.example.felix.movietest.data.db;

import com.google.gson.annotations.SerializedName;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

/**
 * Created by felix on 9/26/17.
 *  Table
 */

@Entity
public class MovieDTO {

    @Id()
    private Long idDb;

    @SerializedName("id")
    private int movieId;

    @SerializedName("title")
    private String name;

    @SerializedName("poster_path")
    private String imageUrl;

    private double popularity;

    @SerializedName("vote_count")
    private double voteCount;

    @SerializedName("vote_average")
    private double voteAverage;


    public MovieDTO() {
    }


    @Generated(hash = 1553700009)
    public MovieDTO(Long idDb, int movieId, String name, String imageUrl,
            double popularity, double voteCount, double voteAverage) {
        this.idDb = idDb;
        this.movieId = movieId;
        this.name = name;
        this.imageUrl = imageUrl;
        this.popularity = popularity;
        this.voteCount = voteCount;
        this.voteAverage = voteAverage;
    }


    public Long getIdDb() {
        return this.idDb;
    }


    public void setIdDb(Long idDb) {
        this.idDb = idDb;
    }


    public int getMovieId() {
        return this.movieId;
    }


    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }


    public String getName() {
        return this.name;
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
        return this.popularity;
    }


    public void setPopularity(double popularity) {
        this.popularity = popularity;
    }


    public double getVoteCount() {
        return this.voteCount;
    }


    public void setVoteCount(double voteCount) {
        this.voteCount = voteCount;
    }


    public double getVoteAverage() {
        return this.voteAverage;
    }


    public void setVoteAverage(double voteAverage) {
        this.voteAverage = voteAverage;
    }


    
}
