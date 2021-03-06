package com.niit.collaboration.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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

import com.niit.collaboration.dao.CommentDAO;
import com.niit.collaboration.model.Comment;

@RestController
public class CommentController {

	@Autowired
	private CommentDAO commentDAO;
	
	public CommentDAO getCommentDAO() {
		return commentDAO;
	}
	
	public void setCommentDAO(CommentDAO commentDAO){
		this.commentDAO = commentDAO;
	}
	
	@GetMapping("/comment")
	public ResponseEntity<List<Comment>> getComments() {
		List<Comment> listcomment = commentDAO.list();
		return new ResponseEntity<List<Comment>>(listcomment, HttpStatus.OK);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping("/comments/{commentid}")
	public ResponseEntity getByComment(@PathVariable("commentid") int commentid) {

		Comment comment = commentDAO.getComment(commentid);
		if (comment == null) {
			return new ResponseEntity("No Comment found for ID " + commentid, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity(comment, HttpStatus.OK);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PostMapping(value = "/comment")
	public ResponseEntity createComment(@RequestBody Comment comment) {
		
		comment.setCreatedate(new Date());

		commentDAO.create(comment);

		return new ResponseEntity(comment, HttpStatus.OK);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@DeleteMapping("/comment/{commentid}")
	public ResponseEntity deleteUser(@PathVariable int commentid) {
		Comment comment=commentDAO.getComment(commentid);
 		if (comment==null) {
			return new ResponseEntity("No Comment found for ID " + commentid, HttpStatus.NOT_FOUND);
		}
 		commentDAO.delete(commentid);
		return new ResponseEntity(commentid, HttpStatus.OK);
   }
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PutMapping("/comment/{commentid}")
	public ResponseEntity saveorupdateUser(@PathVariable int commentid, @RequestBody Comment comment) {

		comment = commentDAO.saveOrUpdate(comment);
		if (null == comment) {
			return new ResponseEntity("No Comment found for ID " + commentid, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity(comment, HttpStatus.OK);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping("/comments/{forumid}")
	public ResponseEntity getForumId(@PathVariable("forumid") int forumid, HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.setAttribute("forumId", forumid);
		System.out.println("hai");
		System.out.println(forumid);
		List listcomment = (List) commentDAO.getForumComments(forumid);
		if (listcomment == null) {
			return new ResponseEntity("No Comment found for ID " + forumid, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity(listcomment, HttpStatus.OK);
	}
}
