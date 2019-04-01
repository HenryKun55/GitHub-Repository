package com.greytoolco.githubrepos.service.api;

import com.greytoolco.githubrepos.model.Repos;
import com.greytoolco.githubrepos.model.response.UserResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface UserApi {

    @GET("/users/{gitUser}")
    Call<UserResponse> getUser(@Path("gitUser") String gitUser );

    @GET("/users/{gitUser}/repos")
    Call<List<Repos>> getUserRepos(@Path("gitUser") String gitUser );
}
