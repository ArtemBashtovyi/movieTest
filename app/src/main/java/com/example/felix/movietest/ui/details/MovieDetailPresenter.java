package com.example.felix.movietest.ui.details;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.felix.movietest.data.DataManager;
import com.example.felix.movietest.data.model.Movie;
import com.example.felix.movietest.data.model.MovieMapper;
import com.example.felix.movietest.ui.IMovieView;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by felix on 10/17/17.
 *
 */

@InjectViewState
public class MovieDetailPresenter extends MvpPresenter<IMovieDetailsView> implements IMovieDetailPresenter {

    private CompositeDisposable compositeDisposable = new CompositeDisposable();
    private DataManager dataManager = new DataManager();


    @Override
    public void  loadMovie(Movie movie) {
        compositeDisposable.add(dataManager.getMovie(movie.getId())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .flatMap(movieDTO -> {
                    MovieMapper movieMapper = new MovieMapper();
                    return Observable.just(movieMapper.transformToMovie(movieDTO));
                })
                .subscribe(movie1 -> getViewState().showMovie(movie1)));
    }

    @Override
    public void addToBookmark() {

    }

    @Override
    public void deleteFromBookmark() {

    }


}
