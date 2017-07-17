package com.example.nerd.tides_v2;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

/**
 * Created by nerd on 7/15/2017.
 */

public class SecondActivity extends AppCompatActivity{
    private String location;
    private String date;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        String location = getIntent().getStringExtra("location");
        String date = getIntent().getStringExtra("date");

        //The toast is just for testing
        Toast.makeText(this, "SecondActivity: with " + location + "and " + date, Toast.LENGTH_SHORT).show();
        //myGame = new PigGame(this, p1n, p2n);

    }
}
