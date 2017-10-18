package com.example.felix.movietest;

import android.app.Application;

import com.example.felix.movietest.data.db.DaoSession;
import com.example.felix.movietest.data.db.DbService;
import com.squareup.picasso.OkHttpDownloader;
import com.squareup.picasso.Picasso;


/**
 * Created by felix on 9/25/17.
 *
 */

public class App extends Application {

    private static App mInstance;

    public static App getInstance() {
        App instance = mInstance;
         if (instance == null) {
             synchronized (App.class) {
                 instance = mInstance;
                 if (instance == null) {
                     instance = mInstance;
                 }
             }
         }
        return instance;
    }







    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;

        Picasso.Builder builder = new Picasso.Builder(this);
        builder.downloader(new OkHttpDownloader(this, Integer.MAX_VALUE));
        Picasso built = builder.build();
        built.setIndicatorsEnabled(true);
        built.setLoggingEnabled(true);
        Picasso.setSingletonInstance(built);
    }

    private DbService dbHelper = new DbService(this);

    public static DaoSession getNewSession() {
        return getInstance().dbHelper.getSession(true);
    }

    public static DaoSession getSession() {
        return getInstance().dbHelper.getSession(false);
    }
}
