package Screen;

import java.awt.Dimension;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;

import Client.Client;
import Main.Main;
import Main.Post;

public class ClientScreen extends Screen{
	
	public static String NAME, IPTARGET;
	
	private JLabel instructions;
	private JList<String> postList;
	private JButton refresh, select;
	private Post[] posts;
	
	private Client client;
	
	public ClientScreen(Main frame) {
		super(frame);
		
		setPreferredSize(new Dimension(340,320));
		setLayout(null);
		
		client = new Client();
		
		postList = new JList<String>();
		postList.setBounds(20, 50, 300, 200);
		
		instructions = new JLabel();
		instructions.setText("Select a post to view more details:");
		instructions.setBounds(20, 20, 300, 20);
		
		refresh = new JButton();
		refresh.setText("Refresh");
		refresh.setBounds(20, 270, 80, 30);
		
		select = new JButton();
		select.setText("Select");
		select.setBounds(120, 270, 80, 30);
		
		refresh.addActionListener(this);
		select.addActionListener(this);
		
		add(postList);
		add(instructions);
		add(refresh);
		add(select);
		
		
	}

	public void addToFrame() {

		frame.add(this);
		
		frame.setTitle("Student View");
		
	}
	
	public void start(){
		
		if(posts == null)connectToServer();
		
	}
	
	public void connectToServer(){
		
		posts = new Post[0];
		try {
			posts = client.getPosts(IPTARGET);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		postList.setListData(getListData(posts));
		
	}
	
	public String[] getListData(Post[] posts){
		
		String[] data = new String[posts.length];
		
		for(int i = 0; i < data.length; i++){
			data[i] = "Date Posted: " + posts[data.length - i - 1].getDatePosted();
		}
		
		return data;
		
	}
	
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource().equals(refresh)){
			connectToServer();
		}else if(e.getSource().equals(select)){
			
			int selection = postList.getSelectedIndex();
			
			if(selection == -1)return;
			
			try {
				client.sendView(IPTARGET, posts.length - selection - 1);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			
			PostViewScreen.setPost(posts[posts.length - selection - 1]);
			PostViewScreen.setReturnScreen(ScreenControler.CLIENTSCREEN);
			frame.setScreen(ScreenControler.POSTVIEWSCREEN);
			
		}
		
	}
	
	public static void setClientName(String name){
		ClientScreen.NAME = name;
	}
	
	public static void setTargetIP(String ip){
		ClientScreen.IPTARGET = ip;
	}
	
}
