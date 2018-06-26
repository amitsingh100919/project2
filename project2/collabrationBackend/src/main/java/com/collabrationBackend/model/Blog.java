package com.collabrationBackend.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="Blog_table")
@SequenceGenerator(name="blogidseq", sequenceName="blog_id_seq")
public class Blog {
		@Id
		@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="blogidseq")
		private int blogId;
		private String title;
		private String content;
		private String postedBy;
		private String postedOn;
		private String userName;
		private String status;
		private int liked;
		private int shared;
		private String sharedBy;
		public int getBlogId() {
			return blogId;
		}
		public void setBlogId(int blogId) {
			this.blogId = blogId;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getContent() {
			return content;
		}
		public void setContent(String content) {
			this.content = content;
		}
		public String getPostedBy() {
			return postedBy;
		}
		public void setPostedBy(String postedBy) {
			this.postedBy = postedBy;
		}
		public String getPostedOn() {
			return postedOn;
		}
		public void setPostedOn(String postedOn) {
			this.postedOn = postedOn;
		}
		public String getUserName() {
			return userName;
		}
		public void setUserName(String userName) {
			this.userName = userName;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		public int getLiked() {
			return liked;
		}
		public void setLiked(int liked) {
			this.liked = liked;
		}
		public int getShared() {
			return shared;
		}
		public void setShared(int shared) {
			this.shared = shared;
		}
		public String getSharedBy() {
			return sharedBy;
		}
		public void setSharedBy(String sharedBy) {
			this.sharedBy = sharedBy;
		}
		
			

}
