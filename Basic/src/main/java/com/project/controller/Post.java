package com.project.controller;

import java.util.ArrayList;
import java.util.Date;

public class Post {

	int id;
	int noOfUpVotes;
	int noOfDownVotes;
	String postedBy;
	String postDescription;
	Date timeStamp;
	ArrayList<Post> comments;
	boolean isAcomment;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNoOfUpVotes() {
		return noOfUpVotes;
	}

	public void setNoOfUpVotes(int noOfUpVotes) {
		this.noOfUpVotes = noOfUpVotes;
	}

	public int getNoOfDownVotes() {
		return noOfDownVotes;
	}

	public void setNoOfDownVotes(int noOfDownVotes) {
		this.noOfDownVotes = noOfDownVotes;
	}

	public String getPostedBy() {
		return postedBy;
	}

	public void setPostedBy(String postedBy) {
		this.postedBy = postedBy;
	}

	public String getPostDescription() {
		return postDescription;
	}

	public void setPostDescription(String postDescription) {
		this.postDescription = postDescription;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	public ArrayList<Post> getComments() {
		return comments;
	}

	public void setComments(ArrayList<Post> comments) {
		this.comments = comments;
	}

	public boolean isAcomment() {
		return isAcomment;
	}

	public void setAcomment(boolean isAcomment) {
		this.isAcomment = isAcomment;
	}

}
