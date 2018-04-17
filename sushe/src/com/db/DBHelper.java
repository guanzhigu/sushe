package com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHelper {
	private String dbUrl = "jdbc:mysql://localhost:3306/sushe";
	private String dbUser = "root";
	private String dbPassword = "root";
	private String jdbcName = "com.mysql.jdbc.Driver";
	
	//�B�Ӕ�����
	public Connection getConn()	{
		Connection conn = null;
		try{
			Class.forName(jdbcName);
		}catch(Exception e){
			e.printStackTrace();
		}
		try{
			conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
			System.out.println("���ӳɹ�!");
		}catch(SQLException ex){
			ex.printStackTrace();
		}
		return conn;
	}
	
	//����
	public static void main(String[] args){
		System.out.println(new DBHelper().getConn());
	}
}
