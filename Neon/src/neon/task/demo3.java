package neon.task;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
public class demo3 {
	public static void getKey(JSONObject json, String Key) throws JSONException {
		System.out.println(json.has(Key));
		System.out.println(json.get(Key));
		
	}
	

	public static void main(String[] args) throws JSONException  {
		String data ="{\"status\":\"SUCCESS\",\"errors\":[],\"data\":[{\"mobile\":{\"rawValue\":\"8006698521\",\"hashValue\":\"c9a66597329debdc33ce405d6dba906439b04e4863f3369f5ecfa6ab\"},\"email\":{\"rawValue\":\"rajputrah789@gmail.com\",\"hashValue\":\"a6d723376d33becd42554af9e4468d05f4cab82256731803d68c7e36\"}}]}\r\n"
				+ "";
		
		JSONObject input = new JSONObject(data);
//		System.out.println(input.get("status"));
		//getKey(input,"status");
		//System.out.println(input.get("data"));
		JSONArray nest = input.getJSONArray("data");
		//System.out.println(nest);
//		JSONObject mobile = nest.getJSONObject(0);
//		System.out.println(mobile);
//		JSONObject mobile1 = mobile.getJSONObject("mobile");
//		System.out.println(mobile1);
//		Object raw = mobile1.get("rawValue");
//		System.out.println(raw);
		Object s1 = nest.getJSONObject(0).getJSONObject("mobile").get("rawValue");
		String s3 = (String) nest.getJSONObject(0).getJSONObject("email").get("rawValue");
		String s2=",";

		//System.out.println(nest.getJSONObject(0).getJSONObject("email").get("rawValue"));
		String s= s1+s2+s3;
		System.out.println(s);

		
		
		
//		balance = balance.substring(balance.indexOf("Rp") + 2, balance.indexOf(","));
//		
//		String m1 = data.substring(indexOf("mobile\":{\"rawValue"), 0);
		

	
	}

}
