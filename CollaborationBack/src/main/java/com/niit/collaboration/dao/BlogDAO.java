package com.niit.collaboration.dao;

import java.util.List;

import com.niit.collaboration.model.Blog;

public interface BlogDAO {
	
	public List<Blog>list();

	public boolean saveOrUpdate(Blog blog);
	
	public void delete (int blogId);
	
	public Blog getById(int blogId);
	
	public Blog getByTitle(String title);
}
