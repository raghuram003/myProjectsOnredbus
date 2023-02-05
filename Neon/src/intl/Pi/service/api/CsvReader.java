package intl.Pi.service.api;

import java.io.File;
import java.util.Scanner;

public class CsvReader extends ApiProcess{
	public static void main(String[] args) {
		ApiProcess sendJson = new ApiProcess();
		try {
			
			{  
				//parsing a CSV file into Scanner class constructor  
				Scanner sc = new Scanner(new File("C:\\Users\\Raghuram.m\\Desktop\\neon\\read\\MY_HASH4.csv"));  
				while (sc.hasNext())  //returns a boolean value  
				{ 

					String jsonRequest = null;
					String Str = sc.next();
					String s1 = "[\r\n"
							+ "    {\"mobile\":\"";
					String s2 ="\",\"email\":\"";
					String s3 ="\"\r\n"
							+ "}\r\n"
							+ "]\r\n"
							+ "";

					String[] arr = Str.split("," , 0);
//					for(int i =0 ;i<arr.length;i++) {
//						jsonRequest = s1 + arr[0] + s2 + arr[1] + s3 ;
//						
//
//
//					}
					jsonRequest = s1 + arr[0] + s2 + arr[1] + s3 ;
				//	System.out.println(jsonRequest);
					sendJson.post(jsonRequest);


				}
			}

			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			System.out.println("********************done*************************");
		}

	}



}
