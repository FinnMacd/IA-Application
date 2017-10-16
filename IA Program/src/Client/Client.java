package Client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import Main.Post;
import Screen.ClientScreen;

public class Client {
	
	final int contactPort = 25525, infoPort = 25524;
	
	//method to read data from server
	public Post[] getPosts(String ip) throws Exception{
		
		//creates socket, connecting to the server
		Socket sock = new Socket(ip, contactPort);
		
		//creates a reader listening to the socket
		BufferedReader input = new BufferedReader(new InputStreamReader(sock.getInputStream()));
		
		//initializes an array of posts with the length read from the server
		Post[] posts = new Post[Integer.parseInt(input.readLine())];
		
		//loops through each post
		for(int i = 0; i < posts.length; i++){
			//initializes each post with data afrom thoe server
			posts[Integer.parseInt(input.readLine())] = new Post(input.readLine(), input.readLine(), input.readLine());
		}
		
		//closes the reader
		input.close();
		
		//closes the socket
		sock.close();
		
		//returns the array of posts read from server
		return posts;
		
	}
	
	public void sendView(String ip, int id)throws Exception{
		
		Socket sock = new Socket(ip, infoPort);
		
		PrintWriter output = new PrintWriter(sock.getOutputStream());
		
		output.println(id);
		output.println(ClientScreen.NAME);
		
		output.flush();
		
		output.close();
		
		sock.close();
		
	}
	
}
