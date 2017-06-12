package com.niit.collaboration.daoimp;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.collaboration.dao.UserDAO;
import com.niit.collaboration.model.User;

@Repository("UserDAO")
public class UserDAOImpl implements UserDAO{
	
	@Autowired
	private SessionFactory sessionFactory;

	public UserDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public List<User> list() {
		@SuppressWarnings("unchecked")
		List<User> listUser = (List<User>) sessionFactory.getCurrentSession().createCriteria(User.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return listUser;
	}


	@Transactional
	public boolean saveOrUpdate(User user) {
		try
		{
		sessionFactory.getCurrentSession().saveOrUpdate(user);
		}catch (Exception e) {
						e.printStackTrace();
			return false;
		}
		return true;
	}

	@Transactional
	public void delete(int userId) {
		User userToDelete = new User();
		userToDelete.setUserid(userId);
		sessionFactory.getCurrentSession().delete(userToDelete);
	}

	@Transactional
	public User getByUserId(int userId) {
		String hql = "from userinfo where userid ='" + userId + "'";
		Query query = (Query) sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<User> listUser = (List<User>) (query).list();

		if (listUser != null && !listUser.isEmpty()) {
			return listUser.get(0);
		}
		return null;
  
	}  

	@Transactional
	public User getByMail(String mail) {
		String hql = "from userinfo where mailid ='" + mail + "'";
		Query query = (Query) sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<User> listUser = (List<User>) (query).list();

		if (listUser != null && !listUser.isEmpty()) {
			return listUser.get(0);
		}
		return null;
	}

	

	@Transactional
	public User login(User user) {
		System.out.println(user.getEmail());
		System.out.println(user.getPassword());
		String hql = "from User where mail=" + "'" + user.getEmail() + "'   and password = " + "'"+ user.getPassword() +"'";
	
		Query query = sessionFactory.getCurrentSession().createQuery(hql);

		@SuppressWarnings("unchecked")
		List<User> list = (List<User>) query.list();

		if (list != null && !list.isEmpty()) {
			return list.get(0);    
			
		}
		return null;
	}
}
