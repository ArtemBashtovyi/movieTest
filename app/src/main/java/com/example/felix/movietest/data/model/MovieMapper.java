package com.example.felix.movietest.data.model;

import com.example.felix.movietest.data.db.MovieDTO;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.annotations.NonNull;

/**
 * Created by felix on 9/27/17.
 *
 */

public class MovieMapper  {

    public Movie transformToMovie(@NonNull MovieDTO movieDTO) {
        Movie movie = new Movie();
        if (movieDTO != null) {
            movie.setId(movieDTO.getMovieId());
            movie.setName(movieDTO.getName());
            movie.setImageUrl(movieDTO.getImageUrl());
            movie.setVoteCount(movieDTO.getVoteCount());
            movie.setPopularity(movieDTO.getPopularity());
            movie.setVoteAverage(movieDTO.getVoteAverage());
        }

        return movie;
    }

    public List<Movie> transformToMovies(List<MovieDTO> moviesDTO) {
        List<Movie> movies = new ArrayList<>();

        for (MovieDTO movieDTO : moviesDTO) {
            Movie movie = transformToMovie(movieDTO);
            if (movie != null) {
                movies.add(movie);
            }
        }

        return movies;
    }

    public MovieDTO transformToMovieDTO(@NonNull Movie movie) {
        MovieDTO movieDTO = new MovieDTO();
        if (movie != null) {
            movieDTO.setMovieId(movie.getId());
            movieDTO.setName(movie.getName());
            movieDTO.setImageUrl(movie.getImageUrl());
            movieDTO.setVoteCount(movie.getVoteCount());
            movieDTO.setPopularity(movie.getPopularity());
            movieDTO.setVoteAverage(movie.getVoteAverage());
        }

        return movieDTO;
    }

    public List<MovieDTO> transformToMoviesDTO(List<Movie> movies) {
        List<MovieDTO> moviesDTO = new ArrayList<>();

        for (Movie movie : movies) {
            MovieDTO movieDTO = transformToMovieDTO(movie);
            if (movie != null) {
                moviesDTO.add(movieDTO);
            }
        }
        return moviesDTO;
    }
}
