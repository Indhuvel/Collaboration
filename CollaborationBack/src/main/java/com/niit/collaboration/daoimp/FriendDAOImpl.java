package com.niit.collaboration.daoimp;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.collaboration.dao.FriendDAO;
import com.niit.collaboration.model.Friend;

@Repository("FriendDAO")
public class FriendDAOImpl implements FriendDAO  {
	
	@Autowired
	private SessionFactory sessionFactory;
	public FriendDAOImpl(SessionFactory sessionFactory) {
		
		this.sessionFactory = sessionFactory;
	}
	@SuppressWarnings("unchecked")
	@Transactional
	public List<Friend> list() {
		List<Friend> listFriend = sessionFactory.getCurrentSession().createQuery("from Friend").list();
		return listFriend;
	}
	@Transactional
	public void delete(int friendId) {
	Friend friendToDelete = new Friend();
	friendToDelete.setFriendid(friendId);
	sessionFactory.getCurrentSession().delete(friendToDelete);

	}
   @Transactional
	public Friend getByFriendid(int friendId) {
	Friend Friendid = (Friend) sessionFactory.getCurrentSession().get(Friend.class, friendId);

	return Friendid;
	}
   @Transactional
   public Friend getByStatus(String status) {
	Friend Status = (Friend) sessionFactory.getCurrentSession().get(Friend.class, status);

	return Status;

   }
   @Transactional
   public void saveOrUpdate(Friend friend) {
	sessionFactory.getCurrentSession().save(friend);
	
   }
  }
