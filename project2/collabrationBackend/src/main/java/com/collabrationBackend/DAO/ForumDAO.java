package com.collabrationBackend.DAO;

import java.util.List;

import com.collabrationBackend.model.Forum;

public interface ForumDAO {
	
	// To save update delete forum
	public boolean createForum(Forum forum);
	public boolean updateForum(Forum forum);
	public boolean deleteForum(int id);
	
	//To select forum
	public Forum getForumById(int id);
	public List<Forum> getForumList();		

}
