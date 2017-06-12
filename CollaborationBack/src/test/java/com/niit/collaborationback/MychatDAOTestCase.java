package com.niit.collaborationback;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.collaboration.dao.MychatDAO;
import com.niit.collaboration.model.Mychat;

public class MychatDAOTestCase {

	@Autowired
	static AnnotationConfigApplicationContext context;

	@Autowired
    static MychatDAO mychatDAO;
	
	@Autowired
    static Mychat mychat;
	
	@BeforeClass
	public static void initialize() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.collaboration");
		context.refresh();
		
		mychatDAO = (MychatDAO)context.getBean("MychatDAO");
		mychat = (Mychat)context.getBean("mychat");
  }
	@Test
	public void createMychatTestCase(){
	
		mychat.setUsername("mano");
		mychat.setBlogid(9);
		mychat.setUsercomment("com");
		mychat.setCommentdate(null);
		mychat.setUserid(51);
		mychat.setForumid(99);
		
		boolean flag=mychatDAO.saveOrUpdate(mychat);
		System.out.println(flag);

	}
  }