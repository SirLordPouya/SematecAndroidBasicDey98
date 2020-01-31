package com.sematec.androidbasicdey98;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnSave = findViewById(R.id.btnSave);
        ImageView imgProfile = findViewById(R.id.imgProfile);
        final EditText edtAge = findViewById(R.id.edtAge);


        btnSave.setText("SAVE1");


        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String age = edtAge.getText().toString();
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("AGE",age);
                startActivity(intent);
            }
        });


        imgProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Some text", Toast.LENGTH_LONG).show();
            }
        });


    }

}
