package com.collabrationBackend.DAO.IMPL;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.collabrationBackend.DAO.BlogDAO;
import com.collabrationBackend.model.Blog;
import com.collabrationBackend.model.User;

@Repository("blogDAO")
@Transactional
public class BlogDAOImpl implements BlogDAO {

	@Autowired
	SessionFactory sessionFactory;
	public boolean createBlog(Blog blog) {
			try {
				sessionFactory.getCurrentSession().save(blog);
				return true;
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
	}

	public boolean updateBlog(Blog blog) {
		try {
			sessionFactory.getCurrentSession().update(blog);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean daleteBlog(int id) {
		try {
			if(getBlogById(id)!=null) {
			sessionFactory.getCurrentSession().delete(getBlogById(id)!=null);
			return true;
			}
			else {
				System.out.println("There is no blog with this id");
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public Blog getBlogById(int id) {
		try {
			return sessionFactory.getCurrentSession().get(Blog.class,id);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<Blog> getBlogList() {
		try {
			return sessionFactory.getCurrentSession().createQuery("from Blog where status='A'").list();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
