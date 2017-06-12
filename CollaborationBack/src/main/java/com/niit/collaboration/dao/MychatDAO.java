package com.niit.collaboration.dao;

import java.util.List;

import com.niit.collaboration.model.Mychat;

public interface MychatDAO {
	
	public List<Mychat>list();

	public boolean saveOrUpdate(Mychat mychat);
	
    public void delete (int mychatId);
	
	public Mychat getByMychatid(int mychatId);
}
