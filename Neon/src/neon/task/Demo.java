package neon.task;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Demo {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String file = "src\\rail_csv.csv";
		BufferedReader reader =null;
		String line ="";
		
		try {
			   reader = new BufferedReader(new FileReader(file));
			   while((line = reader.readLine()) != null) {			    
			    String[] row = line.split(",");
			    for(String index : row) {
			    		    	
			    System.out.printf("%s\t", index);
			    String str ="{\r\n"
			    		+ "   \"mobile\":[\"6158f1a900c66bd429dc294d0e3102be501de2917ef2dc5e9f366a43\"]}";
			     
			    }
			    System.out.println();
			   }
			  }
			  catch(Exception e) {
			   e.printStackTrace();
			  }
			  finally {
		
			    reader.close();

	}
	}
}


