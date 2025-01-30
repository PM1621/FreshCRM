package com.generic.FileUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtility {
public String getDataFromPropertyFile(String key) throws IOException 
{
	FileInputStream fis=new FileInputStream("./configData/commonData.properties");
	Properties pobj=new Properties();
	pobj.load(fis);
	String data=pobj.get(key).toString();
	return data;
}
	
}
