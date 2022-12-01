package com.example.mybus.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mybus.R;
import com.example.mybus.bean.movies;

import java.util.List;

public class MovieAdapter extends BaseAdapter {

    private List<movies> moviesList;
    private Context mContext;

    public MovieAdapter(List<movies> moviesList,Context mContext){
        this.moviesList = moviesList;
        this.mContext = mContext;

    }

    public void setMovies(List<movies> moviesList){
        this.moviesList = moviesList;
    }
    public List<movies> getMoviesList(){
        return moviesList;
    }

    @Override
    public int getCount() {
        return moviesList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = LayoutInflater.from(mContext).inflate(R.layout.movie_item,viewGroup,false);
        ImageView img_movie = (ImageView) view.findViewById(R.id.moviephoto_title);
        TextView txt_movie_name = (TextView) view.findViewById(R.id.movie_name);
        TextView txt_movie_noId = (TextView) view.findViewById(R.id.no_id);
        img_movie.setBackgroundResource(moviesList.get(i).getImage());
        return view;
    }
}
