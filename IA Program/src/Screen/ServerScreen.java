package Screen;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JList;

import IO.Export;
import IO.Import;
import Main.Main;
import Main.Post;
import Server.ServerContact;
import Server.ServerInfo;

public class ServerScreen extends Screen{
	
	private static volatile ArrayList<Post> posts;//ArrayList containing all posts
	
	
	private JList<String> postList;
	private JButton select, addPost;
	private ServerContact serverContact;
	private ServerInfo serverInfo;
	
	public ServerScreen(Main frame) {
		super(frame);
		
		setLayout(null);
		setPreferredSize(new Dimension(340,320));
		
		serverContact = new ServerContact();
		serverInfo = new ServerInfo();
		
		postList = new JList<String>();
		postList.setBounds(20, 50, 300, 200);
		
		select = new JButton();
		select.setText("Select");
		select.setBounds(20, 270, 80, 30);
		
		addPost = new JButton();
		addPost.setText("Add Post");
		addPost.setBounds(120, 270, 120, 30);
		
		posts = new ArrayList<Post>();
		
		select.addActionListener(this);
		addPost.addActionListener(this);
		
		add(postList);
		add(select);
		add(addPost);
		
	}

	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource().equals(select)){
			
			int selection = postList.getSelectedIndex();
			
			if(selection == -1)return;
			
			PostViewScreen.setPost(posts.get(posts.size() - selection - 1));
			PostViewScreen.setReturnScreen(ScreenControler.SERVERSCREEN);
			frame.setScreen(ScreenControler.POSTVIEWSCREEN);
			
		}else if(e.getSource().equals(addPost)){
			
			frame.setScreen(ScreenControler.ADDPOSTSCREEN);
			
		}
		
	}

	public void addToFrame() {
		
		frame.add(this);
		
		frame.setTitle("Server View");
		
	}
	
	//function for turning a post arraylist to a string array
	public String[] getListData(ArrayList<Post> posts){
		
		//String array is initialized to the same size as the list
		String[] data = new String[posts.size()];
		
		//loop going through each element of the array
		for(int i = 0; i < posts.size(); i++){
			//each element is set to the Post's date posted
			data[i] = "Date Posted: " + posts.get(posts.size()-i-1).getDatePosted();
		}
		
		//string array is returned
		return data;
		
	}
	
	public void start() {
		
		if(posts.size() == 0){
			posts = new ArrayList<Post>(Arrays.asList(Import.importPosts()));
		}
		
		postList.setListData(getListData(posts));
		
		if(!serverContact.hasStarted())serverContact.start();
		if(!serverInfo.hasStarted())serverInfo.start();
		
	}
	
	//a static method for adding a post to the list
	public static void addPost(String question, String datePosted, String discussionDate){
		
		//post is added to the arraylist with given data, and the current list's size for an id
		posts.add(new Post(question, datePosted, discussionDate, posts.size()));
		
		//the last post in the list is saved through the export class
		Export.savePost(posts.get(posts.size()-1));
		
	}
	
	public static void addView(int postID, String student){
		
		posts.get(postID).addStudentView(student);
		Export.addView(postID, student);
		
	}
	
	public static ArrayList<Post> getPosts(){
		
		return posts;
		
	}

}
