package com.example.felix.movietest.data;

import android.util.Log;

import com.example.felix.movietest.data.db.DbMoviesManager;
import com.example.felix.movietest.data.db.MovieDTO;
import java.util.List;
import io.reactivex.Observable;


/**
 * Created by felix on 9/29/17.
 *
 * */

public class DbMoviesStore implements IMovieRepository {

    private static final String DB_STORE_TAG = "DB_MOVIES_STORE";
    private DbMoviesManager dbMoviesManager = new DbMoviesManager();

     @Override
     public Observable<List<MovieDTO>> getPopMovies() {
         Log.d(DB_STORE_TAG,"GET_POP_MOVIES");
         return Observable.just(dbMoviesManager.getMovies());
     }

    @Override
    public Observable<MovieDTO> getMovie(final long id) {
        return Observable.create(e -> dbMoviesManager.getMovie(id));
    }

    public void addMovies(List<MovieDTO> movieDTOs) {
        Log.d(DB_STORE_TAG,"inserting data");
        dbMoviesManager.addMovies(movieDTOs);
    }

    public void deleteMovies() {
        Log.d(DB_STORE_TAG,"delete movies");
        dbMoviesManager.deleteMovies();
    }
}
