package com.funnystep.populartvshows.ui.model;

import com.funnystep.populartvshows.Stubs;
import com.funnystep.populartvshows.data.model.Result;

import junit.framework.Assert;

import org.junit.Test;

public class ConverterTests {

    @Test
    public void test_convert_Result_to_TvShowBasic() throws Exception {
        // null Result
        TvShowBasic tvShow = Converter.convertResponseToBasic(null);
        Assert.assertNotNull(tvShow);

        // specific Result
        Result result = Stubs.getResult();
        tvShow = Converter.convertResponseToBasic(result);

        Assert.assertNotNull(tvShow);
        Assert.assertEquals(tvShow.id, result.id);
        Assert.assertEquals(tvShow.name, result.name);
        Assert.assertEquals(tvShow.originalName, result.originalName);
        Assert.assertEquals(tvShow.posterPath, result.posterPath);
        Assert.assertEquals(tvShow.overview, result.overview);
        Assert.assertEquals(tvShow.firstAirDate, result.firstAirDate);
        Assert.assertEquals(tvShow.originalLanguage, result.originalLanguage);
        Assert.assertEquals(tvShow.originCountry, result.originCountry);
        Assert.assertEquals(tvShow.popularity, result.popularity);
        Assert.assertEquals(tvShow.voteAverage, result.voteAverage);
        Assert.assertEquals(tvShow.voteCount, result.voteCount);
        Assert.assertEquals(tvShow.genreIds, result.genreIds);
        Assert.assertEquals(tvShow.backdropPath, result.backdropPath);
    }

    // etc :)

}
