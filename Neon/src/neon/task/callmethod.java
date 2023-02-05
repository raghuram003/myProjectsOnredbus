package neon.task;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class callmethod {

	public void demo(String a) {
		try {
			File dir = new File("C:\\Users\\Raghuram.m\\Desktop\\stage\\");
			String loc = dir.getCanonicalPath() + File.separator + "Code.txt";
	 
			FileWriter fstream = new FileWriter(loc, true);
			BufferedWriter out = new BufferedWriter(fstream);
	 
			out.write(a);
			out.newLine();
	 
			//close buffer writer
			out.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	
	public void twoString() {
		
		public static void main(String[] args) {
			String str = "Javatpointtt";
			System.out.println("Returning words:");
			String[] arr = str.split("t", 0);
			for (String w : arr) {
			System.out.println(w);
		
	}
	public void demo2(String a) {
		
		String str = a;
				//"hash,raw\n\r"
				//+ "\"394c39b43b2601086858cf665599b99d43e3d6de1a5181bf56c7c5bb\",\"jainu.barve@gmail.com\""; 
		//System.out.println(str.replace("hash,raw",""));
		//str = (str.replace("hash,raw","")).trim();
		System.out.println(str.replace("hash,raw",""));
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		callmethod call = new callmethod();
		//call.method1("394c39b43b2601086858cf665599b99d43e3d6de1a5181bf56c7c5bb");
		String[] strAr = {"hash,raw\r\n"
				+ "\"394c39b43b2601086858cf665599b99d43e3d6de1a5181bf56c7c5bb\",\"jainu.barve@gmail.com\"", "hash,raw\r\n"
						+ "\"07c6c19bf03e25fe90865160c8a0665850ad5a6930c058b45ea034d8\",\"gautamashish015@gmail.com\"", "\"52abbb0edce875d9b85c706e4e911909c3ea80c29712b9912e716e39\",\"rickyhepsi@gmail.com\"\r\n"
								+ "hash,raw"};  
		for (int i=0; i<strAr.length; i++)  
		{  
		call.demo2(strAr[i]);
		}
		
	}

}
