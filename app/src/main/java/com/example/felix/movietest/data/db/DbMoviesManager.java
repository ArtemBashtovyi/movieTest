package com.example.felix.movietest.data.db;

import android.util.Log;

import com.example.felix.movietest.App;

import java.util.List;

/**
 * Created by felix on 9/26/17.
 * controller DB
 */

public class DbMoviesManager implements IDbMoviesManager {

    private static final String DB_TAG = "DB_MANAGER" ;
    private MovieDTODao movieDao;

    public DbMoviesManager() {
        Log.d(DB_TAG,"Create");
        DaoSession daoSession = App.getNewSession();
        movieDao = daoSession.getMovieDTODao();
    }

    @Override
    public void addMovies(List<MovieDTO> movieDTOs) {
        Log.d(DB_TAG,"INSERTING_TO_DB");
        movieDao.insertInTx(movieDTOs);
    }


    @Override
    public MovieDTO getMovie(final Long id) {
        return movieDao
                .queryBuilder()
                .where(MovieDTODao.Properties.MovieId.eq(id))
                .unique();
    }

    @Override
    public void deleteMovies() {
        movieDao.queryBuilder().buildDelete().executeDeleteWithoutDetachingEntities();
    }

    @Override
    public void deleteMovie() {
        // TODO : IMPL s
    }

    @Override
    public List<MovieDTO> getMovies() {
        Log.d(DB_TAG,"Query to load all movies");
        List<MovieDTO> movieDTOs = movieDao.loadAll();

        for (MovieDTO movieDTO : movieDTOs) {
            Log.d(DB_TAG,"image : " + movieDTO.getImageUrl() + "name" + movieDTO.getName());

        }
        return movieDTOs;
    }


}
