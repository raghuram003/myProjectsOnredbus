package neon.task.util.mobile.email;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;

public class ApiProcessAndWriteTocsv {
	
	BufferedReader reader;
	String line;
	String responseContent = new String();
	String[] arr;
	String n;
	int count =1;
	
	public void post(String a) {	


		try {
			URL url = new URL("http://api.piservice.neon.redbus.com/v1/users/pi-mapping/bulk/fetch?type=hash&batch=1");
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
				JSONObject input = new JSONObject(line);
				JSONArray nest = input.getJSONArray("data");
				String s1 = (String) nest.getJSONObject(0).getJSONObject("mobile").get("rawValue");
				String s3 = (String) nest.getJSONObject(0).getJSONObject("email").get("rawValue");
				String s2=",";
				line = s1+s2+s3;
				//System.out.println(line);
	
				try {
					File dir = new File("C:\\Users\\Raghuram.m\\Desktop\\neon");
					String loc = dir.getCanonicalPath() + File.separator + "rail_ME.csv";			 
					try (FileWriter fstream = new FileWriter(loc, true)) {
						while(count==1) {
						fstream.append("Mobile,Email");
						fstream.append("\n");
						count ++;
						}
						
						fstream.write(line);
						fstream.write("\n");
					}
			 
					//close buffer writer
					
				} catch (Exception e) {
					// TODO: handle exception
				}
			}


		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}
}
