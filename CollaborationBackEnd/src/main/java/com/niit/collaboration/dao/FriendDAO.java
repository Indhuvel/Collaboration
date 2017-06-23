package com.niit.collaboration.dao;

import java.util.List;

import com.niit.collaboration.model.Friend;

public interface FriendDAO {
	
	public List<Friend>list();

	public Friend saveOrUpdate(Friend friend);
	
	public void delete (int friendId);
	
	public Friend getByFriendid(int friendId);
	
	public List<Friend> getByFriendRequestList(int userid);

	public List<Friend> FriendList(int userid);
}
