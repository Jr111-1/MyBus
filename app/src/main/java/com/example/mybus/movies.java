package com.example.mybus;

public class movies {

    public String movie_name;
    public String noId;
    public int image;

    public movies(String movie_name, String noId, int image) {
        this.movie_name = movie_name;
        this.noId = noId;
        this.image = image;
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
