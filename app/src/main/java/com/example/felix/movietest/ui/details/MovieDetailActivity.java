package com.example.felix.movietest.ui.details;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.felix.movietest.BuildConfig;
import com.example.felix.movietest.R;
import com.example.felix.movietest.data.model.Movie;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.annotations.NonNull;

public class MovieDetailActivity extends MvpAppCompatActivity implements IMovieDetailsView {

    private static final String MOVIE = "movie";
    private static final String DETAIL_TAG = "DETAIL_ACTIVITY";

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.titleMovie)
    TextView titleView;

    @BindView(R.id.detailImageView)
    ImageView imageView;


    @InjectPresenter
    MovieDetailPresenter detailPresenter;

    public static void start(@NonNull Context context, @NonNull Movie movie) {
        Intent intent = new Intent(context,MovieDetailActivity.class);
        intent.putExtra(MOVIE,movie);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);

        Movie movie = getIntent().getParcelableExtra(MOVIE);
        showMovie(movie);

        detailPresenter = new MovieDetailPresenter();
        detailPresenter.loadMovie(movie);

        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(view -> Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show());*/
    }


    @Override
    public void showMovie(Movie movie) {

        Picasso.with(getApplicationContext())
                // Write BASE_URL for image here, because mapper not working normally
                .load(BuildConfig.BASE_IMAGES_URL + movie.getImageUrl())
                .into(imageView);

        titleView.setText(movie.getName());
    }

    @Override
    public void showAddedBookmark() {
        // TODO : IMPL
        // cache

    }

    @Override
    public void showDeletedBookmark() {
        // TODO : IMPL
    }

}
