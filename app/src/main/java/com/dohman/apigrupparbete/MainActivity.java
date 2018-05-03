package com.dohman.apigrupparbete;

import android.graphics.Movie;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Executing AsyncTask, passing the API as parameter
        new CheckConnectionStatus().execute("https://api.themoviedb.org/3/movie/550?api_key=bc0d9d234a1124140f2ca26988c9ae27");
    }

    // AsyncTask to process network request
    class CheckConnectionStatus extends AsyncTask<String, Void, String> {
        // This method will run on UIThread and it will execute before doInBackground
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        // This method will run on background thread and after completion, it will return
        // result on onPostExecute
        @Override
        protected String doInBackground(String... params) {
            URL url = null;
            try {
                // As we are passing just one parameter to AsyncTask, so use params[0]
                // to get value at 0th position of the URL
                url = new URL(params[0]);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            try {
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                // Getting inputstream from connection, that is response which we get from server
                InputStream inputStream = urlConnection.getInputStream();
                // Reading the response
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                String s = bufferedReader.readLine();
                bufferedReader.close();
                // Returning the response message to onPostExcute
                return s;
            } catch (IOException e) {
                Log.e(TAG, "Error: ", e);
            }
            return null;
        }

        // This method runs on UIThread and it will execute when doInBackground is completed
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            JSONObject json = null;

            try {
                // Parent JSON Object. JSON Objects starts at { and ends at }
                json = new JSONObject(s);

                ArrayList<Movie> movieList = new ArrayList<>();

                // JSON Array of parent JSON Object. JSON Arrays starts at [ and ends at ]
                JSONArray jsonArray = json.getJSONArray("results");

                // Reading JSON Object inside JSON Array
                for (int i = 0; i < jsonArray.length(); i++) {
                    // Reading JSON Object at 'i' position of JSON Array
                    JSONObject object = jsonArray.getJSONObject(i);
                    Movie movie = new Movie();
                    movie.setTitle(object.getString("original_title"));
                    movie.setReleaseYear(object.getString("release_date"));
                    movie.setPlot(object.getString("overview"));
                    movie.setLanguage(object.getString("original_language"));
                    movie.setImage(object.getString("backdrop_path"));
                    // TODO Dessa är en parent json, fixas senare om tid finnes
                    //   movie.setGenre(object.getString("genres"));
                    //   movie.setCountry(object.getString("origin_country"));
                    //   movie.setProducer(object.getString("original_title"));
                    movie.setRuntime(object.getString("runtime"));
                    movie.setRating(object.getString("vote_average"));

                    movieList.add(movie);

                    //Creating custom array adapter instance and setting context of MainActivity, List item layout file and movie list.
                    // TODO Vi kan göra på annat sätt såklart, tex RecycleViewAdapter eller nåt. Nedanför är bara ett exempel.

                    /*MovieArrayAdapter movieArrayAdapter = new MovieArrayAdapter(MainActivity.this,R.layout.movie_list,movieList);

                    //Setting adapter to listview
                    listView.setAdapter(movieArrayAdapter);*/
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
