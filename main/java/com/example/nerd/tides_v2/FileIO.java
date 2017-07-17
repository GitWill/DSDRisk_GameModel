package com.example.nerd.tides_v2;

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
    private final String FILENAME = "tides.xml";            //get reference to input file name
    private Context context = null;                         //get reference for context to be set

    public FileIO(Context context){ this.context = context; }  //constructor is passed a context which it assigns to local object

    public TideItems readFile(){
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();  //get a reference to a SAXParserFactory obj
            SAXParser parser = factory.newSAXParser();                  //get a reference to a SAXParser
            XMLReader xmlreader = parser.getXMLReader();                //get the parsers XML reader

            ParseHandler handler = new ParseHandler();                  //create a ParseHandler for the XMLReader
            xmlreader.setContentHandler(handler);                       //assign the handler to the reader

            InputStream inFIle = context.getAssets().open(FILENAME);        //get reference to the input file

            InputSource inputSrc = new InputSource(inFIle);
            xmlreader.parse(inputSrc);                                      //parse the XML file

            TideItems items = handler.getItems();                           //get the parsed items
            return items;
        }
        catch (Exception e) {
            Log.e("Tide reader", e.toString());
            return null;
        }
    }
}

