package neon.task;

import java.io.File;
import java.util.Scanner;

import org.json.JSONObject;

public class csvTOjson2 {
	
	public static void main(String[] args) throws Exception  
	{  
	//parsing a CSV file into Scanner class constructor  
	Scanner sc = new Scanner(new File("src\\example.csv"));  
	sc.useDelimiter("");   //sets the delimiter pattern  
	while (sc.hasNext())  //returns a boolean value  
	{ 
		String str = sc.next();
		//System.out.println(jb.put("email", sc.next()));
	System.out.print(str);  //find and returns the next complete token from this scanner  
	}   
	sc.close();  //closes the scanner  
	}  

}
