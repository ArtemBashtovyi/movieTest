package com.example.felix.movietest.data.api;

import android.support.annotation.NonNull;

import com.example.felix.movietest.BuildConfig;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by felix on 9/25/17.
 *
 */

public class ApiKeyInterceptor implements Interceptor {

    @Override
    public Response intercept(@NonNull Chain chain) throws IOException {
        Request request =  chain.request();

        HttpUrl url = request.url().newBuilder()
                .addQueryParameter("api_key", BuildConfig.API_KEY)
                .build();
        request = request.newBuilder().url(url).build();

        return chain.proceed(request);
    }


}
