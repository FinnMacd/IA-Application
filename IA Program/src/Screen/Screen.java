package Screen;

import java.awt.event.ActionListener;

import javax.swing.JPanel;

import Main.Main;

//an abstract class used to create screens displayed in the frame
public abstract class Screen extends JPanel implements ActionListener{
	
	//main object used to change screens
	protected Main frame;
	
	//Screen constructor to initialize Main object
	public Screen(Main frame){
		
		this.frame = frame;
		
	}
	
	//an abstract function to add a JPanel to the frame, and set frame title
	public abstract void addToFrame();
	
	//an abstract function called when the screen is added to frame
	public abstract void start();
	
	//function called when screen is being removed from frame
	public void end(){
		frame.remove(this);
	}
}


