package com.collabrationBackend.DAO.IMPL;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.collabrationBackend.DAO.JobDAO;
import com.collabrationBackend.model.Blog;
import com.collabrationBackend.model.Job;

@Repository("jobDAO")
@Transactional
public class JobDAOImpl implements JobDAO {
	
	@Autowired
    SessionFactory sessionFactory;
	public boolean createJob(Job job) {
		try {
			sessionFactory.getCurrentSession().save(job);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean updateJob(Job job) {
		try {
			sessionFactory.getCurrentSession().update(job);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean deleteJob(int id) {
		try {
			if(getJobById(id)!=null) {
			sessionFactory.getCurrentSession().delete(getJobById(id)!=null);
			return true;
			}
			else {
				System.out.println("There is no job with this id");
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public Job getJobById(int id) {
		try {
			return sessionFactory.getCurrentSession().get(Job.class,id);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	

	public List<Job> getJobList() {
		try {
			return sessionFactory.getCurrentSession().createQuery("from Job").list();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
