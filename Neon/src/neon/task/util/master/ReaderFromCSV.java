package neon.task.util.master;

import java.io.BufferedReader;
import java.io.FileReader;



public class ReaderFromCSV extends ApiProcessWriteTocsv {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String file = "C:\\Users\\Raghuram.m\\Desktop\\stage\\Mobile_unique.csv";
		BufferedReader reader =null;
		String line ="";

		try {
			reader = new BufferedReader(new FileReader(file));
			while((line = reader.readLine()) != null) {			    
				String[] row = line.split(",");
				for(String index : row) {

					String s1 ="{\r\n"
							+ "   \"mobile\":[\"";
					String s2 ="\"]}";
					String s3 = index;   
					String str =s1 + s3 + s2;
					ApiProcessWriteTocsv obj = new ApiProcessWriteTocsv();
					obj.PostandWrite(str);   	        
				}
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			System.out.println("****************process is done***************");
			System.out.println("The has file created path-->C:\\Users\\Raghuram.m\\Desktop\\stage\\");
		}
		

	}

}


