package com.example.felix.movietest.ui.movies.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.example.felix.movietest.BuildConfig;
import com.example.felix.movietest.R;
import com.example.felix.movietest.data.model.Movie;
import com.squareup.picasso.Callback;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by felix on 9/30/17.
 *
 */

public class PopularViewHolder extends RecyclerView.ViewHolder{

    @BindView(R.id.imageView)
    ImageView imageView;

    public PopularViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }

    @NonNull
    public static PopularViewHolder create(@NonNull Context context) {
        View view = View.inflate(context, R.layout.popular_movie_item, null);
        return new PopularViewHolder(view);
    }

    public void bind(@NonNull Context context, Movie movie) {
        // Picasso with cache
        Picasso.with(context)
                // Write BASE_URL for image here, because mapper not working normally
                .load(BuildConfig.BASE_IMAGES_URL + movie.getImageUrl())
                .networkPolicy(NetworkPolicy.OFFLINE)
                .into(imageView, new Callback() {
                    @Override
                    public void onSuccess() {
                        //do nothing
                    }

                    @Override
                    public void onError() {
                        //Try again online if cache failed
                        Picasso.with(context)
                                .load(BuildConfig.BASE_IMAGES_URL + movie.getImageUrl())
                                .error(R.drawable.ic_error_black_24dp)
                                .into(imageView, new Callback() {
                                    @Override
                                    public void onSuccess() {

                                    }
                                    @Override
                                    public void onError() {
                                        Log.v("Picasso","Could not fetch image");
                                    }
                                });
                    }
                });
    }
}
