package com.example.nerd.tides_v2;

/**
 * Created by nerd on 7/15/2017.
 */


import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.*;

public class ParseHandler extends DefaultHandler {
    private TideItems tideItems;            //instance vars for ParseHandler class
    private TideItem item;
    private boolean isDate = false;         //these bools will help decide which key tags we find in the xml
    private boolean isDay = false;
    private boolean isTIme = false;
    private boolean isPred = false;
    private boolean isHighLow = false;

    public TideItems getItems() {
        return tideItems;
    }   //gives FileIO access to the items

    @Override
    public void startDocument() throws SAXException {
        tideItems = new TideItems();                    //get reference to tide items
        item = new TideItem();                          //and a single tide item
    }

    @Override
    public void startElement(String namespaceURI, String localName,
                             String qName, Attributes atts) throws SAXException {

        if (qName.equals("item")) {         //look for my key works in the xml
            item = new TideItem();          //if I find an item tag, make a new item
            return;
        }
        else if (qName.equals("date")) {    //else if I find any of my other keywords
            isDate = true;                  //remember which keyword it is
            return;
        }
        else if (qName.equals("day")) {
            isDay = true;
            return;
        }
        else if (qName.equals("time")) {
            isTIme = true;
            return;
        }
        else if (qName.equals("pred")) {
            isPred = true;
            return;
        }
        else if (qName.equals("highlow")) {
            isHighLow = true;
            return;
        }
    }

    @Override
    public void endElement(String namespaceURI, String localName,
                           String qName) throws SAXException
    {
        if (qName.equals("item")) {         //if we reach the end of an item in the list,
            tideItems.add(item);            //add it to the list of items
        }
        return;
    }

    @Override
    public void characters(char ch[], int start, int length)
    {
        String s = new String(ch, start, length);       //set the single items data
        if (isDate) {                                   //according to which key tag word we found
            item.setDate(s);
            isDate = false;
        }
        else if(isDay){
            item.setDay(s);
            isDay = false;
        }
        else if (isTIme) {
            item.setTime(s);
            isTIme = false;
        }
        else if (isPred){
            item.setPred(s);
            isPred = false;
        }
        else if (isHighLow) {
            item.setHiLo(s);
            isHighLow = false;
        }
    }
}


