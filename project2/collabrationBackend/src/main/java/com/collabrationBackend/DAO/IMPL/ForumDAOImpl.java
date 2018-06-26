package com.collabrationBackend.DAO.IMPL;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.collabrationBackend.DAO.ForumDAO;
import com.collabrationBackend.model.Blog;
import com.collabrationBackend.model.Forum;

@Repository("forumDAO")
@Transactional
public class ForumDAOImpl implements ForumDAO {
	
	@Autowired
	SessionFactory sessionFactory;

	public boolean createForum(Forum forum) {
		try {
			sessionFactory.getCurrentSession().save(forum);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean updateForum(Forum forum) {
		try {
			sessionFactory.getCurrentSession().update(forum);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean deleteForum(int id) {
		try {
			if(getForumById(id)!=null) {
			sessionFactory.getCurrentSession().delete(getForumById(id)!=null);
			return true;
			}
			else {
				System.out.println("There is no forum with this id");
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public Forum getForumById(int id) {
		try {
			return sessionFactory.getCurrentSession().get(Forum.class,id);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<Forum> getForumList() {
		try {
			return sessionFactory.getCurrentSession().createQuery("from Forum where status='A'").list();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	

}
