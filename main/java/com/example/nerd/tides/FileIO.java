package com.example.nerd.tides;

import java.io.InputStream;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import android.content.Context;
import android.util.Log;

/**
 * Created by nerd on 7/13/2017.
 */

public class FileIO {
    private final String FILENAME = "tides.xml";
    private Context context = null;

    public FileIO(Context context){ this.context = context; }  //constructor is passed a context which it assigns to local object

    public TideItems readFile(){
        try {
            // get the XML reader
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            XMLReader xmlreader = parser.getXMLReader();

            // set content handler
            ParseHandler handler = new ParseHandler();
            xmlreader.setContentHandler(handler);

            // read the file from internal storage
            InputStream in = context.getAssets().open(FILENAME);

            // parse the data
            InputSource is = new InputSource(in);
            xmlreader.parse(is);

            // set the feed in the activity
            TideItems items = handler.getItems();
            return items;
        }
        catch (Exception e) {
            Log.e("Tide reader", e.toString());
            return null;
        }
    }
}






