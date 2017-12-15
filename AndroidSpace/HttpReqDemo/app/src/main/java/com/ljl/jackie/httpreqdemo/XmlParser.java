package com.ljl.jackie.httpreqdemo;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/**
 * Created by Jackie on 2017/3/14.
 */

public class XmlParser {
    public  static List<Person> parse(InputStream is){
        List<Person> persons = new ArrayList<>();
        try{
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            PersonHandler personHandler = new PersonHandler();
            parser.parse(is, personHandler);
            persons = personHandler.getPersons();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return persons;
    }

    static class PersonHandler extends DefaultHandler{
        private List<Person> persons;
        private Person temp;
        private StringBuffer sb;

        public  List<Person> getPersons(){
            return persons;
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            super.characters(ch, start, length);
            sb.append(ch,start,length);
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            super.startElement(uri, localName, qName, attributes);
            sb.setLength(0);
            if(localName.equals("person")){
                temp = new Person();
                int length = attributes.getLength();
                for(int i = 0; i < length; ++i){
                    String name = attributes.getLocalName(i);
                    if(name.equals("id")){
                        String value = attributes.getValue(i);
                        temp.setId(value);
                    }
                }
            }
        }

        @Override
        public void startDocument() throws SAXException {
            super.startDocument();
            persons = new ArrayList<>();
            sb = new StringBuffer();
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            super.endElement(uri, localName, qName);
            if(localName.equals("name")){
                String name = sb.toString();
                temp.setName(name);
            }else if(localName.equals("age")){
                int age = Integer.parseInt(sb.toString());
                temp.setAge(age);
            }else if(localName.equals("person")){
                persons.add(temp);
            }
        }
    }
}
