package com.example.nerd.midtownmma;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by nerd on 7/16/2017.
 */

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_second);
        //Log.d(WILLS, "in second activity OnCreate");
        String cost = getIntent().getStringExtra("cost");
        int buttonID = getIntent().getIntExtra("buttonID", -1);
        //get the names that the first fragment's button handler sent
        //String p1n = getIntent().getStringExtra("p1Name");
        //String p2n = getIntent().getStringExtra("p2Name");
        // The toast is just for testing
        //Toast.makeText(this, "SecondActivity: with " + p1n + "and " + p2n, Toast.LENGTH_SHORT).show();
        //myGame = new PigGame(this, p1n, p2n);

        // Send the message to the fragment
        SecondFragment secondFragment =
                (SecondFragment) getFragmentManager().findFragmentById(R.id.second_fragment);
        //secondFragment.setImg();
        secondFragment.setInfo(buttonID, cost);


    }
}
