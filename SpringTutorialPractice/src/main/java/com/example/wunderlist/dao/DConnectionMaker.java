package com.example.wunderlist.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.runner.JUnitCore;


public class DConnectionMaker implements ConnectionMaker{

	@Override
	public Connection makeConnection() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.jdbc.Driver");
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost/testDB", "root", "");
		
		return c;
	}
	public static void main(String[] args) {
		System.out.println("test beginning...");
		JUnitCore.main("com.example.wunderlist.UserDaoTest");
	}
}
