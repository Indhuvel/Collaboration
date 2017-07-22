package com.niit.collaboration.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.niit.collaboration.dao.FriendDAO;
import com.niit.collaboration.model.Friend;
import com.niit.collaboration.model.User;

@RestController
public class FriendController {

	@Autowired
	private FriendDAO friendDAO;
	
	@Autowired
	private Friend friend;
	
	public FriendDAO getFriendDAO() {
		return friendDAO;
	}

	public void setFriendDAO(FriendDAO friendDAO) {
		this.friendDAO = friendDAO;
	}
		
	@GetMapping("/friend")
	public ResponseEntity<List<Friend>> getFriends() {
		List<Friend> listfriend = friendDAO.list();
		return new ResponseEntity<List<Friend>>(listfriend, HttpStatus.OK);
	}
	
	@GetMapping("/friend/{userid}")
	public List<Friend> getByUser(@PathVariable("userid")int userid) {
		return friendDAO.getByUser(userid);
	}
	
	@GetMapping("/friends/{username}")  
	public List<Friend> getByName(@PathVariable("username") String username) {
		return friendDAO.getByName(username);
		
	}

	@GetMapping("/friendsAccepted/{friendname}")  
	public List<Friend> getByFriendAccepted(@PathVariable("friendname") String friendname) {
		return friendDAO.getByFriendAccepted(friendname);
		
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@PostMapping("/friends")
	public ResponseEntity createFriend(@RequestBody User friendUser, HttpSession session) {
		User user = (User) session.getAttribute("user");   
		friend.setUserid(user.getUserid());
		friend.setUsername(user.getUsername());
		friend.setStatus("P");
	//	friend.setFriendId(friendUser.get());
	//	friend.setFriendName(friendUser.get());
		friend.setIsOnline("TRUE");
	
		friendDAO.save(friend);

		return new ResponseEntity(friend, HttpStatus.OK);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@PutMapping("/friendAccept")
	public ResponseEntity acceptFriend(@RequestBody Friend friend){
		
		friend.setStatus("A");
		friend = friendDAO.saveOrUpdate(friend);
		
		return new ResponseEntity(friend, HttpStatus.OK);
	}
	
	/*@DeleteMapping("/friends/{id}")
	public ResponseEntity deleteFriend(@PathVariable int id) {
		Friend friend=friendDAO.getByFriendId(id);
 		if (friend==null) {
			return new ResponseEntity("No friend found for ID " + id, HttpStatus.NOT_FOUND);
		}
 		friendDAO.delete(id);
		return new ResponseEntity(id, HttpStatus.OK);

	}*/
}
