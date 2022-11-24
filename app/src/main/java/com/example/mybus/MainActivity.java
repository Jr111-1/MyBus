package com.example.mybus;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.service.autofill.OnClickAction;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mybus.databinding.ActivityMainBinding;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;


public class MainActivity extends AppCompatActivity {
    public static final String LoginUrl = "http://192.168.111.1:8082/api/user";

    private Button login;
    private Handler handler = new Handler(Looper.getMainLooper());
    private TextView textView;
    private EditText email;
    private EditText password;
    private ActivityMainBinding binding;
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

    private void initEvent() {
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
    }

    private void initView() {
        login = (Button) findViewById(R.id.login);
        textView = (TextView) findViewById(R.id.tw_tw);
//        email = (EditText) findViewById(R.id.email);
//        password = (EditText) findViewById(R.id.password) ;
    }



}