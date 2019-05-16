package com.uiresource.cookit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import com.uiresource.cookit.Database.*;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class TestActivity extends AppCompatActivity {

    private OkHttpClient okHttpClient;
    private Request request;
    private String URL = "https://surviveonsotka20190514062215.azurewebsites.net/api/Account/GetList";
    private static final String TAG = "MainActivity";
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        textView  = (TextView) findViewById(R.id.textViewTestTextView);
        okHttpClient = new OkHttpClient();

        request = new Request.Builder().url(URL).build();

        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                //Log.i(TAG,e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()){
                    final String myResponse = response.body().string();

                    TestActivity.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {

                            textView.setText(myResponse);

                            GsonBuilder builder = new GsonBuilder();
                            Gson gson = builder.create();
                            AccountList acc = gson.fromJson(myResponse, AccountList.class);
                            Log.i("GSON", "Имя: " + acc.userName + "\nID: " + acc.id + " \n");
                        }
                    });
                }
                //Log.i(TAG,response.body().string());
                //v = response.body().string();
            }
        });

        //textView.setText(v);
    }
}
