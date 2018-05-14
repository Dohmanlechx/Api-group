package com.dohman.apigrupparbete;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class MovieDetailActivity extends AppCompatActivity {


    private ImageView image;

    private TextView title, date, rating, overview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
        Intent intent = getIntent();


        image = findViewById(R.id.imageMain);

        title = findViewById(R.id.textTitle);

        date = findViewById(R.id.textYear);

        rating = findViewById(R.id.textRating);

        overview = findViewById(R.id.textPlot);

        String imageStr = getIntent().getStringExtra("movie");
        String titleStr = getIntent().getStringExtra("title");
        String dateStr = getIntent().getStringExtra("date");
        String ratingStr = getIntent().getStringExtra("rating");
        String overViewStr = getIntent().getStringExtra("overview");



        Glide.with(this).load("https://image.tmdb.org/t/p/w500/" + imageStr).into(image);
        title.setText(titleStr);
        date.setText(dateStr);
        rating.setText(ratingStr);
        overview.setText(overViewStr);

        //Getting the value from bundle, means the value which we had during switching to this activity from main activity
        //MovieDetails details = (MovieDetails) getIntent().getExtras().getSerializable("MOVIE_DETAILS");
        //Bitmap bitmap = getIntent().getParcelableExtra("movieBitmap");
        //byte[] byteArray = getIntent().getByteArrayExtra("movieBitmap");
        //Bitmap bitmap = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);

        //Bundle extras = getIntent().getExtras();
        //byte[] byteArray = extras.getByteArray("movieBitmap");
        //Bitmap bitmap = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);


        //image.setImageBitmap(bitmap);

        /*if (details != null) {
            //Showing image from the movie db api into imageview using glide library
            Glide.with(this).load("https://image.tmdb.org/t/p/w500/" + details.getImageString()).into(image);
            title.setText(details.getTitle());
            date.setText(details.getRelease_year());
            rating.setText(Double.toString(details.getRating()));
            overview.setText(details.getPlot());
        }*/
    }
}
