package com.niit.collaboration.daoimp;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.collaboration.dao.BlogDAO;
import com.niit.collaboration.model.Blog;

@Repository("BlogDAO")
public class BlogDAOImpl implements BlogDAO  {

	@Autowired
	private SessionFactory sessionFactory;

	public BlogDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Transactional
	public List<Blog> list() {
		@SuppressWarnings("unchecked")
		List<Blog> listBlog = sessionFactory.getCurrentSession().createQuery("from Blog").list();
		return listBlog;
	}
	@Transactional
	public boolean saveOrUpdate(Blog blog) {
		try
		{
		sessionFactory.getCurrentSession().saveOrUpdate(blog);
		}catch (Exception e) {
						e.printStackTrace();
			return false;
		}
		return true;
		
	}

	@Transactional
	public void delete(int blogId) {
		Blog blogToDelete = new Blog();
		blogToDelete.setBlogid(blogId);
		sessionFactory.getCurrentSession().delete(blogToDelete);
	}
	@Transactional
	public Blog getById(int blogId) {
		Blog BlogId = (Blog) sessionFactory.getCurrentSession().get(Blog.class, blogId);

		return BlogId;
	}
	@Transactional
	public Blog getByTitle(String title) {
		Blog Title = (Blog) sessionFactory.getCurrentSession().get(Blog.class,title);

		return Title;
	}
	
}
