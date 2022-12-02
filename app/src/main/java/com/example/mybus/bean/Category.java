package com.example.mybus.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Category implements Serializable {

    public String CategotyName;

    public List<Movies> category_movieList = new ArrayList<Movies>();

    public Category(String categotyName, List<Movies> category_movieList) {
        CategotyName = categotyName;
        this.category_movieList = category_movieList;
    }

    public Category() {
    }

    public List<Movies> getCategory_movieList() {
        return category_movieList;
    }

    public void setCategory_movieList(List<Movies> category_movieList) {
        this.category_movieList = category_movieList;
    }

    public String getCategotyName() {
        return CategotyName;
    }

    public void setCategotyName(String categotyName) {
        CategotyName = categotyName;
    }
}
