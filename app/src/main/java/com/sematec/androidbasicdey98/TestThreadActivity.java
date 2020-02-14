package com.sematec.androidbasicdey98;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

public class TestThreadActivity extends AppCompatActivity {

    private static final String TAG = "TestThreadActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_thread);

        String threadName = Thread.currentThread().getName();
        Log.d(TAG, threadName);

        //io
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                String threadNameNew = Thread.currentThread().getName();
                Log.d(TAG, "run: " + threadNameNew);
            }
        });

        thread.start();
    }
}
