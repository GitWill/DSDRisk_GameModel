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

    private TideItems tideItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FileIO io = new FileIO(getApplicationContext());
        tideItems = io.readFile();

        ArrayList<HashMap<String, String>> data = new ArrayList<HashMap<String, String>>();

        for (TideItem ti : tideItems){
            HashMap<String, String> map = new HashMap<>();
            //map.put("date", ti.getTideDateTimeFormatted());
            map.put("date", "There I go");
            map.put("hiLo", "Here I am");
            //map.put("hiLo", ti.getTideInfo());

            data.add(map);
        }

        SimpleAdapter adapter = new SimpleAdapter(this,
                data,
                R.layout.listview_items,
                new String []{"date","hiLo"},
                new int []{R.id.hiLoTextView, R.id.dateTextView}
                );
        ListView itemsListView = (ListView)findViewById(R.id.tidesListView);
        itemsListView.setAdapter(adapter);
        itemsListView.setOnItemClickListener(this);
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        TideItem item = tideItems.get(position);
        Toast.makeText(this,"I'm toasting",
                //"Low: " + item.getLowTemp() + "\r\n" +
                        //"High:" + item.getHighTemp(),
                Toast.LENGTH_LONG).show();
    }
}
