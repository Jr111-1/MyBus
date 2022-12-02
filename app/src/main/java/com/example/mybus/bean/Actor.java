package com.example.mybus.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Actor implements Serializable {

    public int picture_actor;
    public String ActorName;
    public String age;
    public String birthday;
    public String cup;
    public String height;
    public String waist;
    public String hipline;
    public String bust;
    public List<Movies> actorMovieList = new ArrayList<Movies>();

    public Actor(int picture_actor, String actorName) {
        this.picture_actor = picture_actor;
        this.ActorName = actorName;
    }

    public Actor(int picture_actor, String actorName, String age, String birthday, String cup, String height, String waist, String hipline, String bust, List<Movies> actorMovieList) {
        this.picture_actor = picture_actor;
        ActorName = actorName;
        this.age = age;
        this.birthday = birthday;
        this.cup = cup;
        this.height = height;
        this.waist = waist;
        this.hipline = hipline;
        this.bust = bust;
        this.actorMovieList = actorMovieList;
    }

    public List<Movies> getActorMovieList() {
        return actorMovieList;
    }

    public void setActorMovieList(List<Movies> actorMovieList) {
        this.actorMovieList = actorMovieList;
    }

    public int getPicture_actor() {
        return picture_actor;
    }

    public void setPicture_actor(int picture_actor) {
        this.picture_actor = picture_actor;
    }

    public String getActorName() {
        return ActorName;
    }

    public void setActorName(String actorName) {
        ActorName = actorName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getCup() {
        return cup;
    }

    public void setCup(String cup) {
        this.cup = cup;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWaist() {
        return waist;
    }

    public void setWaist(String waist) {
        this.waist = waist;
    }

    public String getHipline() {
        return hipline;
    }

    public void setHipline(String hipline) {
        this.hipline = hipline;
    }

    public String getBust() {
        return bust;
    }

    public void setBust(String bust) {
        this.bust = bust;
    }
}
