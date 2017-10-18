package com.example.felix.movietest.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.felix.movietest.R;
import com.example.felix.movietest.data.model.Movie;
import com.example.felix.movietest.ui.details.MovieDetailActivity;
import com.example.felix.movietest.ui.movies.adapter.PopularMoviesAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MovieActivity extends MvpAppCompatActivity implements IMovieView,
        PopularMoviesAdapter.OnItemClickListener {


    private static final String TAG_VERBOSE = "onClicked" ;

    private static final String ERROR_TAG = "Server error" ;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.movies_recycler_view)
    RecyclerView moviesRecyclerView;

    @InjectPresenter
    MoviePresenter moviePresenter;


    // TODO : 1) Реализация Movie Details

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(view -> Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show());

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getApplicationContext(), 2);
        moviesRecyclerView.setLayoutManager(mLayoutManager);
        startLoad();

    }

    // start load data, and get data from presenter to view
    private void startLoad() {
        moviePresenter.loadPopularMovies();
    }

    public MovieActivity() {
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_movie, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void showMovies(List<Movie> movies) {

        PopularMoviesAdapter adapter = new PopularMoviesAdapter(movies,getApplicationContext(),this);
        moviesRecyclerView.setAdapter(adapter);

    }


    @Override
    public void showError(String msg) {
        Log.e(ERROR_TAG,msg + " ");
    }

    @Override
    public void startMovieDetail(Movie movie) {
        MovieDetailActivity.start(getApplicationContext(),movie);
    }

    @Override
    public void onItemClick(@NonNull Movie movie) {
        // Impl Start Details
        moviePresenter.loadMovie(movie);
    }


}
