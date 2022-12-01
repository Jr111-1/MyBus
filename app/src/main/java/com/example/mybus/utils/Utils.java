package com.example.mybus.utils;


import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Utils {
    private Utils(){};
    private static Utils instance = new Utils();
    private OkHttpClient okHttpClient = new OkHttpClient();
    public static Utils getInstance(){
        return instance;
    }

    public String doGet(String url) throws Exception{
        Request request = new Request.Builder().url(url).build();
        Call call = okHttpClient.newCall(request);
        Response response = call.execute();
        return  response.body().string();
    }

}