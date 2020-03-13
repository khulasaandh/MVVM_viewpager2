package com.example.rvpaginationmvvm.network;

import com.example.rvpaginationmvvm.model.Post;

import java.util.List;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface PostsApi {
    @GET("posts")
    Flowable<List<Post>> getPostsByUser(
            @Query("userId") int id
    );
}
