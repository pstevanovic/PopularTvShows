package com.funnystep.populartvshows.data.source;

import com.funnystep.populartvshows.data.model.Result;
import com.funnystep.populartvshows.data.model.TvShowDetailResponse;
import com.funnystep.populartvshows.data.model.TvShowSimilarResponse;
import com.funnystep.populartvshows.data.model.TvShowsResponse;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DataSourceTests {

    private String mApiKey = "dummy";
    private String mLanguage = "en_US";

    private MockWebServer mMockWebServer;
    private TvShowsApiService mService;

    @Before
    public void setUp() {
        mMockWebServer = new MockWebServer();

        mService = new Retrofit.Builder()
                .baseUrl(mMockWebServer.url("").toString())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(TvShowsApiService.class);
    }

    @After
    public void tearDown() throws IOException {
        mMockWebServer.shutdown();
    }

    @Test
    public void test_popular_tv_shows_response_deserialization() throws Exception {
        mMockWebServer.enqueue(new MockResponse().setBody(Responses.RESPONSE_POPULAR_TVSHOWS));

        Call<TvShowsResponse> call = mService.fetchTvShows(mApiKey, mLanguage, 1);
        Response<TvShowsResponse> response = call.execute();

        Assert.assertTrue(response.isSuccessful());

        TvShowsResponse tvShowResponse = response.body();
        Assert.assertNotNull(tvShowResponse);

        Assert.assertEquals(tvShowResponse.page, 1);
        Assert.assertEquals(tvShowResponse.totalResults, 20018);
        Assert.assertEquals(tvShowResponse.totalPages, 1001);

        List<Result> results = tvShowResponse.results;
        Assert.assertNotNull(results);

        Assert.assertEquals(results.size(), 2);

        Result tvShow = results.get(0);
        Assert.assertNotNull(tvShow);

        Assert.assertEquals(tvShow.originalName, "Doctor Who");
        Assert.assertEquals(tvShow.id, 57243);
        Assert.assertEquals(tvShow.name, "Doctor Who");
        Assert.assertEquals(tvShow.voteCount, 742);
        Assert.assertEquals(tvShow.voteAverage, 6.94, 0.5);
        Assert.assertEquals(tvShow.posterPath, "/cFcZYgPRFZdBkA7EsxHz5Cb8x5.jpg");
        Assert.assertEquals(tvShow.firstAirDate, "2005-03-26");
        Assert.assertEquals(tvShow.popularity, 49.300568, 0.5);
        Assert.assertEquals(tvShow.originalLanguage, "en");
        Assert.assertEquals(tvShow.backdropPath, "/tQkigP2fItdzJWvtIhBvHxgs5yE.jpg");
        Assert.assertTrue(tvShow.overview.startsWith("The Doctor looks and seems human. He's handsome, witty, and could be"));

        Assert.assertNotNull(tvShow.genreIds);
        Assert.assertEquals(tvShow.genreIds.size(), 3);
        Assert.assertEquals((long) tvShow.genreIds.get(0), 10759);
        Assert.assertEquals((long) tvShow.genreIds.get(1), 18);
        Assert.assertEquals((long) tvShow.genreIds.get(2), 10765);

        Assert.assertNotNull(tvShow.originCountry);
        Assert.assertEquals(tvShow.originCountry.size(), 1);
        Assert.assertEquals(tvShow.originCountry.get(0), "GB");
    }

    @Test
    public void test_tv_shows_details_response_deserialization() throws Exception {
        mMockWebServer.enqueue(new MockResponse().setBody(Responses.RESPONSE_TV_SHOW_DETAIL));

        Call<TvShowDetailResponse> call = mService.fetchTvShowDetails("", mApiKey, mLanguage);
        Response<TvShowDetailResponse> response = call.execute();

        Assert.assertTrue(response.isSuccessful());

        TvShowDetailResponse tvShow = response.body();
        Assert.assertNotNull(tvShow);

        Assert.assertEquals(tvShow.id, 57243);
        Assert.assertEquals(tvShow.name, "Doctor Who");
        Assert.assertEquals(tvShow.backdropPath, "/tQkigP2fItdzJWvtIhBvHxgs5yE.jpg");
        Assert.assertEquals(tvShow.firstAirDate, "2005-03-26");
        Assert.assertEquals(tvShow.lastAirDate, "2017-07-01");
        Assert.assertEquals(tvShow.homepage, "http://www.bbc.co.uk/programmes/b006q2x0");
        Assert.assertEquals(tvShow.inProduction, true);

        Assert.assertEquals(tvShow.numberOfEpisodes, 127);
        Assert.assertEquals(tvShow.numberOfSeasons, 10);
        Assert.assertEquals(tvShow.originalLanguage, "en");
        Assert.assertEquals(tvShow.originalName, "Doctor Who");
        Assert.assertTrue(tvShow.overview.startsWith("The Doctor looks and seems human. He's handsome, witty, and could be mistaken for"));

        Assert.assertEquals(tvShow.popularity, 48.300568, 0.5);
        Assert.assertEquals(tvShow.posterPath, "/cFcZYgPRFZdBkA7EsxHz5Cb8x5.jpg");
        Assert.assertEquals(tvShow.status, "Returning Series");
        Assert.assertEquals(tvShow.type, "Scripted");
        Assert.assertEquals(tvShow.voteAverage, 6.9, 0.5);
        Assert.assertEquals(tvShow.voteCount, 742);

        Assert.assertNotNull(tvShow.createdBy);
        Assert.assertEquals(tvShow.createdBy.size(), 3);

        Assert.assertNotNull(tvShow.episodeRunTime);
        Assert.assertEquals(tvShow.episodeRunTime.size(), 5);

        Assert.assertNotNull(tvShow.genres);
        Assert.assertEquals(tvShow.genres.size(), 3);

        Assert.assertNotNull(tvShow.languages);
        Assert.assertEquals(tvShow.languages.size(), 1);

        Assert.assertNotNull(tvShow.networks);
        Assert.assertEquals(tvShow.networks.size(), 3);

        Assert.assertNotNull(tvShow.originCountry);
        Assert.assertEquals(tvShow.originCountry.size(), 1);

        Assert.assertNotNull(tvShow.productionCompanies);
        Assert.assertEquals(tvShow.productionCompanies.size(), 2);

        Assert.assertNotNull(tvShow.seasons);
        Assert.assertEquals(tvShow.seasons.size(), 11);
    }

    @Test
    public void test_similar_tv_shows_response_deserialization() throws Exception {
        mMockWebServer.enqueue(new MockResponse().setBody(Responses.RESPONSE_SIMILAR_TV_SHOWS));

        Call<TvShowSimilarResponse> call = mService.fetchSimilarTvShows("", mApiKey, mLanguage, 1);
        Response<TvShowSimilarResponse> response = call.execute();

        Assert.assertTrue(response.isSuccessful());

        TvShowSimilarResponse tvShowSimilarResponse = response.body();
        Assert.assertNotNull(tvShowSimilarResponse);

        Assert.assertEquals(tvShowSimilarResponse.page, 1);
        Assert.assertEquals(tvShowSimilarResponse.totalResults, 171);
        Assert.assertEquals(tvShowSimilarResponse.totalPages, 9);

        List<Result> results = tvShowSimilarResponse.results;
        Assert.assertNotNull(results);

        Assert.assertEquals(results.size(), 2);

        Result tvShow = results.get(0);
        Assert.assertNotNull(tvShow);

        Assert.assertEquals(tvShow.originalName, "Doctor Who");
        Assert.assertEquals(tvShow.id, 121);
        Assert.assertEquals(tvShow.name, "Doctor Who");
        Assert.assertEquals(tvShow.voteCount, 93);
        Assert.assertEquals(tvShow.voteAverage, 7.8, 0.5);
        Assert.assertEquals(tvShow.posterPath, "/2JQuvqyAIaznRSr5RjKofMAfpq5.jpg");
        Assert.assertEquals(tvShow.firstAirDate, "1963-11-23");
        Assert.assertEquals(tvShow.popularity, 6.712757, 0.5);
        Assert.assertEquals(tvShow.originalLanguage, "en");
        Assert.assertEquals(tvShow.backdropPath, "/lg2ZQpxhWLdtkeBUwfqzJ1HpU28.jpg");
        Assert.assertTrue(tvShow.overview.startsWith("The adventures of a Time Lord—a time-travelling humanoid alien known as the Doctor—who"));

        Assert.assertNotNull(tvShow.genreIds);
        Assert.assertEquals(tvShow.genreIds.size(), 3);
        Assert.assertEquals((long) tvShow.genreIds.get(0), 10759);
        Assert.assertEquals((long) tvShow.genreIds.get(1), 18);
        Assert.assertEquals((long) tvShow.genreIds.get(2), 10765);

        Assert.assertNotNull(tvShow.originCountry);
        Assert.assertEquals(tvShow.originCountry.size(), 1);
        Assert.assertEquals(tvShow.originCountry.get(0), "GB");
    }

}
