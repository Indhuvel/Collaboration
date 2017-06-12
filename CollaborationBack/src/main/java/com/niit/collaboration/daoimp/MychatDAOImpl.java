package com.niit.collaboration.daoimp;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.collaboration.dao.MychatDAO;
import com.niit.collaboration.model.Mychat;

@Repository("MychatDAO")
public class MychatDAOImpl implements MychatDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public MychatDAOImpl(SessionFactory sessionFactory) {
		
		this.sessionFactory = sessionFactory;
	}
	
	@Transactional
	public List<Mychat> list() {
		@SuppressWarnings("unchecked")
		List<Mychat> listMychat = sessionFactory.getCurrentSession().createQuery("from Mychat").list();
		return listMychat;
	}
	
	@Transactional
	public boolean saveOrUpdate(Mychat mychat) {
		try
		{
		sessionFactory.getCurrentSession().saveOrUpdate(mychat);
		}catch (Exception e) {
						e.printStackTrace();
			return false;
		}
		return true;		
	}
	
	@Transactional
	public void delete(int mychatId) {
		Mychat mychatToDelete = new Mychat();
		mychatToDelete.setChatid(mychatId);
		sessionFactory.getCurrentSession().delete(mychatToDelete);
   }
	
	@Transactional
	public Mychat getByMychatid(int mychatId) {
		Mychat MychatId = (Mychat) sessionFactory.getCurrentSession().get(Mychat.class, mychatId);
		return MychatId;
	}
	
}
