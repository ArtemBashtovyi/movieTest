package com.example.felix.movietest.data;

import android.util.Log;

import com.example.felix.movietest.data.db.MovieDTO;
import java.util.List;
import io.reactivex.Observable;

/**
 * Created by felix on 9/30/17.
 *
 */

public class DataManager {

    private static final String DATA_MANAGER_TAG = "DATA_MANAGER" ;
    private DbMoviesStore dbStore;

    public DataManager() {
        dbStore =  new DbMoviesStore();
    }

    public Observable<List<MovieDTO>> getMovies() {

        ApiMoviesStore apiStore = new ApiMoviesStore();

        // TODO : запис в БД даних, потім діставання з БД
        return apiStore.getPopMovies()
                .flatMap(movieDTOs -> {
                    Log.d(DATA_MANAGER_TAG,"INSERT data");
                    dbStore.deleteMovies();
                    dbStore.addMovies(movieDTOs);
                    return Observable.just(movieDTOs);
                })
                .onErrorResumeNext(throwable -> {
                    Log.d(DATA_MANAGER_TAG,"ERROR READ API OR INSERT");
                    return dbStore.getPopMovies();
                });
    }

    public Observable<MovieDTO> getMovie(long id) {
        return dbStore.getMovie(id);
    }
}
