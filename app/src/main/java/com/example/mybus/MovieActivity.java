package com.example.mybus;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.mybus.bean.Movies;

public class MovieActivity extends AppCompatActivity {

    public ImageView imageView_movie_title;
    public TextView textView_movie_name,textView_movie_noid, textView_movie_actor,textView_movie_category, textView_movie_publisher, textView_movie_producer, textView_movie_date,
                    textView_movie_duration, textView_movie_series;
    public ListView listView_magnetic, listView_picture_movie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);
        initView();
        initEvent();
    }

    private void initView(){
        imageView_movie_title = (ImageView)findViewById(R.id.image_movie);

        textView_movie_name = (TextView) findViewById(R.id.movie_activity_movie_name);
        textView_movie_actor = (TextView) findViewById(R.id.movie_activity_movie_actor);
        textView_movie_noid = (TextView) findViewById(R.id.movie_activity_movie_noid);
        textView_movie_category = (TextView) findViewById(R.id.movie_activity_movie_categories);
        textView_movie_publisher = (TextView) findViewById(R.id.movie_activity_movie_publisher);
        textView_movie_producer = (TextView) findViewById(R.id.movie_activity_movie_producer);
        textView_movie_date = (TextView) findViewById(R.id.movie_activity_movie_date);
        textView_movie_duration = (TextView) findViewById(R.id.movie_activity_movie_duration);
        textView_movie_series = (TextView) findViewById(R.id.movie_activity_movie_series);

        listView_magnetic = (ListView) findViewById(R.id.movie_activity_listview_magnetic);
        listView_picture_movie = (ListView) findViewById(R.id.movie_activity_listview_pictures);

        Movies movies = (Movies) getIntent().getSerializableExtra("movies");

        imageView_movie_title.setBackgroundResource(movies.getImage());
        textView_movie_name.setText(movies.getMovie_name());
        textView_movie_noid.setText(movies.getNoId());
        textView_movie_actor.setText(movies.getActor_name_movie());
        textView_movie_category.setText(movies.getCategory());
        textView_movie_publisher.setText(movies.getPublisher());
        textView_movie_producer.setText(movies.getProducer());
        textView_movie_date.setText(movies.getMovie_date());
        textView_movie_duration.setText(movies.getDuration());
        textView_movie_series.setText(movies.getSeries());

    }

    private void initEvent(){

    }
}