package neon.task;

import java.io.BufferedReader;
import org.json.CDL;
import org.json.JSONException;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;
import java.util.stream.Collectors;

public class CsvFileToJsonFile {
	
	public static void main(String[] args) {
        // Read csv data file and store it in a string
        InputStream is = CsvFileToJsonFile.class.getResourceAsStream("/data.csv");
        String csv = new BufferedReader(
                new InputStreamReader(Objects.requireNonNull(is), StandardCharsets.UTF_8))
                .lines()
                .collect(Collectors.joining("\n"));

        try {
            // Convert csv text to JSON string, and save it 
            // to a data.json file.
            String json = CDL.toJSONArray(csv).toString(2);
            Files.write(Path.of("data.json"), json.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

}
