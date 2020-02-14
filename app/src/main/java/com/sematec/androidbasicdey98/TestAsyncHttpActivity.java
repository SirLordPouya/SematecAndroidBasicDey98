package com.sematec.androidbasicdey98;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.sematec.androidbasicdey98.pray.PrayTime;

import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

public class TestAsyncHttpActivity extends AppCompatActivity {

    private static final String TAG = "TestAsyncHttpActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_async_http);

        String address = "https://api.aladhan.com/v1/timingsByCity?city=Dubai&country=United%20Arab%20Emirates&method=8";

        AsyncHttpClient client = new AsyncHttpClient();
        client.get(address, new JsonHttpResponseHandler() {

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                super.onSuccess(statusCode, headers, response);

                Gson gson = new Gson();
                PrayTime time = gson.fromJson(response.toString(),PrayTime.class);
                Log.d(TAG, "onSuccess: " + time.getData().getTimings().getAsr());
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                super.onFailure(statusCode, headers, throwable, errorResponse);
            }
        });
    }
}
