package com.example.felix.movietest.ui;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.AddToEndStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;
import com.example.felix.movietest.data.model.Movie;

import java.util.List;

/**
 * Created by felix on 9/29/17.
 *
 */

public interface IMovieView extends MvpView {

    @StateStrategyType(AddToEndStrategy.class)
    void showMovies(List<Movie> movies);

    @StateStrategyType(AddToEndStrategy.class)
    void showError(String msg);

    @StateStrategyType(AddToEndStrategy.class)
    void startMovieDetail(Movie movie);
}
