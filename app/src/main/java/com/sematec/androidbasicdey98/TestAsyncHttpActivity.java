package com.sematec.androidbasicdey98;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.sematec.androidbasicdey98.pray.PrayTime;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.Header;

public class TestAsyncHttpActivity extends AppCompatActivity {

    private static final String TAG = "TestAsyncHttpActivity";

    List<String> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_async_http);


        final RecyclerView recycler = findViewById(R.id.recycler);


        String address = "https://api.aladhan.com/v1/timingsByCity?city=Dubai&country=United%20Arab%20Emirates&method=8";

        AsyncHttpClient client = new AsyncHttpClient();
        client.get(address, new JsonHttpResponseHandler() {

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                super.onSuccess(statusCode, headers, response);

                Gson gson = new Gson();
                PrayTime time = gson.fromJson(response.toString(), PrayTime.class);
                list.add("Fajr: " + time.getData().getTimings().getFajr());
                list.add("Sunrise: " + time.getData().getTimings().getSunrise());
                list.add("Dhuhr: " + time.getData().getTimings().getDhuhr());
                list.add("Asr: " + time.getData().getTimings().getAsr());
                list.add("Sunset: " + time.getData().getTimings().getSunset());
                list.add("Maghrib: " + time.getData().getTimings().getMaghrib());
                list.add("Isha: " + time.getData().getTimings().getIsha());
                list.add("Midnight: " + time.getData().getTimings().getMidnight());
                list.add("Imsak: " + time.getData().getTimings().getImsak());

                PrayRecyclerAdapter adapter = new PrayRecyclerAdapter(list);
                recycler.setAdapter(adapter);
                recycler.setLayoutManager(new LinearLayoutManager(TestAsyncHttpActivity.this, RecyclerView.VERTICAL, false));
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                super.onFailure(statusCode, headers, throwable, errorResponse);
            }
        });
    }
}
