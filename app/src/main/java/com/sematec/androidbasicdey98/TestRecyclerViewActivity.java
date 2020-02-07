package com.sematec.androidbasicdey98;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TestRecyclerViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_recycler_view);


        ArrayList<PersonClass> names = new ArrayList();
        names.add(new PersonClass("Pouya", "Heydari", 1L, "09121234567", R.mipmap.ic_launcher));
        names.add(new PersonClass("Erfan   ", "Akhavan   ", 2L, "09121234567", R.mipmap.ic_launcher));
        names.add(new PersonClass("Hamid   ", "Allahyari ", 3L, "09121234567", R.mipmap.ic_launcher));
        names.add(new PersonClass("Homayoun", "Bolandian ", 4L, "09121234567", R.mipmap.ic_launcher));
        names.add(new PersonClass("Pouya   ", "Dehkordi  ", 5L, "09121234567", R.mipmap.ic_launcher));
        names.add(new PersonClass("Zahra   ", "Zolfaghari", 6L, "12231213312", R.mipmap.ic_launcher));
        names.add(new PersonClass("Masoumeh", "Rahimi    ", 7L, "12231213312", R.mipmap.ic_launcher));
        names.add(new PersonClass("Keyvan  ", "Ramezan   ", 8L, "12231213312", R.mipmap.ic_launcher));
        names.add(new PersonClass("Morteza ", "Roudbari  ", 9L, "12231213312", R.mipmap.ic_launcher));
        names.add(new PersonClass("Sam     ", "Shams     ", 10L, "12231213312", R.mipmap.ic_launcher));
        names.add(new PersonClass("Akram   ", "Mosharefi ", 11L, "12231213312", R.mipmap.ic_launcher));
        names.add(new PersonClass("Vahid   ", "Malek     ", 12L, "12231213312", R.mipmap.ic_launcher));


        RecyclerView recycler = findViewById(R.id.recycler);


        //adapter
        TestAdapter adapter = new TestAdapter(names);

        recycler.setAdapter(adapter);

        recycler.setLayoutManager(new LinearLayoutManager(TestRecyclerViewActivity.this, RecyclerView.VERTICAL, false));


    }
}
