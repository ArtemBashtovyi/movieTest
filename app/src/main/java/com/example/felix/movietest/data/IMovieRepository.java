package com.example.felix.movietest.data;

import com.example.felix.movietest.data.db.MovieDTO;

import java.util.List;

import io.reactivex.Observable;


/**
 * Created by felix on 9/29/17.
 *
 */

public interface IMovieRepository {

    Observable<List<MovieDTO>> getPopMovies();

    Observable<MovieDTO> getMovie(long id);

}
