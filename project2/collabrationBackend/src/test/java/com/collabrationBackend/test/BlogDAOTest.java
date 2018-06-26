package com.collabrationBackend.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.collabrationBackend.DAO.BlogDAO;
import com.collabrationBackend.model.Blog;

public class BlogDAOTest {
	
	private static AnnotationConfigApplicationContext context=null;
	private static BlogDAO blogDAO=null;
	private static Blog blog=null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context= new AnnotationConfigApplicationContext();
		context.scan("com.collabrationBackend");
		context.refresh();
		blogDAO=(BlogDAO)context.getBean("blogDAO");
		blog=new Blog();
	}

	@Test
	public void testCreateBlog() {
		//blog.setBlogId(2);
		blog.setTitle("about friends");
		blog.setContent("amsdndjdjggkf");
		blog.setPostedBy("amit");
		blog.setPostedOn("my blogs");
		blog.setUserName("amit singh");
		blog.setStatus("A");
		blog.setLiked(4);
		blog.setShared(5);
		blog.setSharedBy("bhanoo sir");
		assertTrue("Blog record not inserted",blogDAO.createBlog(blog));
	}

	@Ignore
	@Test
	public void testUpdateBlog() {
		fail("Not yet implemented");
	}

	@Ignore
	@Test
	public void testDaleteBlog() {
		fail("Not yet implemented");
	}

	@Ignore
	@Test
	public void testGetBlogById() {
		fail("Not yet implemented");
	}

	@Ignore
	@Test
	public void testGetBlogList() {
		fail("Not yet implemented");
	}

}
