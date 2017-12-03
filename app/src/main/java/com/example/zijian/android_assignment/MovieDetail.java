package com.example.zijian.android_assignment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.zijian.android_assignment.Common.Common;
import com.example.zijian.android_assignment.Model.Movie;
import com.flaviofaria.kenburnsview.KenBurnsView;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

public class MovieDetail extends AppCompatActivity {

    KenBurnsView movie_image;
    TextView movie_title,movie_summary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);

        movie_image = (KenBurnsView)findViewById(R.id.movie_image);
        movie_title = (TextView)findViewById(R.id.movie_title);
        movie_summary = (TextView)findViewById(R.id.movie_summary);


        if (getIntent() != null)
        {
            int movie_index = getIntent().getIntExtra("movie_index",-1);
            if (movie_index != -1)
            {
                loadMovieDetail(movie_index);
            }
        }

    }

    private void loadMovieDetail(int index) {
        Movie movie = Common.movieList.get(index);

        //Load image
        Picasso.with(getBaseContext()).load(movie.getUrl()).into(movie_image);
        movie_title.setText(movie.getTitle());
        movie_summary.setText(movie.getSummary());

    }
}
