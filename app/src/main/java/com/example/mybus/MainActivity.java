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

import com.example.mybus.databinding.ActivityMainBinding;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;


public class MainActivity extends AppCompatActivity {

    private Button login;
    private EditText email;
    private EditText password;
    private ActivityMainBinding binding;
    private final OkHttpClient client = new OkHttpClient();
    private final ObjectMapper mapper = new ObjectMapper();
    private int signInId = 0;
    private final Handler handler = new Handler(Looper.getMainLooper());
    private static final MediaType mediaType = MediaType.parse("application/json;charset=utf-8");
    private final Message message = new Message();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        login = (Button) findViewById(R.id.login);
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password) ;
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            try{
                String emails = binding.email.getText().toString();
                String passWord = binding.password.getText().toString();
                Request request = new Request.Builder().url(NetWorkSettings.SIGN_IN_UP).post(
                        RequestBody.create(mapper.writeValueAsString(new User(emails, passWord)), mediaType)
                ).build();
                client.newCall(request).enqueue(new Callback() {
                    @Override
                    public void onFailure(@NonNull Call call, @NonNull IOException e) {
                        message.what = ResponseCode.REQUEST_FAILED;
                        handler.post(() -> Utils.showMessage(getApplicationContext(), message));
                        e.printStackTrace();
                    }

                    @Override
                    public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                        if (response.isSuccessful()) {
                            ResponseBody body = response.body();
                            if (body != null) {
                                RestResponse restResponse = mapper.readValue(body.string(), RestResponse.class);
                                message.what = restResponse.getCode();
                                if (message.what == ResponseCode.SIGN_IN_SUCCESS) {
                                    handler.post(() -> {
                                        signInId = (int) restResponse.getData();
                                        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                                        startActivity(intent);
                                    });
                                } else {
                                    message.what = ResponseCode.REQUEST_FAILED;
                                    Log.e("SERVER_ERROR", response.message());
                                }
                            } else {
                                message.what = ResponseCode.SERVER_ERROR;
                                Log.e("SERVER_ERROR", response.message());
                            }
                            handler.post(() -> Utils.showMessage(getApplicationContext(), message));

                        }
                    }
                });
            }catch (
            JsonProcessingException e) {
                message.what = ResponseCode.JSON_SERIALIZATION;
                Utils.showMessage(getApplicationContext(),message);
                e.printStackTrace();
            }

            }
        });
    }


}