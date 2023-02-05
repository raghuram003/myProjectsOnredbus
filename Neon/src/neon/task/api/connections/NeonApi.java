package neon.task.api.connections;

import java.net.HttpURLConnection;
import java.net.URL;

public class NeonApi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			URL url = new URL("http://neon.omsproxy.redbus.in/v2/orders/13066888131131609");
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection.connect();
			int code = connection.getResponseCode();
			String msg = connection.getResponseMessage();
			System.out.println(msg);
			System.out.println(code);
						
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		}

	}

