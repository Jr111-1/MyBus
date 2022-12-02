package com.example.mybus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.mybus.adapter.MovieAdapter;
import com.example.mybus.bean.Movies;
import com.example.mybus.utils.Utils;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.LinkedList;
import java.util.List;

import okhttp3.OkHttpClient;


public class MainActivity extends AppCompatActivity {
    public static final String LoginUrl = "http://192.168.111.1:8082/api/user";

    private Button login;
    private Button menu;
    private Button btn_category;
    private Button btn_actor;
    private Handler handler = new Handler(Looper.getMainLooper());
    private TextView textView;
    private Context mContext;
    private List<Movies> moviesList = null;
    private MovieAdapter movieAdapter = null;
    private ListView listView_movie;
    private int flag = 0;


    private EditText email;
    private EditText password;
    private final OkHttpClient client = new OkHttpClient();
    private final ObjectMapper mapper = new ObjectMapper();
//    private int signInId = 0;
//    private final Handler handler = new Handler(Looper.getMainLooper());
//    private static final MediaType mediaType = MediaType.parse("application/json;charset=utf-8");
//    private final Message message = new Message();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initEvent();

    }
    private void initView() {
        login = (Button) findViewById(R.id.login);
        textView = (TextView) findViewById(R.id.tw_tw);
        mContext = MainActivity.this;


        listView_movie = (ListView) findViewById(R.id.listview_movie);
        moviesList = new LinkedList<Movies>();

        for(int i = 0; i < 30; i++){
            Movies movies = new Movies("movies"+i, "ipx"+i, R.drawable.jinx,"actor"+i,"分类"+i,"出版社"+i,"制作商"+i,"发行日期"+i,"时长"+i,"系列"+i);
            moviesList.add(movies);
        }
//        moviesList.add(new Movies("金克斯","ipx111",R.drawable.jinx));
//        moviesList.add(new Movies("自行车","ipx222",R.drawable.bike));
        movieAdapter = new MovieAdapter((LinkedList<Movies>)moviesList,mContext);
        listView_movie.setAdapter(movieAdapter);


        menu = (Button) findViewById(R.id.btn_menu);
        btn_category = (Button) findViewById(R.id.btn_category);
        btn_actor = (Button) findViewById(R.id.btn_actor);
//        email = (EditText) findViewById(R.id.email);
//        password = (EditText) findViewById(R.id.password) ;
    }

    private void initEvent() {

        btn_actor.setVisibility(View.INVISIBLE);
        btn_category.setVisibility(View.INVISIBLE);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread(){
                    public void run() {
                        try {
                            String context = Utils.getInstance().doGet("http://192.168.111.1:8082/api/test");
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    textView.setText(context);
                                }
                            });
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }.start();


            }
        });

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(flag == 0){
                    btn_category.setVisibility(View.VISIBLE);
                    btn_actor.setVisibility(View.VISIBLE);
                    flag = 1;
                }
                else{
                    btn_actor.setVisibility(View.INVISIBLE);
                    btn_category.setVisibility(View.INVISIBLE);
                    flag = 0;

                }

            }
        });

        btn_category.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this,CategoryActivity.class);
                startActivity(intent);
            }
        });

        btn_actor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this,ActorListActivity.class);
                startActivity(intent);
            }
        });


        listView_movie.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Movies movies = moviesList.get(i);
//                Bundle bundle = new Bundle();
//                bundle.putSerializable("movies",movies);
                Intent intent = new Intent(MainActivity.this,MovieActivity.class);
                intent.putExtra("movies",movies);
                startActivity(intent);

            }
        });
    }





}