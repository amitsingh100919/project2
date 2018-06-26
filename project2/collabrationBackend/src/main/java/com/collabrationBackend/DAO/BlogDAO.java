package com.collabrationBackend.DAO;

import java.util.List;

import com.collabrationBackend.model.Blog;

public interface BlogDAO {
	
	//To save update delete blog
		public boolean createBlog(Blog blog);
		public boolean updateBlog(Blog blog);
		public boolean daleteBlog(int id);
		
		//To select blog
		public Blog getBlogById(int id);
		public List<Blog> getBlogList();
		

}
