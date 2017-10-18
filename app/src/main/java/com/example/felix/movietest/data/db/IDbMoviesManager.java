package com.example.felix.movietest.data.db;

import java.util.List;

/**
 * Created by felix on 9/26/17.
 *
 */

public interface IDbMoviesManager {

    void addMovies(List<MovieDTO> moviesDTO);
    MovieDTO getMovie(final Long id);
    void deleteMovies();

    void deleteMovie();

    List<MovieDTO> getMovies();

}
