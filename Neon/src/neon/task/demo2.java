package neon.task;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class demo2 {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		{  
			//parsing a CSV file into Scanner class constructor  
			Scanner sc = new Scanner(new File("src\\example.csv"));  
			while (sc.hasNext())  //returns a boolean value  
			{ 
				
		String jsonRequest;
		String Str = sc.next();
		String s1 = "[\r\n"
				+ "    {\"mobile\":\"";
		String s2 ="\",\"email\":\"";
		String s3 ="\"\r\n"
				+ "}\r\n"
				+ "]\r\n"
				+ "";
		
			System.out.println("Returning words:");
			String[] arr = Str.split("," , 0);
			for(int i =0 ;i<arr.length;i++) {
				jsonRequest = s1 + arr[0] + s2 + arr[1] + s3 ;
				System.out.println(jsonRequest);
				
				
			}
			}
		}
			
			
	}

}

