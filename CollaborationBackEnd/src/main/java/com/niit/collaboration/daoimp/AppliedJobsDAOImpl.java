package com.niit.collaboration.daoimp;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.collaboration.dao.AppliedJobsDAO;
import com.niit.collaboration.model.AppliedJobs;
import com.niit.collaboration.model.Job;

@Repository("AppliedJobsDAO")
public class AppliedJobsDAOImpl implements AppliedJobsDAO {
	
	@Autowired
	private SessionFactory sessionFactory;


	public AppliedJobsDAOImpl(SessionFactory sessionFactory) {
		
		this.sessionFactory = sessionFactory;
	}
	@SuppressWarnings("unchecked")
	@Transactional
	public List<AppliedJobs> list() {
		List<AppliedJobs> listAjob = sessionFactory.getCurrentSession().createQuery("from AppliedJobs").list();
		return listAjob;
	}
	@Transactional
	public AppliedJobs saveOrUpdate(AppliedJobs jobs) {
		sessionFactory.getCurrentSession().saveOrUpdate(jobs);
		return jobs;
	}
	@Transactional
	public List<AppliedJobs> getByEmail(String email) {
		String hql = "from AppliedJobs where email ='"+ email +"'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		return query.list();
	}
	@Transactional
	public List<AppliedJobs> getByUserid(int userid) {
		String hql = "from AppliedJobs where userid ='"+ userid +"'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}
	@Transactional
	public AppliedJobs getByTitle(String title) {
		AppliedJobs Ajob =  (AppliedJobs)sessionFactory.getCurrentSession().get(AppliedJobs.class, title);
		return Ajob;
	}
	@Transactional
	public AppliedJobs getByJobid(String jobid) {
		AppliedJobs JobId = (AppliedJobs) sessionFactory.getCurrentSession().get(AppliedJobs.class, jobid);

		return  JobId;
	}
	@Transactional
	public List<Job> getMyAppliedJobs(String email) {
		String hql = "from AppliedJobs where email ='"+ email +"'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		return query.list();
	}

}
