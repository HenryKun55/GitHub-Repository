package com.greytoolco.githubrepos.service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Service {

    private static Retrofit retrofit = null;
    private static final String API_HTTP = "https://api.github.com/";

    private static Retrofit get() {
        if(null == retrofit)
            retrofit = new Retrofit.Builder()
                    .baseUrl(API_HTTP)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        return retrofit;
    }

    public static <T> T buildService(Class<T> type) {
        return get().create(type);
    }
}
