package com.niit.collaboration.dao;

import java.util.List;

import com.niit.collaboration.model.Job;

public interface JobDAO {
	
	public List<Job>list();

	public void saveOrUpdate(Job job);
	
	public void delete (int jobId);
	
	public Job getByJobid(int jobId);
	
	public Job getByJobcategory(String jobCategory);
}
