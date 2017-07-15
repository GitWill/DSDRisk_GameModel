package com.example.nerd.tides;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;

/**
 * Created by nerd on 7/13/2017.
 */

public class TideItem {
    private String date = null;
    private String day = null;
    private String time = null;
    private String pred = null;
    private String hiLo = null;
    private String myStrToRename = null;


    //this is the format used in the tide XML file
    private SimpleDateFormat dateInFormat =
            new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");

    // This is the format we want in our output
    private SimpleDateFormat dateOutFormat =
            new SimpleDateFormat("EEEE', ' MMM d");

    public String getTideDateTimeFormatted() {
        try {
            Date myDate = dateInFormat.parse(date.trim());
            String forecastDateFormatted = dateOutFormat.format(myDate);
            return forecastDateFormatted;
        }
        catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public String getTideInfo(){
        myStrToRename = hiLo;
        return myStrToRename;
/*
        2016/01/01 Tuesday
        High: 02:44 PM
        2016/01/01 Tuesday
        Low: 09:33 PM
*/
    }

    public void setDate(String dateIn){ date = dateIn; }

    public void setDay(String dayIn){ day = dayIn; }

    public void setTime(String timeIn){ time = timeIn; }

    public void setPred(String predIn){pred = predIn;}

    public void setHiLo(String hiLoIn){hiLo = hiLoIn;}



}
