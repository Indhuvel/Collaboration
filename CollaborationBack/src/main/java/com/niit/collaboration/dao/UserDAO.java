package com.niit.collaboration.dao;

import java.util.List;

import com.niit.collaboration.model.User;

public interface UserDAO {
	
	public List<User> list();

	public boolean saveOrUpdate(User user);

	public void delete(int userId);

	public User getByUserId(int userId);

	public User getByMail(String mail);

	

	public User login(User user);
}
