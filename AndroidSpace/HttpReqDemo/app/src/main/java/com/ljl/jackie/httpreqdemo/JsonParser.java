package com.ljl.jackie.httpreqdemo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jackie on 2017/3/14.
 */

public class JsonParser {
    public static List<Person> parse(String jsonString){
        List<Person> persons = new ArrayList<>();
        try{
            JSONObject jsonObject = new JSONObject(jsonString);
            JSONArray jsonArray = jsonObject.getJSONArray("persons");
            int length = jsonArray.length();
            for(int i = 0; i < length; ++i){
                JSONObject personObject = jsonArray.getJSONObject(i);
                String id = personObject.getString("id");
                String name = personObject.getString("name");
                int age = personObject.getInt("age");
                Person person = new Person();
                person.setId(id);
                person.setName(name);
                person.setAge(age);
                persons.add(person);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return persons;
    }
}
