package com.dohman.apigrupparbete;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MovieDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
    }

    private DetailedMovie getMovie() {

        String releaseYear = "2018";
        String title = "API the movie";
        double rating = 7.5;
        String genre = "Comedy";
        int runtime = 119;
        String plot = "You have so many different things placeholder text has to be able to do, and I don't believe Lorem Ipsum has the stamina. I don't think anybody knows it was Russia that wrote Lorem Ipsum, but I don't know, maybe it was. It could be Russia, but it could also be China. It could also be lots of other people. It also could be some wordsmith sitting on their bed that weights 400 pounds. Ok? It’s about making placeholder text great again. That’s what people want, they want placeholder text to be great again. I think the only card she has is the Lorem card.";
        String countryOfOrigin = "AMERICA!";
        String spokenLanguage = "AMERICAN";
        String poster = "https://i.imgur.com/OvbGwwI.jpg";

      DetailedMovie detailedMovie = new DetailedMovie(releaseYear, title, rating, genre, runtime, plot, countryOfOrigin, spokenLanguage, poster);



      return detailedMovie;
    }

    private void setMovie(DetailedMovie detailedMovie) {

        TextView yearTextView = findViewById(R.id.movieDetailTextYear);
        TextView titleTextView = findViewById(R.id.movieDetailTextTitle);
        TextView ratingTextView = findViewById(R.id.movieDetailTextRating);
        TextView genreTextView = findViewById(R.id.movieDetailTextGenre);
        TextView runtimeTextView = findViewById(R.id.movieDetailTextRuntime);
        TextView plotTextView = findViewById(R.id.movieDetailTextPlot);
        TextView countryTextView = findViewById(R.id.movieDetailTextCountry);
        TextView languageTextView = findViewById(R.id.movieDetailTextLanguage);
        ImageView posterImageView = findViewById(R.id.movieDetailPoster);

        yearTextView.setText(detailedMovie.getReleaseYear();
        titleTextView.setText(detailedMovie.getTitle());
        ratingTextView.setText(Double.toString(detailedMovie.getRating()));
        genreTextView.setText(detailedMovie.getGenre());
        runtimeTextView.setText(Integer.toString(detailedMovie.getRuntime()));
        plotTextView.setText(detailedMovie.getPlot());
        countryTextView.setText(detailedMovie.getCountryOfOrigin());
        languageTextView.setText(detailedMovie.getSpokenLanguage());
        posterImageView.setImageResource(R.drawable.blank_image);

    }
}
