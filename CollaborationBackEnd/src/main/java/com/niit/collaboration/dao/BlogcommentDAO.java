package com.niit.collaboration.dao;

import java.util.List;

import com.niit.collaboration.model.Blogcomment;

public interface BlogcommentDAO {
	
public List<Blogcomment> list();
	
	public List<Blogcomment> getBlogComments(int blogid);
	
	public Blogcomment getBlogComment(int blogCommentid);
	
	public Blogcomment save(Blogcomment bcomment);
	
	public Blogcomment saveOrUpdate(Blogcomment bcomment);
		
	public void delete(int id);
}
