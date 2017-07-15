package com.example.nerd.tides;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;

/**
 * Created by nerd on 7/13/2017.
 */

public class TideItem {
    private String date = null;         //TideItem instance vars
    private String day = null;          //used to store information about a single item
    private String time = null;
    private String pred = null;
    private String hiLo = null;
    private String tideInfo = null;
    private String dateInfo = null;


    //class accessors
    public String getTideDateTimeFormatted() {      //format the date and day for the listview (top item)
        dateInfo = date + "   " + day;
        return dateInfo;
    }

    public String getTideInfo(){                    //format the tide info for the listview (bottom item)
        if(hiLo.equals("H"))
            tideInfo = "High:   " + time;
        else
            tideInfo = "Low: " + time;
        return tideInfo;
    }

    public String getPred(){
        return pred;
    }

    public String getMetric(){                      //convert to metric, 1 foot = .3048
        double standard = Double.parseDouble(pred);
        double metric = (standard * 30.48);
        int metRounded = (int) metric;
        String met = Integer.toString(metRounded) + " cm";
        return met;
    }


    //class mutators
    public void setDate(String dateIn){ date = dateIn; }

    public void setDay(String dayIn){ day = dayIn; }

    public void setTime(String timeIn){ time = timeIn; }

    public void setPred(String predIn){pred = predIn;}

    public void setHiLo(String hiLoIn){hiLo = hiLoIn;}



}
