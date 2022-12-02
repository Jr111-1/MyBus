package com.example.mybus;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mybus.bean.Actor;
import com.example.mybus.bean.Category;
import com.example.mybus.bean.Movies;

import java.util.ArrayList;
import java.util.List;

public class ActorListActivity extends AppCompatActivity {

    RecyclerView recyclerView_actor;
    List<Actor> actorList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actor_list);

        recyclerView_actor = (RecyclerView) findViewById(R.id.recyclerview_actor);

        for(int i = 0; i < 50; i++){
            int a = R.drawable.jinx;
            String s = "演员" + i;
            String age ="年龄"+i;
            String birthday = "生日"+i;
            String cup = "cup" + i;
            String height = "身高"+i;
            String waist = "腰围"+i;
            String hipline = "臀围"+i;
            String bust = "胸围"+i;
            List<Movies> moviesList = new ArrayList<Movies>();
            for(int j = 0; j < 30; j++){
                Movies movies = new Movies("movies"+j, "ipx"+j, R.drawable.jinx,"actor"+j,"分类"+j,"出版社"+j,"制作商"+j,"发行日期"+j,"时长"+j,"系列"+j);
                moviesList.add(movies);
            }
            Actor actor = new Actor(a,s,age,birthday,cup,height,waist,hipline,bust,moviesList);
            actorList.add(actor);
        }

        ActorAdapter actorAdapter = new ActorAdapter();
        recyclerView_actor.setAdapter(actorAdapter);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(ActorListActivity.this,2);
        recyclerView_actor.setLayoutManager(gridLayoutManager);
        DividerItemDecoration mDivider = new
                DividerItemDecoration(this,DividerItemDecoration.VERTICAL);
        recyclerView_actor.addItemDecoration(mDivider);
    }


    class ActorViewHolder extends RecyclerView.ViewHolder {
        TextView actorName;
        ImageView actorPhoto;

        public ActorViewHolder(@NonNull View itemView) {
            super(itemView);
            actorPhoto = itemView.findViewById(R.id.image_actor);
            actorName = itemView.findViewById(R.id.tw_actorList_name);
        }
    }

    class ActorAdapter extends RecyclerView.Adapter<ActorViewHolder>{

        @NonNull
        @Override
        public ActorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = View.inflate(ActorListActivity.this,R.layout.actor_item,null);

            ActorViewHolder actorViewHolder = new ActorViewHolder(view);



            return actorViewHolder;
        }

        @Override
        public void onBindViewHolder(@NonNull ActorViewHolder holder, int position) {
            Actor actor = actorList.get(position);
            holder.actorPhoto.setBackgroundResource(actor.getPicture_actor());
            holder.actorName.setText(actor.getActorName());

            //点击转跳到演员界面
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent();
                    intent.setClass(ActorListActivity.this,ActorActivity.class);
                    intent.putExtra("actor",actor);
                    startActivity(intent);

                }
            });



        }

        @Override
        public int getItemCount() {
            return actorList.size();
        }
    }
}