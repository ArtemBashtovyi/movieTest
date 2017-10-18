package com.example.felix.movietest.data;

import com.example.felix.movietest.data.api.ApiFactory;
import com.example.felix.movietest.data.db.MovieDTO;
import com.example.felix.movietest.data.model.MovieList;

import java.util.List;

import io.reactivex.Observable;


/**
 * Created by felix on 9/29/17.
 * Controller for api response
 */

public class ApiMoviesStore implements IMovieRepository{

    @Override
    public Observable<List<MovieDTO>> getPopMovies() {

        return ApiFactory.buildMovieService()
                .getPopularMovies()
                .doOnError(Throwable::printStackTrace)
                .map(MovieList::getMovies);
    }

    @Override
    public Observable<MovieDTO> getMovie(long id) {

        return ApiFactory.buildMovieService()
                .getMovie()
                .doOnError(Throwable::printStackTrace);
    }

}
