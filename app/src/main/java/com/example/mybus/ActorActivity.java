package com.example.mybus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.mybus.adapter.MovieAdapter;
import com.example.mybus.bean.Actor;
import com.example.mybus.bean.Movies;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ActorActivity extends AppCompatActivity {

    private ImageView picture_actor_title;
    private TextView textView_actorName, textView_age, textView_cup, textView_birthday, textView_height, textView_waist, textView_hipline, textView_bust;
    private ListView listView_actor_movie;
    private Context mContext;
    private List<Movies> moviesList = null;
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


        Actor actor = (Actor) getIntent().getSerializableExtra("actor");
        picture_actor_title.setBackgroundResource(actor.getPicture_actor());

        textView_actorName.setText(actor.getActorName());
        textView_age.setText(actor.getAge());
        textView_cup.setText(actor.getCup());
        textView_birthday.setText(actor.getBirthday());
        textView_height.setText(actor.getHeight());
        textView_waist.setText(actor.getWaist());
        textView_hipline.setText(actor.getHipline());
        textView_bust.setText(actor.getBust());

        mContext = ActorActivity.this;
        listView_actor_movie = (ListView) findViewById(R.id.listview_actor_movie);
        moviesList = actor.getActorMovieList();
        movieAdapter = new MovieAdapter((ArrayList<Movies>)moviesList,mContext);
        listView_actor_movie.setAdapter(movieAdapter);

    }

    public void initEvent(){

        listView_actor_movie.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Movies movies = moviesList.get(i);
//                Bundle bundle = new Bundle();
//                bundle.putSerializable("movies",movies);
                Intent intent = new Intent(ActorActivity.this,MovieActivity.class);
                intent.putExtra("movies",movies);
                startActivity(intent);
            }
        });

    }
}