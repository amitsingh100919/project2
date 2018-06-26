package com.collabrationBackend.DAO;

import java.util.List;

import com.collabrationBackend.model.Job;

public interface JobDAO {
	
	// To save update delete job
	public boolean createJob(Job job);
	public boolean updateJob(Job job);
	public boolean deleteJob(int id);
	
	// To select job
	public Job getJobById(int id);
	public List<Job> getJobList();

}
