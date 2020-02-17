package com.lel.Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {
	private static String dbUrl = "jdbc:mysql://localhost:3306/userlogin?useUnicode=true&characterEncoding=UTF-8";
	private static String dbUser = "root";
	private static String dbPassword = "123456";
	private static String dbDriver = "com.mysql.jdbc.Driver";
	private static Connection connection;
	
		public static Connection getConnection() {
			try {
				Class.forName(dbDriver);
				connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return connection;
		}
}
