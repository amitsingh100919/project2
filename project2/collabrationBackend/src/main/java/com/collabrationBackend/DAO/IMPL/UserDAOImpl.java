package com.collabrationBackend.DAO.IMPL;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.collabrationBackend.DAO.UserDAO;
import com.collabrationBackend.model.User;

@Repository("userDAO")
@Transactional
public class UserDAOImpl implements UserDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	public boolean registerUser(User user) {
		try {
			sessionFactory.getCurrentSession().save(user);
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
		
	}

	public boolean updateUser(User user) {
		try {
			sessionFactory.getCurrentSession().update(user);
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public boolean deleteUser(String email) {
		try {
			if(getUserByEmail(email)!=null) {
				sessionFactory.getCurrentSession().delete(getUserByEmail(email));
				return true;
			}
			else {
				System.out.println("There is no user with this email address");
				return false;
			}
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public User getUserByEmail(String email) {
		try {
			return sessionFactory.getCurrentSession().get(User.class,email);
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public List<User> getAllActiveUser() {
		try {
			return sessionFactory.getCurrentSession().createQuery("from User where isActive=true").list();
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public boolean activeOrdeactiveUser(String email) {
		try {
			
			User usr=getUserByEmail(email);
			
			if(usr!=null) {
				usr.setActive(!usr.isActive());
				updateUser(usr);
				return true;
			}
			else {
				System.out.println("There is no user withthis email address");
				return false;
			}
			
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public boolean validate(String email, String password) {
		try {
			User usr=(User)sessionFactory.getCurrentSession().createQuery("from User where email=:email and password=:password")
			.setParameter("email", email)
			.setParameter("password", password).getSingleResult();
			
			if(usr!=null) {
				return true;
			}
			else {
				System.out.println("Credential do not match !");
				return false;
			}
			
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

}
