package com.example.felix.movietest.ui.movies.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.felix.movietest.BuildConfig;
import com.example.felix.movietest.R;
import com.example.felix.movietest.data.model.Movie;
import com.squareup.picasso.Callback;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by felix on 9/30/17.
 *
 */

public class PopularMoviesAdapter extends RecyclerView.Adapter<PopularViewHolder> {


    private List<Movie> movieList;
    private Context context;
    private final OnItemClickListener onItemClickListener;


    public PopularMoviesAdapter(List<Movie> movieList, Context context,
                                @NonNull OnItemClickListener onItemClickListener) {
        this.movieList = movieList;
        this.context = context;
        this.onItemClickListener = onItemClickListener;
    }

    private View.OnClickListener click = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Movie movie = (Movie) view.getTag();
            onItemClickListener.onItemClick(movie);
        }
    };

    @Override
    public PopularViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        /*View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.popular_movie_item,parent,
                false);
        return new PopularViewHolder(vie);*/
        return PopularViewHolder.create(context);

    }

    @Override
    public void onBindViewHolder(PopularViewHolder holder, int position) {
        holder.bind(context,movieList.get(position));

        holder.imageView.setOnClickListener(click);
        holder.imageView.setTag(movieList.get(position));
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }


    public interface OnItemClickListener {

        void onItemClick( @NonNull Movie movie);

    }

}
