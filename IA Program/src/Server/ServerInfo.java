package Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

import Screen.ServerScreen;

public class ServerInfo implements Runnable{

	private final int PORT = 25524;
	private Thread serverThread;
	private boolean hasStarted = false;
	
	public void run() {
		
		try {
			ServerSocket server = new ServerSocket(PORT);
			
			while(true){
				
				Socket sock = server.accept();
				
				BufferedReader input = new BufferedReader(new InputStreamReader(sock.getInputStream()));
				
				int id = Integer.parseInt(input.readLine());
				String name = input.readLine();
				
				ServerScreen.addView(id, name);
				
				input.close();
				
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
