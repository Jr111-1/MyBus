package com.example.mybus;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mybus.bean.Actor;
import com.example.mybus.bean.Category;

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
            Actor actor = new Actor(a,s);
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

        }

        @Override
        public int getItemCount() {
            return actorList.size();
        }
    }
}