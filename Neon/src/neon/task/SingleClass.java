package neon.task;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class SingleClass {


	public static void main(String[] args) {
		BufferedReader reader;
		String line;
		String responseContent = new String();
		String[] arr;
		String n;
		String file = "src\\write_test.csv";
		BufferedReader reader1 =null;
		String line1 ="";


		// TODO Auto-generated method stub
		try {
			URL url = new URL("http://api.piservice.neon.redbus.com/v1/users/pi-mapping/bulk/stream?type=hash&piType=email&batch=1");
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("POST");
			connection.setRequestProperty("Content-type", "application/json");
			connection.setRequestProperty("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhcGlfa2V5Ijoic29tZXRoaW5nIiwicm9sZXMiOlsiUkVBRF9CVUxLX1BJX0hBU0giXX0.0WvoAz9M-TOmIpOTUiZpdBrmatimSBhjDy3gFVZb1uc");
			connection.setDoOutput(true);
			reader1 = new BufferedReader(new FileReader(file));
			while((line1 = reader1.readLine()) != null) {			    
				String[] row = line1.split(",");
				for(String index : row) {

					String s1 ="{\r\n"
							+ "   \"email\":[\"";
					String s2 ="\"]}";
					String s3 = index;   
					String str =s1 + s3 + s2;


					String josnBody= str;
					byte[] inputjson = josnBody.getBytes();
					OutputStream outputstream = connection.getOutputStream();
					outputstream.write(inputjson);
					reader1 = new BufferedReader(new InputStreamReader(connection.getInputStream()));
					while ((line1 = reader1.readLine())!= null) {
						line1=line1.replace("hash,raw","").trim();
						System.out.println(line1.toCharArray());
						//System.out.print(line.replace("hash,raw",""));
							File dir = new File("C:\\Users\\Raghuram.m\\Desktop\\stage\\");
							String loc = dir.getCanonicalPath() + File.separator + "d.csv";

							FileWriter fstream = new FileWriter(loc, true);
							BufferedWriter out = new BufferedWriter(fstream);

							out.write(n);
							out.newLine();

							//close buffer writer
							out.close();
							
					}
				}
			}
		}


