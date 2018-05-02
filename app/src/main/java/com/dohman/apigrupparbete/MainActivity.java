package com.dohman.apigrupparbete;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

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
        }
    }
}
