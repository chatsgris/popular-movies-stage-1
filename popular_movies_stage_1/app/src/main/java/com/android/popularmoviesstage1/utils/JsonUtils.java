package com.android.popularmoviesstage1.utils;

/**
 * Created by liumi on 5/5/2018.
 */

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.List;

public class JsonUtils {

    public static JSONObject getMovieInfo(String json, int position) throws JSONException {
        JSONObject jsonObject = new JSONObject(json);
        JSONObject movieInfo = jsonObject.getJSONArray("results").getJSONObject(position);
        return movieInfo;
    }

    public static String getPosterPath(JSONObject movieInfo) throws JSONException {
        String posterPath = movieInfo
                .getString("poster_path")
                .substring(1);
        return posterPath;
    }

    public static String getMovieTitle(JSONObject movieInfo) throws JSONException {
        String title = movieInfo
                .getString("title");
        return title;
    }

    public static String getMovieRelease(JSONObject movieInfo) throws JSONException {
        String release = movieInfo
                .getString("release_date");
        return release;
    }

    public static String getMovieVoting(JSONObject movieInfo) throws JSONException {
        String vote = movieInfo
                .getString("vote_average");
        return vote;
    }

    public static String getMoviePlot(JSONObject movieInfo) throws JSONException {
        String plot = movieInfo
                .getString("overview");
        return plot;
    }
}