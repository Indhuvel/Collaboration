package com.niit.collaboration.dao;

import java.util.List;

import com.niit.collaboration.model.Comment;

public interface CommentDAO {
	
    public List<Comment> list();
	
	public Comment getForumComments(int forumid);
	
	public Comment getComment(int commentid);
	
	public Comment saveOrUpdate(Comment comment);
		
	public void delete(int CommentId);

	public void create (Comment comment);
}
