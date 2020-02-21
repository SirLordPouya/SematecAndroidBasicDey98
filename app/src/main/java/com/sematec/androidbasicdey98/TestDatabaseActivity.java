package com.sematec.androidbasicdey98;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class TestDatabaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_database);
        final EditText edtName = findViewById(R.id.edtName);
        final EditText edtFamily = findViewById(R.id.edtFamily);
        final EditText edtGrade = findViewById(R.id.edtGrade);
        Button btnSave = findViewById(R.id.btnSave);
        Button btnShow = findViewById(R.id.btnShow);


        final TestDataBase db = new TestDataBase(TestDatabaseActivity.this, "Sematec", null, 1);



        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = edtName.getText().toString();
                String family = edtFamily.getText().toString();
                String grade = edtGrade.getText().toString();

                db.insertStudent(name, family, Integer.parseInt(grade));
            }
        });


        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String names = db.getAllStudentsName();
                Toast.makeText(TestDatabaseActivity.this, names, Toast.LENGTH_LONG).show();
            }
        });
    }
}
