package neon.task;

import java.io.FileWriter;

import com.opencsv.CSVWriter;

public class WriteToCsV {
	
	public void writer(String a) {
		// TODO Auto-generated method stub
		try {
			
			CSVWriter pw = new CSVWriter(new FileWriter("src\\write.csv"));
			//String s = a;
			String[] row = a.split(",");
			pw.writeNext(row);
			pw.flush();
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			System.out.println("done");
		}

	}

	
	

	public static void maina(String[] args) {
		// TODO Auto-generated method stub
		WriteToCsV ob = new WriteToCsV();
		ob.writer("raghuram");
		
		

	}

}
