package com.example.felix.movietest.data.api;

import com.example.felix.movietest.data.db.MovieDTO;
import com.example.felix.movietest.data.model.Movie;
import com.example.felix.movietest.data.model.MovieList;


import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 *  Created by felix on 9/25/17.
 * 
 */

public interface MovieService {

    @GET("movie/popular")
    Observable<MovieList> getPopularMovies();

    @GET("/movie/{movie_id}")
    Observable<MovieDTO> getMovie();

}
