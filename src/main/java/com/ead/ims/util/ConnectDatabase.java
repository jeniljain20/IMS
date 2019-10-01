package com.ead.ims.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.Logger;

public class ConnectDatabase {

	private static Logger log = Logger.getLogger(ConnectDatabase.class);
	private static Connection con = null;

	public static Connection createConnection() throws ClassNotFoundException, SQLException {
		try {
		System.out.println("Creating connection");
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost/ims", "root", "root");
		log.info("----Connection established with MYSQL database----");
		System.out.println("connection created");
		}catch(Exception e)
		{
			System.out.println("exception"+e);
		}
		return con;
	}
	public static void closeConnection() throws SQLException {
		log.info("----Connection closed with MYSQL database----");
		con.close();
	}
}
