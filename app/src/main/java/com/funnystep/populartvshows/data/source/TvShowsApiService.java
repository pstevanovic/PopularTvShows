package com.funnystep.populartvshows.data.source;

import com.funnystep.populartvshows.data.model.TvShowDetailResponse;
import com.funnystep.populartvshows.data.model.TvShowSimilarResponse;
import com.funnystep.populartvshows.data.model.TvShowsResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Url;

interface TvShowsApiService {

    int API_VERSION = 3;

    @GET("/" + API_VERSION + "/tv/popular/")
    Call<TvShowsResponse> fetchTvShows(
            @Query("api_key") String apiKey,
            @Query("language") String language,
            @Query("page") int page);

    @GET
    Call<TvShowDetailResponse> fetchTvShowDetails(
            @Url String url,
            @Query("api_key") String apiKey,
            @Query("language") String language
                                                 );

    @GET
    Call<TvShowSimilarResponse> fetchSimilarTvShows(
            @Url String url,
            @Query("api_key") String apiKey,
            @Query("language") String language,
            @Query("page") int page);
}
