package com.example.assignment6.model;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * An interface Api has been created which will help in order to save Base Url
 * of the Json File API
 */
public interface Api {
    String BASE_URL = "http://jsonplaceholder.typicode.com/";

    @GET("users")
    Call<ArrayList<User>> getUser();

    @GET("posts")
    Call<ArrayList<UserPosts>> getPosts(@Query("userId") int userId);
}
