package Screen;

import java.awt.Dimension;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JLabel;

import Main.Main;

public class MenuScreen extends Screen{
	
	private JButton client, server, exit;
	private JLabel instructions;
	
	public MenuScreen(Main frame){
		
		super(frame);
		
		setPreferredSize(new Dimension(320,200));
		
		setLayout(null);
		
		client = new JButton("Client");
		client.setBounds(20, 100, 80, 30);
		
		server = new JButton("Server");
		server.setBounds(120, 100, 80, 30);
		
		exit = new JButton("Exit");
		exit.setBounds(220, 100, 80, 30);
		
		instructions = new JLabel();
		instructions.setText("Choose the program mode:");
		instructions.setBounds(20, 20, 300, 40);
		
		add(client);
		add(server);
		add(exit);
		add(instructions);
		
		client.addActionListener(this);
		server.addActionListener(this);
		exit.addActionListener(this);
		
		
	}
	
	public void addToFrame() {
		
		frame.add(this);
		
		frame.setTitle("Choose Mode");
		
	}
	
	public void start(){}

	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource().equals(client)){
			
			frame.setScreen(ScreenControler.CLIENTINFOSCREEN);
			
		}else if(e.getSource().equals(server)){
			
			frame.setScreen(ScreenControler.SERVERSCREEN);
			
		}else if(e.getSource().equals(exit)){
			
			System.exit(0);
			
		}
		
	}

}
