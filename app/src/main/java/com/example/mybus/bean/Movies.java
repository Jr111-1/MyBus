package com.example.mybus.bean;

import java.io.Serializable;
import java.util.ArrayList;

public class Movies implements Serializable {

    public String movie_name;
    public String noId;
    public int image;
    public String actor_name_movie;
    public String category;
    public String publisher;
    public String producer;
    public String movie_date;
    public String duration;
    public String series;
    public ArrayList<String> maginetic;
    public ArrayList<Integer> movie_pictures;


    public Movies(String movie_name, String noId, int image) {
        this.movie_name = movie_name;
        this.noId = noId;
        this.image = image;
    }

    public Movies(String movie_name, String noId, int image, String actor_name_movie, String category, String publisher, String producer, String movie_date, String duration, String series) {
        this.movie_name = movie_name;
        this.noId = noId;
        this.image = image;
        this.actor_name_movie = actor_name_movie;
        this.category = category;
        this.publisher = publisher;
        this.producer = producer;
        this.movie_date = movie_date;
        this.duration = duration;
        this.series = series;
    }

    public ArrayList<String> getMaginetic() {
        return maginetic;
    }

    public void setMaginetic(ArrayList<String> maginetic) {
        this.maginetic = maginetic;
    }

    public ArrayList<Integer> getMovie_pictures() {
        return movie_pictures;
    }

    public void setMovie_pictures(ArrayList<Integer> movie_pictures) {
        this.movie_pictures = movie_pictures;
    }

    public String getActor_name_movie() {
        return actor_name_movie;
    }

    public void setActor_name_movie(String actor_name_movie) {
        this.actor_name_movie = actor_name_movie;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getMovie_date() {
        return movie_date;
    }

    public void setMovie_date(String movie_date) {
        this.movie_date = movie_date;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getNoId() {
        return noId;
    }

    public void setNoId(String noId) {
        this.noId = noId;
    }

    public String getMovie_name() {
        return movie_name;
    }

    public void setMovie_name(String movie_name) {
        this.movie_name = movie_name;
    }




}
