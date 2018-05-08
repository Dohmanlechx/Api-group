package com.dohman.apigrupparbete;


import android.content.ClipData;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.support.v7.widget.SearchView;
import android.widget.TextView;

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
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ListView listView;
    private SearchView searchView;
    ArrayList<MovieDetails> movieList;
    MovieArrayAdapter movieArrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.list);
        listView.setOnItemClickListener(this);

//Executing AsyncTask, passing api as parameter
        new CheckConnectionStatus().execute("https://api.themoviedb.org/3/search/movie?api_key=bc0d9d234a1124140f2ca26988c9ae27&query=avatar");

    }

    //This method is invoked whenever we click over any item of list
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        //Moving to MovieDetailsActivity from MainActivity. Sending the MovieDetails object from one activity to another activity
        Intent intent = new Intent(this, MovieDetailActivity.class);
        intent.putExtra("MOVIE_DETAILS", (MovieDetails)parent.getItemAtPosition(position));
        startActivity(intent);

    }

    //AsyncTask to process network request
    class CheckConnectionStatus extends AsyncTask<String, Void, String> {
        //This method will run on UIThread and it will execute before doInBackground
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }
        //This method will run on background thread and after completion it will return result to onPostExecute
        @Override
        protected String doInBackground(String... params) {
            URL url = null;
            try {
//As we are passing just one parameter to AsyncTask, so used param[0] to get value at 0th position that is URL
                url = new URL(params[0]);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            try {
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
//Getting inputstream from connection, that is response which we got from server
                InputStream inputStream = urlConnection.getInputStream();
//Reading the response
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                String s = bufferedReader.readLine();
                bufferedReader.close();
//Returning the response message to onPostExecute method
                return s;
            } catch (IOException e) {
                Log.e("Error: ", e.getMessage(), e);
            }
            return null;
        }
        //This method runs on UIThread and it will execute when doInBackground is completed
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            JSONObject jsonObject = null;
            try {

//Parent JSON Object. Json object start at { and end at }
                jsonObject = new JSONObject(s);

                movieList = new ArrayList<>();

//JSON Array of parent JSON object. Json array starts from [ and end at ]
                JSONArray jsonArray = jsonObject.getJSONArray("results");

//Reading JSON object inside Json array
                for (int i =0; i<jsonArray.length();i++)
                {

//Reading JSON object at 'i'th position of JSON Array
                    JSONObject object = jsonArray.getJSONObject(i);
                    MovieDetails movieDetails = new MovieDetails();
                    movieDetails.setTitle(object.getString("original_title"));
                    movieDetails.setRating(object.getDouble("vote_average"));
                    movieDetails.setPlot(object.getString("overview"));
                    movieDetails.setRelease_year(object.getString("release_date"));
                    movieDetails.setImage(object.getString("poster_path"));
                    movieList.add(movieDetails);

                }

                //Creating custom array adapter instance and setting context of MainActivity, List item layout file and movie list.
                movieArrayAdapter = new MovieArrayAdapter(MainActivity.this,R.layout.movie_list,movieList);

                //Setting adapter to listview
                listView.setAdapter(movieArrayAdapter);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        final MenuItem myActionMenuItem=menu.findItem(R.id.action_search);

        searchView=(SearchView) myActionMenuItem.getActionView();
        changeSearchViewTextColor(searchView);

        ((EditText) searchView.findViewById(android.support.v7.appcompat.R.id.search_src_text)).setHintTextColor(getResources().getColor(R.color.white));
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {

                if (!searchView.isIconified()){
                    searchView.setIconified(true);
                }
                myActionMenuItem.collapseActionView();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                newText=newText.toLowerCase();
                new CheckConnectionStatus().execute("https://api.themoviedb.org/3/search/movie?api_key=bc0d9d234a1124140f2ca26988c9ae27&query="+newText);

                /*List<MovieDetails> filteredMoviesList=new ArrayList<>();

                for (MovieDetails model:movieList){
                     String text=model.getTitle().toLowerCase();
                     if(text.contains(newText)){
                         filteredMoviesList.add(model);
                     }
                 }
                 movieArrayAdapter.setfilter(filteredMoviesList);*/


                return true;
            }
        });

        return true;
    }

    /*private List<MovieDetails> filter(List<MovieDetails> pl, String query){
        query=query.toLowerCase();
        final List<MovieDetails> filteredMoviesList=new ArrayList<>();
        for (MovieDetails model:pl){
            final String text=model.getTitle().toLowerCase();
            if(text.startsWith(text)){
                filteredMoviesList.add(model);
            }
        }
        return filteredMoviesList;
    }*/

    //for changeing the text color of searchview
    private void changeSearchViewTextColor(View view){
        if(view!=null){
            if(view instanceof TextView){
                ((TextView) view).setTextColor(Color.WHITE);
                return;
            } else if(view instanceof ViewGroup){
                ViewGroup viewGroup=(ViewGroup) view;
                for(int i=0; i<viewGroup.getChildCount();i++){
                    changeSearchViewTextColor(viewGroup.getChildAt(i));


                }

            }

        }


    }
}