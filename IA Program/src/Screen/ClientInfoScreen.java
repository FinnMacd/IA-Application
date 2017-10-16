package Screen;

import java.awt.Dimension;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Main.Main;

public class ClientInfoScreen extends Screen{
	
	private JLabel instructions1, instructions2;
	private JTextField name, ipAddress;
	private JButton connect;
	
	public ClientInfoScreen(Main frame) {
		super(frame);
		
		setPreferredSize(new Dimension(320,200));
		setLayout(null);
		
		instructions1 = new JLabel();
		instructions1.setText("Enter the following:");
		instructions1.setBounds(20, 20, 260, 30);
		
		instructions2 = new JLabel();
		instructions2.setText("Name    		                    IP");
		instructions2.setBounds(20, 50, 260, 30);
		
		name = new JTextField();
		name.setBounds(20, 80, 80, 30);
		
		ipAddress = new JTextField();
		ipAddress.setBounds(120, 80, 120, 30);
		
		connect = new JButton();
		connect.setText("Connect");
		connect.setBounds(20, 130, 120, 30);
		
		connect.addActionListener(this);
		
		add(instructions1);
		add(instructions2);
		add(name);
		add(ipAddress);
		add(connect);
		
	}

	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource().equals(connect)){
			if(name.getText().isEmpty() || ipAddress.getText().isEmpty())return;
			
			ClientScreen.setClientName(name.getText());
			ClientScreen.setTargetIP(ipAddress.getText());
			
			frame.setScreen(ScreenControler.CLIENTSCREEN);
			
		}
		
	}

	public void addToFrame() {
		
		frame.add(this);
		
		frame.setTitle("Enter Information");
		
	}

	public void start() {
		
	}

}
