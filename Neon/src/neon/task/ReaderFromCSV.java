	package neon.task;

import java.io.BufferedReader;
import java.io.FileReader;



public class ReaderFromCSV extends PostMethod {

	public void name() {
		System.out.println("method name");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String file = "src\\write_test.csv";
		BufferedReader reader =null;
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
					PostMethod obj = new PostMethod();
					obj.post(str);   	        
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


