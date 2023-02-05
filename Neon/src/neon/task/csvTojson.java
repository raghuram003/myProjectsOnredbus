package neon.task;

import java.io.BufferedReader;
import java.io.FileReader;

public class csvTojson {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String file = "src\\example.csv";
		BufferedReader reader =null;
		String line ="";

		try {
			reader = new BufferedReader(new FileReader(file));
			while((line = reader.readLine()) != null) {			    
				String[] row = line.split(",");
				for(String index : row) {

					System.out.println(index);	        
				}
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			System.out.println();
			System.out.println("****************done***************");
		}
		

	}

}
