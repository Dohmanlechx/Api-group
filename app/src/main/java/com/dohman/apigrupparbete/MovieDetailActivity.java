package com.dohman.apigrupparbete;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MovieDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
    }

    private MovieDetails getMovie() {

      MovieDetails movieDetails = new MovieDetails();



      return movieDetails;
    }

    private void setMovie() {

    }

}
