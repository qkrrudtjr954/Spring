package com.example.wunderlist;

import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.example.wunderlist.dao.ConnectionMaker;
import com.example.wunderlist.dao.DConnectionMaker;
import com.example.wunderlist.dao.DaoFactory;
import com.example.wunderlist.dao.UserDao;
import com.example.wunderlist.model.User;

public class UserDaoTest {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub

		//annotation 을 사
		//ApplicationContext context = new AnnotationConfigApplicationContext(DaoFactory.class);
		
		//xml을 사
		ApplicationContext context = new GenericXmlApplicationContext("applicationContext.xml");
		
		UserDao dao3 = context.getBean("userDao", UserDao.class);
		UserDao dao4 = context.getBean("userDao", UserDao.class);
		UserDao dao = context.getBean("userDao", UserDao.class);
		
		
//		DaoFactory factory = new DaoFactory();
//		UserDao dao1 = factory.userDao();
//		UserDao dao2 = factory.userDao();
		
//		System.out.println(dao3);
//		System.out.println(dao4);
		
		User user = new User();
//		user.setId("white6");
//		user.setName("psk");
//		user.setPassword("pass");
//		dao.add(user);
//		
		User user2 = dao.get("white");
		System.out.println(user2.getId());
		System.out.println(user2.getName());
		System.out.println(user2.getPassword());

	}

}
