package neon.task.pi.api.email;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;



public class PostMethod {

	BufferedReader reader;
	String line;
	String responseContent = new String();
	
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
			
			//int code = connection.getResponseCode();
			//String msg = connection.getResponseMessage();
			
			//System.out.println(code);
			//System.out.println(msg);
			//System.out.println(connection.getContent());
			reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			while ((line = reader.readLine())!= null) {
				System.out.print(line.replace("hash,raw", ""));
				System.out.println();
			//	System.out.println();
				//responseContent = line;
				//responseContent.append(line);
//				//System.out.println(str);
			
//				
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
