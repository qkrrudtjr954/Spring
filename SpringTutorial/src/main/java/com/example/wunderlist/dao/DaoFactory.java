package com.example.wunderlist.dao;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

@Configuration
public class DaoFactory {
	@Bean
	public UserDao userDao(){
		UserDao dao = new UserDao();
		//dao.setConnectionMaker(connectionMaker());
		dao.setDataSource(dataSource());
		return dao;
	}
	@Bean
	public ConnectionMaker connectionMaker() {
		ConnectionMaker connectionMaker = new DConnectionMaker();
		return connectionMaker;
	}
	@Bean
	public DataSource dataSource() {
		SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
		
		dataSource.setDriverClass(com.mysql.jdbc.Driver.class);
		dataSource.setUrl("jdbc:mysql://localhost/testDB");
		dataSource.setUsername("root");
		dataSource.setPassword("");
		
		return dataSource;
	}
	
}
