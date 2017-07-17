package com.example.nerd.tides_v2;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class FirstActivity extends AppCompatActivity
        implements AdapterView.OnItemClickListener, AdapterView.OnItemSelectedListener {
    //get references to widgets
    private Spinner locationSpinner;
    private Spinner dateSpinner;
    Cursor cursor = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        locationSpinner=(Spinner) findViewById(R.id.locationSpinner);
        dateSpinner=(Spinner) findViewById(R.id.dateSpinner);
        locationSpinner.setOnItemSelectedListener(this);
        dateSpinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
       /* cursor.moveToPosition(position);
        int dayPrecip = cursor.getInt(cursor.getColumnIndex(DAY_PRECIP));
        int nightPrecip = cursor.getInt(cursor.getColumnIndex(NIGHT_PRECIP));
        //WeatherItem item = weatherItems.get(position);
        Toast.makeText(this,
                "Daytime chance of precipitation: " + Integer.toString(dayPrecip) + "%" + "\r\n" +
                        "Nighttime chance of preciptiation: " + Integer.toString(nightPrecip) + "%",
                Toast.LENGTH_LONG).show();
                */
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position,
                               long id) {/*
        switch (position){
            case 0:
                locationSelection = "97405";
                break;
            case 1:
                locationSelection = "97439";
                break;
            case 2:
                locationSelection = "99515";
        }
        // Get a weather forecast the selected location
        cursor = dal.getForcastByLocation(locationSelection);
        adapter.changeCursor(cursor);*/
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        // TODO Auto-generated method stub
    }

    public void showTides(){



        String dateString = locationSpinner.getSelectedItem().toString();
        String locationString = dateSpinner.getSelectedItem().toString();

        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("location", locationString);  // send state to 2nd activity
        intent.putExtra("date", dateString);  // send state to 2nd activity
        startActivity(intent);
    }
}
