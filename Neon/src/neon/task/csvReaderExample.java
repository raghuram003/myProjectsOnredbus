package neon.task;

import java.io.FileReader;
import java.io.IOException;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

public class csvReaderExample {

	public static void main(String[] args) throws CsvValidationException, IOException {
		// TODO Auto-generated method stub
		CSVReader reader = new CSVReader(new FileReader("src\\example.csv"));
		String data[];
		while((data= reader.readNext()) != null) {
			for (String index : data) {
				System.out.printf("%s\t", index);
				
			}
		    System.out.println();

			
		}
		
		

	}

}
