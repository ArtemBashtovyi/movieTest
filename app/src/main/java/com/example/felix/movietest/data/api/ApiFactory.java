package com.example.felix.movietest.data.api;

import android.support.annotation.NonNull;

import com.example.felix.movietest.BuildConfig;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by felix on 9/25/17.
 *
 */

public class ApiFactory {

    private static OkHttpClient okHttpClient;

    private static MovieService movieService;

    // Double-check pattern thread-safe
    public static MovieService buildMovieService() {
        MovieService mMovieService  = movieService;
        if (mMovieService == null) {
            synchronized (ApiFactory.class) {
                mMovieService = movieService;
                if (mMovieService == null) {
                    mMovieService = movieService = createMovieService();
                }
            }
        }
        return mMovieService;
    }

    @NonNull
    private static MovieService createMovieService() {
        return new Retrofit.Builder()
                .client(buildClient())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(BuildConfig.API_ENDPOINT)
                .build()
                .create(MovieService.class);

    }

    // Double-checked impl of Singleton
    @NonNull
    private static OkHttpClient buildClient() {
        OkHttpClient mOkHttpClient = okHttpClient;
        if( okHttpClient == null) {
            synchronized (ApiFactory.class) {
                mOkHttpClient = okHttpClient;
                if (okHttpClient == null) {
                    mOkHttpClient = okHttpClient = createClient();
                }
            }
        }
        return mOkHttpClient;
    }

    @NonNull
    private static OkHttpClient createClient() {
        return new OkHttpClient.Builder()
                .connectTimeout(5, TimeUnit.SECONDS)
                .readTimeout(5,TimeUnit.SECONDS)
                .addInterceptor(new ApiKeyInterceptor())
                .build();
    }

}
