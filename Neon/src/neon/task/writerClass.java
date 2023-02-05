package neon.task;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;


public class writerClass {

	private BufferedReader read;
	public String line;


	public void writer(String a) {
		// TODO Auto-generated method stub
		try {
//			String file = "C:\\Users\\Raghuram.m\\Desktop\\stage\\CS.csv";
//			FileWriter pw = new FileWriter()
//			String s = a;
//			FileReader fr = new FileReader()
//			pw.append(s);
//			pw.append(",");
//			pw.append("\n");
//			pw.close();
//			
			File dir = new File("C:\\Users\\Raghuram.m\\Desktop\\stage\\write.csv");
			line = "";
			FileWriter fstream = new FileWriter(dir);
			BufferedWriter out = new BufferedWriter(fstream);
			read = new BufferedReader(new FileReader(dir));
			while((read.readLine()) !=null) {
				out.write(a);
				out.newLine();
				out.close();

	 
				
			}
			
			//close buffer writer

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			System.out.println("done");
		}

	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		writerClass wr = new writerClass();
		String[] strAr = {"9008779796", "9898988", "8989899797"};  
		for (int i=0; i<strAr.length; i++)  
		{  
		System.out.println(strAr[i]);  
		wr.writer(strAr[i]);
		}  
		

	}

}
