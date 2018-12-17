package com.project.controller;

import java.io.ByteArrayInputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Main extends JavaInputFile {

	static int postId = 0;
	
	public static void main(String[] args) {
		init();
		
		Map<String, Boolean> userData = new HashMap<>();
		Map<String, ArrayList<Post>> userNameBasedPosts = new HashMap<>();
		Map<String, ArrayList<String>> follwMap = new HashMap<>();
		String currentLoggedInUser = null;
		Map<Integer, Location> idBasedPost = new HashMap<>();

		int NumberOfOperations = readInt();
		while (NumberOfOperations > 0) {

			String input = readString();
			String[] inputParameters = input.split("\\~");
			int typeOfOperation = getTypeOfOperation(inputParameters[0]);
			switch (typeOfOperation) {
			case 1: {
				signUp(userData, inputParameters[1]);
				break;
			}
			case 2: {
				currentLoggedInUser = login(userData, inputParameters[1]);
				break;
			}
			case 3: {
				post(currentLoggedInUser, inputParameters[1], userNameBasedPosts, ++postId, idBasedPost);
				break;
			}
			case 4: {
				follow(currentLoggedInUser, follwMap, inputParameters[1]);
				break;
			}
			case 5: {
				reply(currentLoggedInUser, idBasedPost, ++postId, Integer.parseInt(inputParameters[1]),
						inputParameters[2], userNameBasedPosts);
				break;
			}
			case 6: {
				upVote(userNameBasedPosts, Integer.parseInt(inputParameters[1]), idBasedPost);
				break;
			}
			case 7: {
				downVote(userNameBasedPosts, Integer.parseInt(inputParameters[1]), idBasedPost);
				break;
			}
			case 8: {
				newsFeed(currentLoggedInUser, follwMap, userNameBasedPosts);
				break;
			}
			}
			NumberOfOperations--;
		}

		end();
	}

	private static void reply(String currentLoggedInUser, Map<Integer, Location> idBasedPost, int i, int j,
			String commentDesc, Map<String, ArrayList<Post>> userNameBasedPosts) {
		Post post = getpostbyPostid(userNameBasedPosts, idBasedPost.get(j));
		post.getComments().add(getPost(commentDesc, currentLoggedInUser, i, true));
		post(currentLoggedInUser, commentDesc, userNameBasedPosts, ++postId, idBasedPost);
	}

	private static void newsFeed(String currentLoggedInUser, Map<String, ArrayList<String>> follwMap,
			Map<String, ArrayList<Post>> userNameBasedPosts) {
		ArrayList<String> following = follwMap.get(currentLoggedInUser);
		for (String followedUser : following) {
			ArrayList<Post> postByThatUser = userNameBasedPosts.get(followedUser);
			for (Post currentPost : postByThatUser) {
				printPost(currentPost);
			}
		}
	}

	private static void printPost(Post currentPost) {
		if (!currentPost.isAcomment()) {
			System.out.println("id: " + currentPost.getId());
			System.out.println(
					"(" + currentPost.getNoOfUpVotes() + " upvotes, " + currentPost.getNoOfDownVotes() + " downvotes)");
			System.out.println(currentPost.getPostedBy());
			System.out.println(currentPost.getPostDescription());
			System.out.println(currentPost.getTimeStamp());
			for (Post commentpost : currentPost.getComments()) {
				if (commentpost.isAcomment()) {
					System.out.println("id: " + commentpost.getId());
					System.out.println("(" + commentpost.getNoOfUpVotes() + " upvotes, "
							+ commentpost.getNoOfDownVotes() + " downvotes)");
					System.out.println(commentpost.getPostedBy());
					System.out.println(commentpost.getPostDescription());
					System.out.println(commentpost.getTimeStamp());
				}
			}
		}
	}

	private static void downVote(Map<String, ArrayList<Post>> userBasedPosts, int i,
			Map<Integer, Location> idBasedPost) {
		Location location = idBasedPost.get(i);
		Post post = getpostbyPostid(userBasedPosts, location);
		post.setNoOfDownVotes(post.getNoOfDownVotes() + 1);
	}

	private static Post getpostbyPostid(Map<String, ArrayList<Post>> userBasedPosts, Location location) {
		return userBasedPosts.get(location.getUserName()).get(location.getIndex());
	}

	private static void upVote(Map<String, ArrayList<Post>> userBasedPosts, int i, Map<Integer, Location> idBasedPost) {
		Location location = idBasedPost.get(i);
		Post post = getpostbyPostid(userBasedPosts, location);
		post.setNoOfUpVotes(post.getNoOfUpVotes() + 1);
	}

	private static void follow(String currentLoggedInUser, Map<String, ArrayList<String>> follwMap,
			String userToBefollowed) {
		if (follwMap.containsKey(currentLoggedInUser)) {
			follwMap.get(currentLoggedInUser).add(userToBefollowed);
		} else {
			follwMap.put(currentLoggedInUser, new ArrayList<>());
			follwMap.get(currentLoggedInUser).add(userToBefollowed);
		}

	}

	private static void post(String currentLoggedInUser, String postDesc,
			Map<String, ArrayList<Post>> userNameBasedPosts, int postId, Map<Integer, Location> idBasedPost) {

		Location location = new Location();
		location.setUserName(currentLoggedInUser);

		if (userNameBasedPosts.containsKey(currentLoggedInUser)) {
			userNameBasedPosts.get(currentLoggedInUser).add(getPost(postDesc, currentLoggedInUser, postId, false));
			location.setIndex(userNameBasedPosts.get(currentLoggedInUser).size() - 1);
		} else {
			userNameBasedPosts.put(currentLoggedInUser, new ArrayList<>());
			userNameBasedPosts.get(currentLoggedInUser).add(getPost(postDesc, currentLoggedInUser, postId, false));
			location.setIndex(userNameBasedPosts.get(currentLoggedInUser).size() - 1);
		}

		idBasedPost.put(postId, location);
	}

	private static Post getPost(String postDesc, String currentLoggedInUser, int postId, boolean isComment) {
		Post post = new Post();
		post.setId(postId);
		post.setPostDescription(postDesc);
		post.setNoOfDownVotes(0);
		post.setNoOfUpVotes(0);
		post.setPostedBy(currentLoggedInUser);
		post.setTimeStamp(new Date());
		post.setComments(new ArrayList<>());
		post.setAcomment(isComment);
		return post;
	}

	private static String login(Map<String, Boolean> userData, String userName) {
		if (userData.containsKey(userName))
			return userName;
		return null;
	}

	private static void signUp(Map<String, Boolean> userData, String userName) {
		userData.put(userName, true);
	}

	private static void end() {
		out.flush();
	}

	private static void init() {
		is = INPUT.isEmpty() ? System.in : new ByteArrayInputStream(INPUT.getBytes());
		out = new PrintWriter(System.out);
	}

	private static int getTypeOfOperation(String operation) {
		if (operation.equalsIgnoreCase("signup"))
			return 1;
		else if (operation.equalsIgnoreCase("login"))
			return 2;
		else if (operation.equalsIgnoreCase("post"))
			return 3;
		else if (operation.equalsIgnoreCase("follow"))
			return 4;
		else if (operation.equalsIgnoreCase("reply"))
			return 5;
		else if (operation.equalsIgnoreCase("upvote"))
			return 6;
		else if (operation.equalsIgnoreCase("downvote"))
			return 7;
		else if (operation.equalsIgnoreCase("shownewsfeed"))
			return 8;
		return -1;
	}
}
