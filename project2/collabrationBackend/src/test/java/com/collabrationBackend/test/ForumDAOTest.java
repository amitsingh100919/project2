package com.collabrationBackend.test;

import static org.junit.Assert.*;

import javax.naming.Context;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.collabrationBackend.DAO.BlogDAO;
import com.collabrationBackend.DAO.ForumDAO;
import com.collabrationBackend.model.Blog;
import com.collabrationBackend.model.Forum;

public class ForumDAOTest {
	
	private static AnnotationConfigApplicationContext context=null;
	private static ForumDAO forumDAO=null;
	private static Forum forum=null; 

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context= new AnnotationConfigApplicationContext();
		context.scan("com.collabrationBackend");
		context.refresh();
		forumDAO=(ForumDAO)context.getBean("forumDAO");
		forum=new Forum();
	}

	
	@Test
	public void testCreateForum() {
		forum.setTitle("about friends");
		forum.setContent("amsdndjdjggkf");
		forum.setPostedBy("amit");
		forum.setPostedOn("my blogs");
		forum.setUserName("amit singh");
		forum.setStatus("A");
		assertTrue("Forum record not inserted", forumDAO.createForum(forum));
	}

	@Ignore
	@Test
	public void testUpdateForum() {
		fail("Not yet implemented");
	}

	@Ignore
	@Test
	public void testDeleteForum() {
		fail("Not yet implemented");
	}

	@Ignore
	@Test
	public void testGetForumById() {
		fail("Not yet implemented");
	}

	@Ignore
	@Test
	public void testGetForumList() {
		fail("Not yet implemented");
	}

}
