package com.android.popularmoviesstage1.utils;

import android.net.Uri;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class NetworkUtils {
    final static String POSTER_BASE_URL =
            "http://image.tmdb.org/t/p/w185";
    final static String POPULARITY_URL =
            "http://api.themoviedb.org/3/movie/popular";
    final static String RATING_URL =
            "http://api.themoviedb.org/3/movie/top_rated";

    public static URL buildPopularityUrl (String apiKey) {
        Uri builtUri = Uri.parse(POPULARITY_URL).buildUpon()
                .appendQueryParameter("api_key", apiKey)
                .build();
        URL url = null;
        try {
            url = new URL(builtUri.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return url;
    }

    public static URL buildRatingUrl (String apiKey) {
        Uri builtUri = Uri.parse(RATING_URL).buildUpon()
                .appendQueryParameter("api_key", apiKey)
                .build();
        URL url = null;
        try {
            url = new URL(builtUri.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return url;
    }

    public static String buildPosterUrl(String posterPath) {
        Uri builtUri = Uri.parse(POSTER_BASE_URL).buildUpon()
                .appendPath(posterPath)
                .build();
        return builtUri.toString();
    }

    public static String getResponseFromHttpUrl(URL url) throws IOException {
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        try {
            InputStream in = urlConnection.getInputStream();

            Scanner scanner = new Scanner(in);
            scanner.useDelimiter("\\A");

            boolean hasInput = scanner.hasNext();
            if (hasInput) {
                return scanner.next();
            } else {
                return null;
            }
        } finally {
            urlConnection.disconnect();
        }
    }
}