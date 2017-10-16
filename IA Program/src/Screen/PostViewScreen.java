package Screen;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextArea;

import Main.Main;
import Main.Post;

public class PostViewScreen extends Screen{
	
	private static Post post;
	private static int returnScreen;
	
	private JButton back;
	private JLabel datePosted, discussionDate;
	private JTextArea question;
	private JList<String> studentViews;
	
	public PostViewScreen(Main frame) {
		super(frame);
		
		setPreferredSize(new Dimension(400, 300));
		setLayout(null);
		
		back = new JButton("Back");
		back.setBounds(20, 20, 80, 30);
		
		question = new JTextArea();
		question.setWrapStyleWord(true);
		question.setBounds(20, 70, 140, 90);
		question.setLineWrap(true);
		
		datePosted = new JLabel();
		datePosted.setBounds(20, 170, 260, 30);
		
		discussionDate = new JLabel();
		discussionDate.setBounds(20, 200, 260, 30);
		
		studentViews = new JList<String>();
		studentViews.setBounds(180, 20, 160, 260);
		
		back.addActionListener(this);
		
		add(back);
		add(question);
		add(datePosted);
		add(discussionDate);
		
	}

	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource().equals(back)){
			frame.setScreen(returnScreen);
		}
		
	}

	public void addToFrame() {
		
		frame.add(this);
		
		frame.setTitle("Post View");
		
	}

	public void start() {
		
		question.setText(post.getQuestion());
		datePosted.setText("Date Posted: " + post.getDatePosted());
		discussionDate.setText("Discussion date: " + post.getDiscussionDate());
		
		if(post.isServer()){
			studentViews.setListData(Arrays.asList(post.getStudentViews().toArray()).toArray(new String[post.getStudentViews().size()]));
			add(studentViews);
		}
		
	}
	
	public static void setPost(Post post){
		
		PostViewScreen.post  = post;
		
	}
	
	public static void setReturnScreen(int returnScreen){
		PostViewScreen.returnScreen = returnScreen;
	}

}
