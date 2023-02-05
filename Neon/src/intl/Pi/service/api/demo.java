package intl.Pi.service.api;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			URL url = new URL("http://eupiservice.redbus.com/v1/users/pi-mapping/bulk/fetch?type=hash&batch=1");
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("POST");
			connection.setRequestProperty("Content-type", "application/json");
			connection.setRequestProperty("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhcGlfa2V5Ijoic29tZXRoaW5nIiwicm9sZXMiOlsiUkVBRF9CVUxLX1BJX0hBU0giXX0.0WvoAz9M-TOmIpOTUiZpdBrmatimSBhjDy3gFVZb1uc");
			connection.setDoOutput(true);
			
			
			String josnBody= "[\r\n"
					+ "{\"mobile\":\"34e86d692ec56c10bd9d1b0bebffe79df8d0fbaf98919b14a25be68b\",\"email\":\"794a4bf14dc0362b43f045eba57a93d55a612e70c78f83d77688097f\"}\r\n"
					+ "]\r\n"
					+ "";
			byte[] inputjson = josnBody.getBytes();
			System.out.println(inputjson);
			OutputStream outputstream = connection.getOutputStream();
			outputstream.write(inputjson);
			

	}
		catch(Exception e) {
		e.printStackTrace();	
		}
		}

}
