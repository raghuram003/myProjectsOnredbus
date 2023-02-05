package neon.task.pi.api.email;

import java.io.BufferedReader;
import java.io.FileReader;


public class ReaderFromCSV extends PostMethod {
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			//ReaderFromCSV write = new ReaderFromCSV();
			String file = "src\\emailids2.csv";
			BufferedReader reader =null;
	        PostMethod obj = new PostMethod();

			String line ="";
			
			try {
				   reader = new BufferedReader(new FileReader(file));
				   while((line = reader.readLine()) != null) {			    
				    String[] row = line.split(",");
				    for(String index : row) {
				    		    					    
				    String s1 ="{\r\n"
			        		+ "   \"email\":[\"";
			        String s2 ="\"]}";
			        String s3 = index;   
			        String str =s1 + s3 + s2;
			        //System.out.println(str);
			        obj.post(str);
			        
				    }
				    //System.out.println();
				   }
				  }
				  catch(Exception e) {
				   e.printStackTrace();
				  }
				  
		}
		
		}


