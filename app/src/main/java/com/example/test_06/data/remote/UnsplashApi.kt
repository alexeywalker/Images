package com.example.test_06.data.remote

import com.example.test_06.model.UnsplashImage
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface UnsplashApi {

    // Delete key!
    @Headers("Authorization: Client-ID gTVaageWn_Bg0qGX4WENQd5RgdL_VW2SCYuesbximUk")
    @GET("/photos")
    suspend fun getAllImages(
        @Query("page") page: Int,
        @Query("per_page") perPage: Int
    ): List<UnsplashImage>

    // Delete key!
    @Headers("Authorization: Client-ID gTVaageWn_Bg0qGX4WENQd5RgdL_VW2SCYuesbximUk")
    @GET("/search/photos")
    suspend fun searchImages(
        @Query("page") page: Int,
        @Query("per_page") perPage: Int
    ): List<UnsplashImage>
}