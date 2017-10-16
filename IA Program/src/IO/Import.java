package IO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import Main.Post;

public class Import {
	
	public static Post[] importPosts(){
		
		//the directory of any pre-existing files initialized to a file
		File directory = new File("./server/");
		
		//an array of all files in the directory initialized from the directory
		File[] files = directory.listFiles();
		
		if(!directory.exists() || directory.list().equals(null)){
			directory.mkdir();
			return new Post[0];
		}
		
		//a post array for loading posts into
		Post[] posts = new Post[files.length];
		
		//enhanced for loop going through all files
		for(File file: files){
			
			//new reader object created and initialized to null in the case an error is caught
			BufferedReader reader = null;
			
			try{
				//reader is initialized to the current file
				reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
				//post id is ascertained from file
				int id = Integer.parseInt(file.getName());
				//new post is created in the array of posts with data from file
				posts[id] = new Post(reader.readLine(),reader.readLine(),reader.readLine(),Integer.parseInt(file.getName()));
				
				//string holding names of any potential students
				String next = reader.readLine();
				
				//while the file has another line it loads data into the post
				while(next != null){
					//adds students name to the post
					posts[id].addStudentView(next);
					//reads next line
					next = reader.readLine();
				}
				
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
				
		}
		
		return posts;
		
	}
	
}
