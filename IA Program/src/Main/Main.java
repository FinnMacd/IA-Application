package Main;

import javax.swing.JFrame;

import Screen.ScreenControler;

public class Main extends JFrame{
	
	private ScreenControler controler;
	
	public static void main(String[] args){
		
		new Main();
		
	}
	
	public Main(){
		
		controler = new ScreenControler(this);
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setScreen(ScreenControler.MENUSCREEN);
		
		setVisible(true);
		
		setLocationRelativeTo(null);
		
	}
	
	//method for changing the current screen on display
	public void setScreen(int screen){
		
		//if there is currently a screen displayed, its end method is called
		if(controler.currentScreen != -1)controler.getCurrentScreen().end();
		
		//the screen controller's current screen is changed
		controler.setScreen(screen);
		
		//the new screen is added to the frame
		controler.getCurrentScreen().addToFrame();
		
		//the frame is packed
		pack();
		
		//the current screens start method is called
		controler.getCurrentScreen().start();
		
	}
	
}
