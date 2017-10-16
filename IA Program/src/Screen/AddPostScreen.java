package Screen;

import java.awt.Dimension;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Main.Main;

public class AddPostScreen extends Screen{
	
	private JLabel infoQ, infoDP, infoDD;
	
	private JTextField question, datePosted, discussionDate;
	
	private JButton cancel, post;
	
	public AddPostScreen(Main frame) {
		super(frame);
		
		setPreferredSize(new Dimension(300,300));
		setLayout(null);
		
		infoQ = new JLabel();
		infoQ.setText("Enter Quesiton:");
		infoQ.setBounds(20, 20, 200, 30);
		
		infoDP = new JLabel();
		infoDP.setText("Enter Current Date(dd/mm/yy):");
		infoDP.setBounds(20, 80, 200, 30);
		
		infoDD = new JLabel();
		infoDD.setText("Enter Discussion Date");
		infoDD.setBounds(20, 140, 200, 30);
		
		question = new JTextField();
		question.setBounds(20, 50, 260, 30);
		
		datePosted = new JTextField();
		datePosted.setBounds(20, 110, 120, 30);
		
		discussionDate = new JTextField();
		discussionDate.setBounds(20, 170, 120, 30);
		
		cancel = new JButton();
		cancel.setText("Cancel");
		cancel.setBounds(20, 230, 120, 30);
		
		post = new JButton();
		post.setText("Add Post");
		post.setBounds(160, 230, 120, 30);
		
		cancel.addActionListener(this);
		post.addActionListener(this);
		
		add(infoQ);
		add(infoDP);
		add(infoDD);
		add(question);
		add(datePosted);
		add(discussionDate);
		add(cancel);
		add(post);
		
	}

	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource().equals(cancel)){
			frame.setScreen(ScreenControler.SERVERSCREEN);
		}else if(e.getSource().equals(post)){
			
			if(question.getText().isEmpty() || datePosted.getText().isEmpty() || discussionDate.getText().isEmpty())return;
			
			ServerScreen.addPost(question.getText(), datePosted.getText(), discussionDate.getText());

			question.setText("");
			datePosted.setText("");
			discussionDate.setText("");
			
			frame.setScreen(ScreenControler.SERVERSCREEN);
			
		}
		
	}

	public void addToFrame() {
		
		frame.add(this);
		
		frame.setTitle("Add Post");
		
	}

	public void start() {
		
	}

}
