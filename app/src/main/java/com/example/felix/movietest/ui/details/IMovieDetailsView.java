package com.example.felix.movietest.ui.details;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;
import com.example.felix.movietest.data.model.Movie;

/**
 * Created by felix on 9/30/17.
 *
 */

public interface IMovieDetailsView extends MvpView{

    @StateStrategyType(AddToEndStrategy.class)
    void showMovie(Movie movie);

    @StateStrategyType(AddToEndStrategy.class)
    void showAddedBookmark();

    @StateStrategyType(AddToEndStrategy.class)
    void showDeletedBookmark();
}
