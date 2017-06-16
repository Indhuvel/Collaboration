package com.niit.collaboration.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.niit.collaboration.dao.MychatDAO;
import com.niit.collaboration.model.Mychat;
import com.niit.collaboration.model.User;

@RestController
public class ChatController {

	@Autowired
	private MychatDAO mychatDAO;
	
	public MychatDAO getMychatDAO() {
		return mychatDAO;
	}

	public void setMychatDAO(MychatDAO mychatDAO) {
		this.mychatDAO = mychatDAO;
	}

	@GetMapping("/mychat")
	public ResponseEntity<List<Mychat>> getMychat() {
		List<Mychat> listmychat = mychatDAO.list();
		return new ResponseEntity<List<Mychat>>(listmychat, HttpStatus.OK);
	}

	@SuppressWarnings("unchecked")
	@GetMapping("/mychats/{chatid}")
	public ResponseEntity getByMychatId(@PathVariable("chatid") int chatid) {

		Mychat mychat = mychatDAO.getByMychatid(chatid);
		if (mychat == null) {
			return new ResponseEntity("No Chat found for ID " + chatid, HttpStatus.NOT_FOUND);
		}
      return new ResponseEntity(mychat, HttpStatus.OK);
	}
	
	@SuppressWarnings("unchecked")
	@PostMapping(value ="/mychat")
	public ResponseEntity insertChat(@RequestBody Mychat mychat) {

		mychatDAO.insert(mychat);

		return new ResponseEntity(mychat, HttpStatus.OK);
      }
	
	@SuppressWarnings("unchecked")
	@DeleteMapping("/mychat/{chatid}")
	public ResponseEntity deleteChat(@PathVariable int chatid) {
		Mychat mychat=mychatDAO.getByMychatid(chatid);
 		if (mychat==null) {
			return new ResponseEntity("No Chat found for ID " + chatid, HttpStatus.NOT_FOUND);
		}
 		mychatDAO.delete(chatid);
		return new ResponseEntity(chatid, HttpStatus.OK);
   }
	
	@SuppressWarnings("unchecked")
	@PutMapping("/mychat/{chatid}")
	public ResponseEntity saveorupdateUser(@PathVariable int chatid, @RequestBody Mychat mychat) {

		mychat = mychatDAO.saveOrUpdate(mychat);
		if (null == mychat) {
			return new ResponseEntity("No Chat found for ID " + chatid, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity(mychat, HttpStatus.OK);
	}

}
