package com.collabrationMiddle.RestConroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.collabrationBackend.DAO.BlogDAO;
import com.collabrationBackend.model.Blog;

@RestController
public class BlogController {
	
	@Autowired
	BlogDAO blogDAO;
	
	 @GetMapping("/demo")
	 public ResponseEntity<String> getdemo(){
		 return new ResponseEntity<String>("demo data",HttpStatus.OK);
	 }
	@GetMapping("/getAllBlog")
	public ResponseEntity<?> getAllBlogs(){
		List<Blog> blogList=blogDAO.getBlogList();
		if(blogList==null) {
			return new ResponseEntity<String>("There is no Blog Added",HttpStatus.NOT_FOUND);
		}
		else {
			return new ResponseEntity<List<Blog>>(blogList,HttpStatus.OK);
		}
	}

}
