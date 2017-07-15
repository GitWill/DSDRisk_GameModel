package com.example.nerd.tides;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends Activity implements AdapterView.OnItemClickListener {

    private TideItems tideItems;        //create a tide item list

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);                         //set the layout

        FileIO io = new FileIO(getApplicationContext());                //create an IO object
        tideItems = io.readFile();                                      //get tide items which are returned from ParseHandler via FileIO

        ArrayList<HashMap<String, String>> data = new ArrayList<HashMap<String, String>>();     //make my list of hashmaps which map a string to another string

        for (TideItem ti : tideItems){                                      //for each tide item
            HashMap<String, String> map = new HashMap<>();                  //create a hashmap
            map.put("date", ti.getTideDateTimeFormatted());                 //and add the elements we want into a map
            map.put("hiLo", ti.getTideInfo());

            data.add(map);                                                  //add the map to the list
        }

        SimpleAdapter adapter = new SimpleAdapter(this,                     //create a simple adapter
                data,                                                       //with the list
                R.layout.listview_items,                                    //the layout for the single row
                new String []{"hiLo","date"},                               //put the two pieces of info in an array
                new int []{R.id.hiLoTextView, R.id.dateTextView}            //put references to the textviews into an array
                );                                                          //which will then correspond to the string array
        ListView itemsListView = (ListView)findViewById(R.id.tidesListView);//get a reference to the layout with all of the rows
        itemsListView.setAdapter(adapter);                                  //set the adapter to work with the layout
        itemsListView.setOnItemClickListener(this);                         //set a listener for toasting(for now)
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        TideItem item = tideItems.get(position);                            //get a reference to the item clicked
        Toast.makeText(this, item.getPred() + " feet. " + item.getMetric(), //formatted toast
                Toast.LENGTH_SHORT).show();
    }
}
