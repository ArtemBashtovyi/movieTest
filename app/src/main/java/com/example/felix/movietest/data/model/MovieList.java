package com.example.felix.movietest.data.model;

import com.example.felix.movietest.data.db.MovieDTO;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by felix on 9/25/17.
 *
 */

public class MovieList {

    @SerializedName("results")
    private List<MovieDTO> movies;

    public List<MovieDTO> getMovies() {
        return movies;
    }

}
