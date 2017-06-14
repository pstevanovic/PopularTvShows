package com.funnystep.populartvshows.data.source;

import com.funnystep.populartvshows.data.model.TvShowDetailResponse;
import com.funnystep.populartvshows.data.model.TvShowSimilarResponse;
import com.funnystep.populartvshows.data.model.TvShowsResponse;

import android.util.Log;

import java.util.Locale;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TvShowsRemoteDataSource implements TvShowsDataSource {
    private static final String TAG = TvShowsRemoteDataSource.class.getSimpleName();

    private static final String URL = "https://api.themoviedb.org/";

    /**
     * // https://api.themoviedb.org/3/tv/{tv_id}?api_key={key}&language=en-US
     */
    private static final String URL_DETAILS = "/" + TvShowsApiService.API_VERSION + "/tv/%s";

    /**
     * https://api.themoviedb.org/3/tv/{tv_id}/similar?api_key={key}&language=en-US&page={page}
     */
    private static final String URL_SIMILAR = "/" + TvShowsApiService.API_VERSION + "/tv/%s/similar";

    private static final String API_KEY = "a2a07163e556cb724e2c746046a4bc4b";

    private static TvShowsRemoteDataSource sInstance;
    private final TvShowsApiService mService;

    private TvShowsRemoteDataSource() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        mService = retrofit.create(TvShowsApiService.class);
    }

    public static TvShowsRemoteDataSource get() {
        if (sInstance == null)
            sInstance = new TvShowsRemoteDataSource();

        return sInstance;
    }

    @Override
    public void fetchPopularTvShows(final PopularShowsCallback callback, int page) {
        Log.d(TAG, "fetchPopularTvShows - page:" + page);

        mService.fetchTvShows(API_KEY, getLanguage(), page).enqueue(new retrofit2.Callback<TvShowsResponse>() {
            @Override
            public void onResponse(Call<TvShowsResponse> call, retrofit2.Response<TvShowsResponse> response) {
                if (response.isSuccessful()) {
                    callback.onPopularTvShowsFetched(response.body());
                } else {
                    callback.onDataFetchError(response.code() + " " + response.message());
                }
            }

            @Override
            public void onFailure(Call<TvShowsResponse> call, Throwable t) {
                callback.onDataFetchError(t.getMessage());
            }
        });
    }

    @Override
    public void fetchTvShowDetails(final DetailsCallback callback, int showId) {
        Log.d(TAG, "fetchTvShowDetails - id:" + showId);
        String detailsUrl = String.format(URL_DETAILS, showId);

        mService.fetchTvShowDetails(detailsUrl, API_KEY, getLanguage()).enqueue(new retrofit2.Callback<TvShowDetailResponse>() {
            @Override
            public void onResponse(Call<TvShowDetailResponse> call, retrofit2.Response<TvShowDetailResponse> response) {
                if (response.isSuccessful()) {
                    callback.onTvShowDetailsFetched(response.body());
                } else {
                    callback.onDataFetchError(response.code() + " " + response.message());
                }
            }

            @Override
            public void onFailure(Call<TvShowDetailResponse> call, Throwable t) {
                callback.onDataFetchError(t.getMessage());
            }
        });
    }

    @Override
    public void fetchSimilarTvShows(final DetailsCallback callback, int showId, int page) {
        Log.d(TAG, "fetchSimilarTvShows - id:" + showId + " page:" + page);
        String url = String.format(URL_SIMILAR, showId);

        mService.fetchSimilarTvShows(url, API_KEY, getLanguage(), page).enqueue(new retrofit2.Callback<TvShowSimilarResponse>() {
            @Override
            public void onResponse(Call<TvShowSimilarResponse> call, retrofit2.Response<TvShowSimilarResponse> response) {
                if (response.isSuccessful()) {
                    callback.onSimilarTvShowsFetched(response.body());
                } else {
                    callback.onDataFetchError(response.code() + " " + response.message());
                }
            }

            @Override
            public void onFailure(Call<TvShowSimilarResponse> call, Throwable t) {
                callback.onDataFetchError(t.getMessage());
            }
        });
    }

    private String getLanguage() {
        return Locale.getDefault().toString();
    }
}
