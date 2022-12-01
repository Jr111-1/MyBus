package com.example.mybus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.mybus.adapter.MovieAdapter;
import com.example.mybus.bean.movies;

import java.util.LinkedList;
import java.util.List;

public class ActorActivity extends AppCompatActivity {

    private ImageView picture_actor_title;
    private TextView textView_actorName, textView_age, textView_cup, textView_birthday, textView_height, textView_waist, textView_hipline, textView_bust;
    private ListView listView_actor_movie;
    private Context mContext;
    private List<movies> moviesList = null;
    private MovieAdapter movieAdapter = null;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actor);
        initView();
        initEvent();
    }

    public void initView(){
        picture_actor_title = (ImageView)findViewById(R.id.imageview_actor_title);
        textView_actorName = (TextView) findViewById(R.id.tw_actor_name);
        textView_age = (TextView) findViewById(R.id.tw_actor_age);
        textView_cup = (TextView) findViewById(R.id.tw_actor_cup);
        textView_birthday = (TextView) findViewById(R.id.tw_actor_birthday);
        textView_height = (TextView) findViewById(R.id.tw_actor_height);
        textView_waist = (TextView) findViewById(R.id.tw_actor_waist);
        textView_hipline = (TextView) findViewById(R.id.tw_actor_hipline);
        textView_bust = (TextView) findViewById(R.id.tw_actor_bust);

        mContext = ActorActivity.this;
        listView_actor_movie = (ListView) findViewById(R.id.listview_actor_movie);
        moviesList = new LinkedList<movies>();
        moviesList.add(new movies("金克斯","ipx111",R.drawable.jinx));
        moviesList.add(new movies("自行车","ipx222",R.drawable.bike));
        movieAdapter = new MovieAdapter((LinkedList<movies>)moviesList,mContext);
        listView_actor_movie.setAdapter(movieAdapter);

    }

    public void initEvent(){

    }
}