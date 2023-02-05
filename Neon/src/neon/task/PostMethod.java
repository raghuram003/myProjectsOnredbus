package neon.task;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;




public class PostMethod  {

	BufferedReader reader;
	String line;
	String responseContent = new String();
	String[] arr;
	String n;
	
	public void post(String a) {	


		try {
			URL url = new URL("http://api.piservice.neon.redbus.com/v1/users/pi-mapping/bulk/stream?type=hash&piType=email&batch=1");
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("POST");
			connection.setRequestProperty("Content-type", "application/json");
			connection.setRequestProperty("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhcGlfa2V5Ijoic29tZXRoaW5nIiwicm9sZXMiOlsiUkVBRF9CVUxLX1BJX0hBU0giXX0.0WvoAz9M-TOmIpOTUiZpdBrmatimSBhjDy3gFVZb1uc");
			connection.setDoOutput(true);
			
			String josnBody= a;
			byte[] inputjson = josnBody.getBytes();
			OutputStream outputstream = connection.getOutputStream();
			outputstream.write(inputjson);
			reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			while ((line = reader.readLine())!= null) {
				line=line.replace("hash,raw","").trim();
				//System.out.print(line.replace("hash,raw",""));
				try {
					File dir = new File("C:\\Users\\Raghuram.m\\Desktop\\stage\\");
					String loc = dir.getCanonicalPath() + File.separator + "a.csv";
			 
					FileWriter fstream = new FileWriter(loc, true);
					BufferedWriter out = new BufferedWriter(fstream);
			 
					out.write(line);
					out.newLine();
			 
					//close buffer writer
					out.close();
					
				} catch (Exception e) {
					// TODO: handle exception
				}
				
		

			}


		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub



	}



}
