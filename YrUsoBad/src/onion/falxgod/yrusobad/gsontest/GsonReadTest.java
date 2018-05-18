package onion.falxgod.yrusobad.gsontest;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import onion.falxgod.yrusobad.references.UnitTypes;

public class GsonReadTest {
	public static void main(String[] args) throws Exception {
		Path p = Paths.get("data", "units" , "falxmen");
		JsonObject rootObj = null;
		
		try(BufferedReader br = Files.newBufferedReader(p)) {
			JsonParser parser = new JsonParser();
			rootObj = parser.parse(br).getAsJsonObject();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		if(rootObj != null) {
			for(UnitTypes uT : Arrays.asList(UnitTypes.values())) {
				if(rootObj.get(uT.toString()) == null) {
					
				}
			}
		}
	}
	
	
}
