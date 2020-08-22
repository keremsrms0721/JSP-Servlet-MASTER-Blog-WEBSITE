package com.blog.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtilities {
	
	private static final String database = "jdbc:mysql://localhost:3306/blog";
	private static final String username = "root";
	private static final String password = "";
	
	public static Connection getConnect() throws SQLException,ClassNotFoundException
	{
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection connect = DriverManager.getConnection(database,username,password);
		return connect;
	}

}
