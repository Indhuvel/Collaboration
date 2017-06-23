package com.niit.collaboration.dao;

import java.util.List;

import com.niit.collaboration.model.Mychat;

public interface MychatDAO {
	
	public List<Mychat>list();

	public Mychat saveOrUpdate(Mychat mychat);
	
    public void delete (int mychatId);
	
	public Mychat getByMychatid(int mychatid);

	public Mychat getAllMychat(int mychatid);

	public void insert(Mychat mychat);
}
