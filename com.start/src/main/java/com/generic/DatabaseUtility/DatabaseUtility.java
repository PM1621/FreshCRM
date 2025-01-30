package com.generic.DatabaseUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class DatabaseUtility {
	static Connection conn;
	public void createDBConnection(String url,String username,String pwd) throws SQLException
	{
		try
		{
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		
		conn=DriverManager.getConnection(url,username,pwd);
		}
		catch(Exception e)
		{
			
		}
	}
	
	public void closeDBConnection() throws SQLException
	{
		conn.close();
	}
	
	public ResultSet executeSelectQuery(String query)
	{
		ResultSet resultset=null;;
		try {
			Statement stat=conn.createStatement();
			resultset = stat.executeQuery(query);
			
			
		}
		catch(Exception e)
		{
			
		}
		return resultset;
	}
	
	public void executeNonselectQuery(String query)
	{
		int result=0;
		try
		{
			Statement stat=conn.createStatement();
			        result =stat.executeUpdate(query);
		}
		catch(Exception e)
		{
			
		}
	}

}
