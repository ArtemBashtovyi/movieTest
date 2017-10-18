package com.example.felix.movietest.ui;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.felix.movietest.data.DataManager;
import com.example.felix.movietest.data.model.Movie;
import com.example.felix.movietest.data.model.MovieMapper;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by felix on 9/29/17.
 *
 */



@InjectViewState
public class MoviePresenter extends MvpPresenter<IMovieView> implements IMoviePresenter{


    private CompositeDisposable compositeDisposable = new CompositeDisposable();
    private DataManager dataManager = new DataManager();

    MoviePresenter() {

    }


    @Override
    public void loadPopularMovies() {

        // Stupid idea, because we are need DatabaseStore too, inside movieRep
        compositeDisposable.add(dataManager.getMovies()
                .flatMap(movieDTOs -> {
                    //use mapper
                    MovieMapper movieMapper = new MovieMapper();
                    return Observable.just(movieMapper.transformToMovies(movieDTOs));
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(movies -> getViewState().showMovies(movies),
                        throwable -> getViewState().showError(throwable.getMessage())));
    }

    @Override
    public void loadMovie(Movie movie) {
        getViewState().startMovieDetail(movie);
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        compositeDisposable.dispose();
    }


}
