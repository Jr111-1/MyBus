package com.example.mybus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.mybus.adapter.MovieAdapter;
import com.example.mybus.bean.Category;
import com.example.mybus.bean.Movies;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MovieListActivity extends AppCompatActivity {

    private TextView tw_title;
    private ListView listView_movie_list;
    private Context mContext;
    private List<Movies> moviesList = null;
    private MovieAdapter movieAdapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_list);
        initView();
        initEvent();
    }



    public void initView(){
        tw_title = (TextView) findViewById(R.id.tw_movieList);
        listView_movie_list = (ListView) findViewById(R.id.listview_movie_list);
        //获取数据
        Category category = (Category) getIntent().getSerializableExtra("category");
        //修改标题
        tw_title.setText(category.getCategotyName());

        //填充listview
        mContext = MovieListActivity.this;
        moviesList = category.getCategory_movieList();
        movieAdapter = new MovieAdapter((ArrayList<Movies>)moviesList,mContext);
        listView_movie_list.setAdapter(movieAdapter);



    }

    public void initEvent(){
        listView_movie_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Movies movies = moviesList.get(i);
//                Bundle bundle = new Bundle();
//                bundle.putSerializable("movies",movies);
                Intent intent = new Intent(MovieListActivity.this,MovieActivity.class);
                intent.putExtra("movies",movies);
                startActivity(intent);
            }
        });
    }

}