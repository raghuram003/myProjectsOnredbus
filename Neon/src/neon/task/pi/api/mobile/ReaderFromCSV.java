package neon.task.pi.api.mobile;

import java.io.BufferedReader;
import java.io.FileReader;


public class ReaderFromCSV extends PostMethod {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			String file = "csv_data\\Enc_Mobile.csv";
			BufferedReader reader =null;
			String line ="";
	        PostMethod obj = new PostMethod();

			
			try {
				   reader = new BufferedReader(new FileReader(file));
				   while((line = reader.readLine()) != null) {			    
				    String[] row = line.split(",");
				    for(String index : row) {
				    //string concatinate process		    					    
				    String s1 ="{\r\n"
			        		+ "   \"mobile\":[\"";
			        String s2 ="\"]}";
			        String s3 = index;   
			        String str =s1 + s3 + s2;
			        obj.post(str);
			        
				    }
				   }
				  }
				  catch(Exception e) {
				   e.printStackTrace();
				  }
				  
		}
		
		}


