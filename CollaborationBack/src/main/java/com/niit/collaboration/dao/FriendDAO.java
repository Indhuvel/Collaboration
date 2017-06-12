package com.niit.collaboration.dao;

import java.util.List;

import com.niit.collaboration.model.Friend;

public interface FriendDAO {
	
	public List<Friend>list();

	public void saveOrUpdate(Friend friend);
	
	public void delete (int friendId);
	
	public Friend getByFriendid(int friendId);
	
	public Friend getByStatus(String Status);
}
