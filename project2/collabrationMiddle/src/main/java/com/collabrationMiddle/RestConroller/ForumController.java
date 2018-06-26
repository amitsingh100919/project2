package com.collabrationMiddle.RestConroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.collabrationBackend.DAO.ForumDAO;
import com.collabrationBackend.model.Forum;

@RestController
public class ForumController {
	
	@Autowired
	ForumDAO forumDAO;
	@GetMapping("/getAllForum")
	public ResponseEntity<?> getAllForum(){
		List<Forum> forumList = forumDAO.getForumList();
		if(forumList==null) {
			return new ResponseEntity<String>("There is no forum added",HttpStatus.NOT_FOUND);
		}
		else {
			return new ResponseEntity<List<Forum>>(forumList,HttpStatus.OK);
		}
	}
	@PostMapping("/createForum")
	public ResponseEntity<?> createForum(@RequestBody Forum forum){
		System.out.println("Create forum");
		if(forumDAO.createForum(forum)) {
			return new ResponseEntity<String>("Forum added successfully",HttpStatus.OK);
		}
		else {
			return new ResponseEntity<String>("Forum not added",HttpStatus.NOT_FOUND);
		}
	}
	@PostMapping("/updateForum/{forumId}")
	public ResponseEntity<?> updateForum(@PathVariable("forumId") int forumId,@RequestBody Forum forum){
		System.out.println("update forum");
		Forum uforum = forumDAO.getForumById(forumId);
		if(uforum == null) 
			return new ResponseEntity<String> ("Forum not updated",HttpStatus.NOT_FOUND);
			uforum.setContent(forum.getContent());
			uforum.setTitle(forum.getTitle());
			uforum.setUserName(forum.getUserName());
			uforum.setPostedBy(forum.getPostedBy());
			uforum.setStatus(forum.getStatus());
			uforum.setPostedOn(forum.getPostedOn());
			forumDAO.updateForum(uforum);
			return new ResponseEntity<String>("Forum updated successfully",HttpStatus.OK);
		
		
		
	}
	@PostMapping("/deleteForum/{forumId}")
	public ResponseEntity<?> deleteForum(@PathVariable("forumId") int forumId){
		System.out.println("delete forum");
		if(forumDAO.deleteForum(forumId)) {
			return new ResponseEntity<String>("Forum deleted successfully",HttpStatus.OK);
		}
		else {
			return new ResponseEntity<String>("Forum not deleted",HttpStatus.NOT_FOUND);
		}
	}
	@PostMapping("/getForum")
	public ResponseEntity<?> getForum(@PathVariable("forumId") int forumId){
		Forum forum = forumDAO.getForumById(forumId);
		if(forum == null) {
			return new ResponseEntity<Forum>(forum,HttpStatus.NOT_FOUND);
		}
		else {
			return new ResponseEntity<Forum>(forum,HttpStatus.OK);
		}
	}
}
