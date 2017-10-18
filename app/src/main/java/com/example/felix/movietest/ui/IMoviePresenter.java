package com.example.felix.movietest.ui;


import com.example.felix.movietest.data.model.Movie;

/**
 * Created by felix on 9/29/17.
 *
 */


interface IMoviePresenter {

    void loadPopularMovies();

    void loadMovie(Movie movie);

}
