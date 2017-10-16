package IO;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

import Main.Post;

public class Export {
	
	//function for saving posts to external files
	public static void savePost(Post post){
		
		//writer object initialized to null in case an error is caught
		Writer writer = null;
		try {
			//attempts to initialize writer to print into a file in a server folder
			writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("./server/" + post.getID()), "utf-8"));
			//prints question to file
			writer.write(post.getQuestion() + "\n");
			//prints date posted to file
			writer.write(post.getDatePosted() + "\n");
			//prints discussion date to file
			writer.write(post.getDiscussionDate() + "\n");
			
			//enhanced for loop going through all student views
			for(String string:post.getStudentViews()){
				//each name is writen to the file
				writer.write(string + "\n");
			}
			
		} catch (IOException ex) {
			//an error is caught and the stack trace is printed
			ex.printStackTrace();
		} finally {
			try {
				//lastly the writer object is closed
				writer.close();
			} catch (Exception ex) {
			}
		}
		
	}
	
	//method for appending the names of students to a file
	public static void addView(int postID, String student){
		
		//creates writer objects and initializes it to null in case the file can't be found
		Writer writer = null;
		
		try {
			//initializes writer object to append data to the file of a specific post
			writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("./server/" + postID, true), "utf-8"));
			//writes the name of the student on a new line
			writer.write(student + "\n");
			
		} catch (IOException ex) {
			//if an error is caught, stack trace is printed
			ex.printStackTrace();
		} finally {
			try {
				//lastly tries to close writer
				writer.close();
			} catch (Exception ex) {
			}
		}
		
	}
	
}
