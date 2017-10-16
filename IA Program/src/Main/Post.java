package Main;

import java.util.ArrayList;

public class Post {
	
	private String question, datePosted, discussionDate;
	private int id;
	private boolean isServer;
	private ArrayList<String> studentViews;
	
	public Post(String question, String datePosted, String discussionDate, int id) {
		
		this.question = question;
		this.datePosted = datePosted;
		this.discussionDate = discussionDate;
		this.id = id;
		isServer = true;
		studentViews = new ArrayList<String>();
		
	}
	
	public Post(String question, String datePosted, String discussionDate){
		
		this.question = question;
		this.datePosted = datePosted;
		this.discussionDate = discussionDate;
		isServer = false;
		
	}

	public String getQuestion() {
		return question;
	}

	public String getDatePosted() {
		return datePosted;
	}

	public String getDiscussionDate() {
		return discussionDate;
	}
	
	public int getID(){
		return id;
	}
	
	public void addStudentView(String student){
		studentViews.add(student);
	}
	
	public ArrayList<String> getStudentViews(){
		return studentViews;
	}
	
	public boolean isServer(){
		return isServer;
	}

}
