package com.sematec.androidbasicdey98;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class TestMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_menu);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);

        menu.add(0, 1, 1, "Java Item");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.firstItem:
                Toast.makeText(TestMenuActivity.this, "First Item clicked!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.secondItem:
                Toast.makeText(TestMenuActivity.this, "Second Item clicked!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.thirdItem:
                Toast.makeText(TestMenuActivity.this, "Third Item clicked!", Toast.LENGTH_SHORT).show();
                break;
            case 1:
                Toast.makeText(TestMenuActivity.this, "Java Item clicked!", Toast.LENGTH_SHORT).show();
                break;

        }
        return super.onOptionsItemSelected(item);
    }
}
