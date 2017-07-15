package com.example.nerd.tides;

/**
 * Created by nerd on 7/13/2017.
 */


import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.*;

public class ParseHandler extends DefaultHandler {
    private TideItems tideItems;
    private TideItem item;

    private boolean isDate = false;
    private boolean isDay = false;
    private boolean isTIme = false;
    private boolean isPred = false;
    private boolean isHighLow = false;


    public TideItems getItems() {
        return tideItems;
    }

    @Override
    public void startDocument() throws SAXException {
        tideItems = new TideItems();
        item = new TideItem();
    }

    @Override
    public void startElement(String namespaceURI, String localName,
                             String qName, Attributes atts) throws SAXException {

        if (qName.equals("item")) {
            item = new TideItem();
            return;
        }
        else if (qName.equals("date")) {
            isDate = true;
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
        if (qName.equals("item")) {
            tideItems.add(item);
        }
        return;
    }

    @Override
    public void characters(char ch[], int start, int length)
    {
        String s = new String(ch, start, length);
        if (isDate) {
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

