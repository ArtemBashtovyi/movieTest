package com.example.felix.movietest.ui.details;

import com.example.felix.movietest.data.model.Movie;

/**
 * Created by felix on 10/17/17.
 *
 */


public interface IMovieDetailPresenter {

    void loadMovie(Movie movie);

    void addToBookmark();

    void deleteFromBookmark();


}
