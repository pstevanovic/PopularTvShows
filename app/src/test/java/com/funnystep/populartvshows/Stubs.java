package com.funnystep.populartvshows;

import com.funnystep.populartvshows.data.model.Result;
import com.funnystep.populartvshows.data.model.TvShowsResponse;

import java.util.ArrayList;

public class Stubs {

    public static final String RESPONSE_POPULAR_TVSHOWS =
            "{\n"+
                    "  \"page\": 1,\n"+
                    "  \"total_results\": 20018,\n"+
                    "  \"total_pages\": 1001,\n"+
                    "  \"results\": [\n"+
                    "    {\n"+
                    "      \"original_name\": \"Doctor Who\",\n"+
                    "      \"id\": 57243,\n"+
                    "      \"name\": \"Doctor Who\",\n"+
                    "      \"vote_count\": 742,\n"+
                    "      \"vote_average\": 6.94,\n"+
                    "      \"poster_path\": \"/cFcZYgPRFZdBkA7EsxHz5Cb8x5.jpg\",\n"+
                    "      \"first_air_date\": \"2005-03-26\",\n"+
                    "      \"popularity\": 49.300568,\n"+
                    "      \"genre_ids\": [\n"+
                    "        10759,\n"+
                    "        18,\n"+
                    "        10765\n"+
                    "      ],\n"+
                    "      \"original_language\": \"en\",\n"+
                    "      \"backdrop_path\": \"/tQkigP2fItdzJWvtIhBvHxgs5yE.jpg\",\n"+
                    "      \"overview\": \"The Doctor looks and seems human. He's handsome, witty, and could be mistaken for just another man in the street. But he is a Time Lord: a 900 year old alien with 2 hearts, part of a gifted civilization who mastered time travel. The Doctor saves planets for a living – more of a hobby actually, and he's very, very good at it. He's saved us from alien menaces and evil from before time began – but just who is he?\",\n"+
                    "      \"origin_country\": [\n"+
                    "        \"GB\"\n"+
                    "      ]\n"+
                    "    },\n"+
                    "    {\n"+
                    "      \"original_name\": \"Game of Thrones\",\n"+
                    "      \"id\": 1399,\n"+
                    "      \"name\": \"Game of Thrones\",\n"+
                    "      \"vote_count\": 2448,\n"+
                    "      \"vote_average\": 8.05,\n"+
                    "      \"poster_path\": \"/jIhL6mlT7AblhbHJgEoiBIOUVl1.jpg\",\n"+
                    "      \"first_air_date\": \"2011-04-17\",\n"+
                    "      \"popularity\": 39.6966,\n"+
                    "      \"genre_ids\": [\n"+
                    "        10759,\n"+
                    "        18,\n"+
                    "        10765\n"+
                    "      ],\n"+
                    "      \"original_language\": \"en\",\n"+
                    "      \"backdrop_path\": \"/mUkuc2wyV9dHLG0D0Loaw5pO2s8.jpg\",\n"+
                    "      \"overview\": \"Seven noble families fight for control of the mythical land of Westeros. Friction between the houses leads to full-scale war. All while a very ancient evil awakens in the farthest north. Amidst the war, a neglected military order of misfits, the Night's Watch, is all that stands between the realms of men and icy horrors beyond.\",\n"+
                    "      \"origin_country\": [\n"+
                    "        \"US\"\n"+
                    "      ]\n"+
                    "    }\n"+
                    "  ]\n"+
                    "}";

    public static final String RESPONSE_SIMILAR_TV_SHOWS =
            "{\n" +
                    "  \"page\": 1,\n" +
                    "  \"results\": [\n" +
                    "    {\n" +
                    "      \"backdrop_path\": \"/lg2ZQpxhWLdtkeBUwfqzJ1HpU28.jpg\",\n" +
                    "      \"first_air_date\": \"1963-11-23\",\n" +
                    "      \"genre_ids\": [\n" +
                    "        10759,\n" +
                    "        18,\n" +
                    "        10765\n" +
                    "      ],\n" +
                    "      \"id\": 121,\n" +
                    "      \"original_language\": \"en\",\n" +
                    "      \"original_name\": \"Doctor Who\",\n" +
                    "      \"overview\": \"The adventures of a Time Lord—a time-travelling humanoid alien known as the Doctor—who explores the universe in his TARDIS, a sentient time-travelling space ship. Its exterior appears as a blue British police box, which was a common sight in Britain in 1963 when the series first aired. Along with a succession of companions, the Doctor faces a variety of foes while working to save civilisations, help ordinary people, and right wrongs.\\n\\nThe show has received recognition as one of Britain's finest television programmes, winning the 2006 British Academy Television Award for Best Drama Series and five consecutive awards at the National Television Awards during Russell T Davies's tenure as Executive Producer. In 2011, Matt Smith became the first Doctor to be nominated for a BAFTA Television Award for Best Actor. In 2013, the Peabody Awards honoured Doctor Who with an Institutional Peabody \\\"for evolving with technology and the times like nothing else in the known television universe.\\\" The programme is listed in Guinness World Records as the longest-running science fiction television show in the world and as the \\\"most successful\\\" science fiction series of all time—based on its over-all broadcast ratings, DVD and book sales, and iTunes traffic. During its original run, it was recognised for its imaginative stories, creative low-budget special effects, and pioneering use of electronic music.\",\n" +
                    "      \"origin_country\": [\n" +
                    "        \"GB\"\n" +
                    "      ],\n" +
                    "      \"poster_path\": \"/2JQuvqyAIaznRSr5RjKofMAfpq5.jpg\",\n" +
                    "      \"popularity\": 6.712757,\n" +
                    "      \"name\": \"Doctor Who\",\n" +
                    "      \"vote_average\": 7.8,\n" +
                    "      \"vote_count\": 93\n" +
                    "    },\n" +
                    "    {\n" +
                    "      \"backdrop_path\": \"/gvmVtJTSBjNYj2RD2Tt5bWpgq7e.jpg\",\n" +
                    "      \"first_air_date\": \"1999-03-28\",\n" +
                    "      \"genre_ids\": [\n" +
                    "        16,\n" +
                    "        35,\n" +
                    "        18,\n" +
                    "        10765\n" +
                    "      ],\n" +
                    "      \"id\": 615,\n" +
                    "      \"original_language\": \"en\",\n" +
                    "      \"original_name\": \"Futurama\",\n" +
                    "      \"overview\": \"The adventures of a late-20th-century New York City pizza delivery boy, Philip J. Fry, who, after being unwittingly cryogenically frozen for one thousand years, finds employment at Planet Express, an interplanetary delivery company in the retro-futuristic 31st century.\",\n" +
                    "      \"origin_country\": [\n" +
                    "        \"US\"\n" +
                    "      ],\n" +
                    "      \"poster_path\": \"/iN0LOeE2JnJpIy4jF7imUjO6jwn.jpg\",\n" +
                    "      \"popularity\": 6.073438,\n" +
                    "      \"name\": \"Futurama\",\n" +
                    "      \"vote_average\": 7.9,\n" +
                    "      \"vote_count\": 364\n" +
                    "    }\n" +
                    "  ],\n" +
                    "  \"total_pages\": 9,\n" +
                    "  \"total_results\": 171\n" +
                    "}";

    public static final String RESPONSE_TV_SHOW_DETAIL =
            "{\n"+
                    "  \"backdrop_path\": \"/tQkigP2fItdzJWvtIhBvHxgs5yE.jpg\",\n"+
                    "  \"created_by\": [\n"+
                    "    {\n"+
                    "      \"id\": 57293,\n"+
                    "      \"name\": \"Sydney Newman\",\n"+
                    "      \"gender\": 2,\n"+
                    "      \"profile_path\": \"/1YfvkmiBjWPI67GsfoMd1NoPews.jpg\"\n"+
                    "    },\n"+
                    "    {\n"+
                    "      \"id\": 1213434,\n"+
                    "      \"name\": \"C. E. Webber\",\n"+
                    "      \"gender\": 0,\n"+
                    "      \"profile_path\": null\n"+
                    "    },\n"+
                    "    {\n"+
                    "      \"id\": 1213433,\n"+
                    "      \"name\": \"Donald Wilson\",\n"+
                    "      \"gender\": 0,\n"+
                    "      \"profile_path\": \"/1DeMkL3rF12uHMeMUlHXAoMUvDC.jpg\"\n"+
                    "    }\n"+
                    "  ],\n"+
                    "  \"episode_run_time\": [\n"+
                    "    80,\n"+
                    "    70,\n"+
                    "    50,\n"+
                    "    60,\n"+
                    "    45\n"+
                    "  ],\n"+
                    "  \"first_air_date\": \"2005-03-26\",\n"+
                    "  \"genres\": [\n"+
                    "    {\n"+
                    "      \"id\": 10759,\n"+
                    "      \"name\": \"Action & Adventure\"\n"+
                    "    },\n"+
                    "    {\n"+
                    "      \"id\": 18,\n"+
                    "      \"name\": \"Drama\"\n"+
                    "    },\n"+
                    "    {\n"+
                    "      \"id\": 10765,\n"+
                    "      \"name\": \"Sci-Fi & Fantasy\"\n"+
                    "    }\n"+
                    "  ],\n"+
                    "  \"homepage\": \"http://www.bbc.co.uk/programmes/b006q2x0\",\n"+
                    "  \"id\": 57243,\n"+
                    "  \"in_production\": true,\n"+
                    "  \"languages\": [\n"+
                    "    \"en\"\n"+
                    "  ],\n"+
                    "  \"last_air_date\": \"2017-07-01\",\n"+
                    "  \"name\": \"Doctor Who\",\n"+
                    "  \"networks\": [\n"+
                    "    {\n"+
                    "      \"id\": 4,\n"+
                    "      \"name\": \"BBC One\"\n"+
                    "    },\n"+
                    "    {\n"+
                    "      \"id\": 493,\n"+
                    "      \"name\": \"BBC America\"\n"+
                    "    },\n"+
                    "    {\n"+
                    "      \"id\": 511,\n"+
                    "      \"name\": \"France 4\"\n"+
                    "    }\n"+
                    "  ],\n"+
                    "  \"number_of_episodes\": 127,\n"+
                    "  \"number_of_seasons\": 10,\n"+
                    "  \"origin_country\": [\n"+
                    "    \"GB\"\n"+
                    "  ],\n"+
                    "  \"original_language\": \"en\",\n"+
                    "  \"original_name\": \"Doctor Who\",\n"+
                    "  \"overview\": \"The Doctor looks and seems human. He's handsome, witty, and could be mistaken for just another man in the street. But he is a Time Lord: a 900 year old alien with 2 hearts, part of a gifted civilization who mastered time travel. The Doctor saves planets for a living – more of a hobby actually, and he's very, very good at it. He's saved us from alien menaces and evil from before time began – but just who is he?\",\n"+
                    "  \"popularity\": 48.300568,\n"+
                    "  \"poster_path\": \"/cFcZYgPRFZdBkA7EsxHz5Cb8x5.jpg\",\n"+
                    "  \"production_companies\": [\n"+
                    "    {\n"+
                    "      \"name\": \"BBC Wales\",\n"+
                    "      \"id\": 4762\n"+
                    "    },\n"+
                    "    {\n"+
                    "      \"name\": \"Canadian Broadcasting Corporation\",\n"+
                    "      \"id\": 71708\n"+
                    "    }\n"+
                    "  ],\n"+
                    "  \"seasons\": [\n"+
                    "    {\n"+
                    "      \"air_date\": \"2005-11-18\",\n"+
                    "      \"episode_count\": 146,\n"+
                    "      \"id\": 58476,\n"+
                    "      \"poster_path\": \"/Shm5ZavLApx6HMFWviKP5Sx1J8.jpg\",\n"+
                    "      \"season_number\": 0\n"+
                    "    },\n"+
                    "    {\n"+
                    "      \"air_date\": \"2005-03-26\",\n"+
                    "      \"episode_count\": 13,\n"+
                    "      \"id\": 58468,\n"+
                    "      \"poster_path\": \"/9Jt2FFCAME7eHDC28r4qCHErhhF.jpg\",\n"+
                    "      \"season_number\": 1\n"+
                    "    },\n"+
                    "    {\n"+
                    "      \"air_date\": \"2006-04-15\",\n"+
                    "      \"episode_count\": 13,\n"+
                    "      \"id\": 58469,\n"+
                    "      \"poster_path\": \"/oXVmsIkZCgJDNcZJJxzvV7zwyb1.jpg\",\n"+
                    "      \"season_number\": 2\n"+
                    "    },\n"+
                    "    {\n"+
                    "      \"air_date\": \"2007-04-01\",\n"+
                    "      \"episode_count\": 13,\n"+
                    "      \"id\": 58470,\n"+
                    "      \"poster_path\": \"/67xbjSv353G2rqQIs6dnDKc6P11.jpg\",\n"+
                    "      \"season_number\": 3\n"+
                    "    },\n"+
                    "    {\n"+
                    "      \"air_date\": \"2008-04-05\",\n"+
                    "      \"episode_count\": 13,\n"+
                    "      \"id\": 58471,\n"+
                    "      \"poster_path\": \"/h6hogh9U371q87XLhvrJbczg8lm.jpg\",\n"+
                    "      \"season_number\": 4\n"+
                    "    },\n"+
                    "    {\n"+
                    "      \"air_date\": \"2010-04-03\",\n"+
                    "      \"episode_count\": 13,\n"+
                    "      \"id\": 58472,\n"+
                    "      \"poster_path\": \"/hUsQerEeMqsu9cVYzMEB2OGJjrw.jpg\",\n"+
                    "      \"season_number\": 5\n"+
                    "    },\n"+
                    "    {\n"+
                    "      \"air_date\": \"2011-04-23\",\n"+
                    "      \"episode_count\": 13,\n"+
                    "      \"id\": 58473,\n"+
                    "      \"poster_path\": \"/xmfMcVkVer5r33QhA4e2DpIR78B.jpg\",\n"+
                    "      \"season_number\": 6\n"+
                    "    },\n"+
                    "    {\n"+
                    "      \"air_date\": \"2012-09-01\",\n"+
                    "      \"episode_count\": 13,\n"+
                    "      \"id\": 58474,\n"+
                    "      \"poster_path\": \"/6biGcR0OyFnKRxxUW7bGtK49wTd.jpg\",\n"+
                    "      \"season_number\": 7\n"+
                    "    },\n"+
                    "    {\n"+
                    "      \"air_date\": \"2014-08-23\",\n"+
                    "      \"episode_count\": 12,\n"+
                    "      \"id\": 58475,\n"+
                    "      \"poster_path\": \"/nMxeLkOF9DzbqJdSx7gzmbFvPGK.jpg\",\n"+
                    "      \"season_number\": 8\n"+
                    "    },\n"+
                    "    {\n"+
                    "      \"air_date\": \"2015-09-19\",\n"+
                    "      \"episode_count\": 12,\n"+
                    "      \"id\": 64188,\n"+
                    "      \"poster_path\": \"/uidaCdI0hKiZGfMzWHNMYeNZyV7.jpg\",\n"+
                    "      \"season_number\": 9\n"+
                    "    },\n"+
                    "    {\n"+
                    "      \"air_date\": \"2017-04-15\",\n"+
                    "      \"episode_count\": 12,\n"+
                    "      \"id\": 76615,\n"+
                    "      \"poster_path\": \"/8HPLQQqTPfy7Oiligw9FXcfig9w.jpg\",\n"+
                    "      \"season_number\": 10\n"+
                    "    }\n"+
                    "  ],\n"+
                    "  \"status\": \"Returning Series\",\n"+
                    "  \"type\": \"Scripted\",\n"+
                    "  \"vote_average\": 6.9,\n"+
                    "  \"vote_count\": 742\n"+
                    "}";

    public static Result getResult() {
        Result result = new Result();
        result.id = 1;
        result.name = "name";
        result.originalName = "originalName";
        result.posterPath = "posterPath";
        result.overview = "overview";
        result.firstAirDate = "firstAirDate";
        result.originalLanguage = "originalLanguage";
        result.originCountry = new ArrayList<>();
        result.originCountry.add("country1");
        result.popularity = 10.1;
        result.voteAverage = 5.5;
        result.voteCount = 100;
        result.genreIds = new ArrayList<>();
        result.genreIds.add(1);
        result.backdropPath = "backdropPath";
        return result;
    }

    public static TvShowsResponse getFirstPageResponse() {
        TvShowsResponse response = new TvShowsResponse();
        response.page = 1;
        response.totalPages = 10;
        response.results = new ArrayList<>();

        return response;
    }

    public static TvShowsResponse getNextPageResponse() {
        TvShowsResponse response = new TvShowsResponse();
        response.page = 5;
        response.totalPages = 10;
        response.results = new ArrayList<>();

        return response;
    }

}
