package com.player.dao.util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgresSqlConnection {

	private static Connection connection;
	
	private PostgresSqlConnection() {
		
	}
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName(DbUtilProps.DRIVER);
		String url = DbUtilProps.URL;
		String username = "postgres"; //System.getenv("postgresUserName");
		String password = "admin"; //System.getenv("postgresPassword");
//		System.out.println("username: " + System.getenv("postgresUserName"));
//		System.out.println("password: " + System.getenv("postgresPassword"));
		connection = DriverManager.getConnection(url, username, password);
		return connection;
	}
	
}
