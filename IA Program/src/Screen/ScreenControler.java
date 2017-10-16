package Screen;

import Main.Main;

//class for controlling the screen currently displayed
public class ScreenControler {
	
	//array containing all screens displayed in the program
	private Screen[] screens;
	
	//the indices of all types of screens
	public static int MENUSCREEN = 0, CLIENTINFOSCREEN = 1, CLIENTSCREEN = 2, 
			POSTVIEWSCREEN = 3, SERVERSCREEN = 4, ADDPOSTSCREEN = 5;
	
	//integer holding the current screen
	public int currentScreen = -1;
	
	//conctructor for ScreenControler
	public ScreenControler(Main frame){
		
		//initializes the screen array and adds each different screen as an element
		screens = new Screen[]{new MenuScreen(frame), new ClientInfoScreen(frame), 
				new ClientScreen(frame), new PostViewScreen(frame), new ServerScreen(frame), new AddPostScreen(frame)};
		
	}
	
	//method to change the current screen
	public void setScreen(int screen){
		
		currentScreen = screen;
		
	}
	
	//function returning the current screen
	public Screen getCurrentScreen(){
		
		return screens[currentScreen];
		
	}
	
}



