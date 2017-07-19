package com.niit.collaboration.dao;

import java.util.List;

import com.niit.collaboration.model.AppliedJobs;
import com.niit.collaboration.model.Job;

public interface AppliedJobsDAO {

	public List<AppliedJobs>list();
	
	public AppliedJobs saveOrUpdate(AppliedJobs jobs);
	
	public List<AppliedJobs> getByEmail(String email);
	
	public  List<AppliedJobs> getByUserid(int userid);
	
	public AppliedJobs getByTitle(String title);
	
	public AppliedJobs getByJobid(String jobid);
	
	public List<Job>getMyAppliedJobs(String email);
}
