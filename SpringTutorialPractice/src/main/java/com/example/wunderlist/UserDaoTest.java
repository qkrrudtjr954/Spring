package com.example.wunderlist;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

import java.sql.SQLException;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.example.wunderlist.dao.UserDao;
import com.example.wunderlist.model.User;

public class UserDaoTest {
	@Test
	public void addAndGet() throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		
//		//userDao를 두번 생성함. dao1 and dao2는 다른 오브젝트.
//		DaoFactory factory = new DaoFactory();
//		UserDao dao1 = factory.userDao();
//		UserDao dao2 = factory.userDao();
//		
//		System.out.println(dao1);
//		System.out.println(dao2);
//		
//		//dao3, dao4는 같은 오브젝트로 같은 주소를 갖는다.
//		//application Context -> annotation 을 이용한 의존 정보 확인 
//		ApplicationContext context = new AnnotationConfigApplicationContext(DaoFactory.class);
//		dao1 = context.getBean("userDao", UserDao.class);
//		dao2 = context.getBean("userDao", UserDao.class);
//		
//		System.out.println(dao1);
//		System.out.println(dao2);
//		
//		//application Context -> xml 을 이용한 의존 정보 확인 
//		context = new GenericXmlApplicationContext("applicationContext.xml");
//		dao1 = context.getBean("userDao", UserDao.class);
//		dao2 = context.getBean("userDao", UserDao.class);
//		
//		System.out.println(dao1);
//		System.out.println(dao2);
		ApplicationContext context = new GenericXmlApplicationContext("applicationContext.xml");
		UserDao dao = context.getBean("userDao", UserDao.class);
		
		User user = new User();
		user.setId("black2");
		user.setName("kyung");
		user.setPassword("password");
		dao.add(user);
		System.out.println("Insert Test Success");
		
		
		User user2 = dao.get(user.getId());
		
//		값이 같으면 테스트 성공 틀리면 테스트를 실패로 만든다 
		assertThat(user2.getName(), is(user.getName()));
		assertThat(user2.getPassword(), is(user.getPassword()));
		
		dao.deleteAll();
		assertThat(dao.getCount(), is(0));
	}

}
