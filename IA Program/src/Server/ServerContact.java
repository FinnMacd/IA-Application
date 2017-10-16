package Server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import Main.Post;
import Screen.ServerScreen;

public class ServerContact implements Runnable{
	
	private final int PORT = 25525;
	private Thread serverThread;
	private boolean hasStarted = false;
	
	public void run() {
		
		try {
			
			//creates a server and listens to port 25525
			ServerSocket server = new ServerSocket(PORT);
			
			//creates an endless loop, so it will always be open to connection
			while(true){
				
				//the program waits on this line until a connection with a client application is made
				Socket sock = server.accept();
				
				//a printwriter is created to send information to the server
				PrintWriter output = new PrintWriter(sock.getOutputStream());
				
				//the number of posts on the list is printed
				output.println(ServerScreen.getPosts().size());
				
				//an enhanced loop going through each post
				for(Post post: ServerScreen.getPosts()){
					
					//prints each post's ID, question, date posted, and discussion date
					output.println(post.getID());
					output.println(post.getQuestion());
					output.println(post.getDatePosted());
					output.println(post.getDiscussionDate());
					
				}
				
				//flushes all data to the client
				output.flush();
				
				//closes the writer
				output.close();
				
				//closes the socket
				sock.close();
				
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void start(){
		
		serverThread = new Thread(this);
		serverThread.start();
		hasStarted = true;
		
	}
	
	public boolean hasStarted(){
		return hasStarted;
	}
	
}
