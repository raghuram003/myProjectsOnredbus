package neon.task;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class demo4 {
	public static void main(String args[]) throws JSONException {
	      String jsonDataString = "{\"status\":\"SUCCESS\",\"errors\":[],\"data\":[{\"mobile\":{\"rawValue\":\"9841815249\",\"hashValue\":\"a494ea62983955081b732c44b5b6a3a09eb6de38edbd28ef483eafd9\"},\"email\":{\"rawValue\":\"siva.belukurichi@gmail.com\",\"hashValue\":\"ac1207a121dfeda4dda43dc344a1b77e3e68c2eb06e920e3cf5c81b4\"}}]}\r\n"
	      		+ "";
	      JSONObject jsonObject = new JSONObject(jsonDataString);
//	      List<String> list = new ArrayList<String>();
//	      JSONArray jsonArray = jsonObject.getJSONArray("data");
//	      for(int i = 0 ; i < jsonArray.length(); i++) {
//	         list.add(jsonArray.getJSONObject(i).getString("rawValue"));
//	         System.out.println(jsonArray.getJSONObject(i).getString("rawValue")); // display usernames
	      
//	      }
	      JSONObject getsh = jsonObject.getJSONObject("status");
	    //  Object mobile =getsh.get("errors");
	      System.out.println(getsh);
	      
	      
	   }

}
