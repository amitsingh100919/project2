package com.collabrationBackend.test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.collabrationBackend.DAO.UserDAO;
import com.collabrationBackend.model.User;

public class UserDAOTest {

	private static AnnotationConfigApplicationContext context=null;
	private static UserDAO userDAO=null;
	private static User user=null;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context=new AnnotationConfigApplicationContext();
		context.scan("com.collabrationBackend");
		context.refresh();
		userDAO=(UserDAO)context.getBean("userDAO");
		user=new User();
	}

	@Test
	public void testRegisterUser() {
		user.setEmail("amit@gmail.com");
		user.setPassword("123456");
		user.setFirstname("amit");
		user.setLastname("singh");
		user.setMobile("9417808347");
		assertTrue("User record not inserted",userDAO.registerUser(user));
	}
	@Ignore
	@Test
	public void testUpdateUser() {
		fail("Not yet implemented");
	}
	@Ignore
	@Test
	public void testDeleteUser() {
		fail("Not yet implemented");
	}
	@Ignore
	@Test
	public void testGetUserByEmail() {
		fail("Not yet implemented");
	}
	@Ignore
	@Test
	public void testGetAllActiveUser() {
		fail("Not yet implemented");
	}
	@Ignore
	@Test
	public void testActiveOrdeactiveUser() {
		fail("Not yet implemented");
	}
	@Ignore
	@Test
	public void testValidate() {
		fail("Not yet implemented");
	}

}
