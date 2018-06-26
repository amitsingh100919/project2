package com.collabrationMiddle.RestConroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.collabrationBackend.DAO.JobDAO;
import com.collabrationBackend.model.Job;

@RestController
public class JobController {
	
	@Autowired
	JobDAO jobDAO;
	@GetMapping("/getAllJob")
	public ResponseEntity<?> getAllJob(){
		List<Job> jobList = jobDAO.getJobList();
		if(jobList==null) {
			return new ResponseEntity<String>("There is no job added",HttpStatus.NOT_FOUND);
		}
		else {
			return new ResponseEntity<List<Job>>(jobList,HttpStatus.OK);
		}
	}

}
