package com.generic.FileUtility;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonUtility {
	public  String getDataFromJsonFile(String key) throws IOException, ParseException
	{
	
     JSONParser parser=new JSONParser();
     Object obj = parser.parse(new FileReader("./configData.practice_json.json"));
     JSONObject map=(JSONObject)obj;
     String data=map.get(key).toString();
     return data;
     
	
	}

}
