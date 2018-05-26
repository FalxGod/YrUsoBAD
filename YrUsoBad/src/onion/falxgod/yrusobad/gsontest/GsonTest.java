package onion.falxgod.yrusobad.gsontest;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

public class GsonTest {
	public static void main(String[] args) {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		
		JsonObject root = new JsonObject();
		root.add("faction", new JsonPrimitive("barbarian"));
		root.add("type", new JsonPrimitive("falx"));
		root.add("tier", new JsonPrimitive(5));
		root.add("unit-name", new JsonPrimitive("Falxmen"));
		JsonObject stats = new JsonObject();
		stats.add("charge_impact", new JsonPrimitive(233));
		stats.add("impact_damage", new JsonPrimitive(140));
		stats.add("melee_attack", new JsonPrimitive(89));
		stats.add("melee_attack", new JsonPrimitive(142));
		stats.add("melee_weapon damage", new JsonPrimitive(58));
		stats.add("melee_weapon_penetration_damage", new JsonPrimitive(77));
		stats.add("morale_flank_damage", new JsonPrimitive(181));
		stats.add("charge_deflect", new JsonPrimitive(33));
		stats.add("missile_block_chance", new JsonPrimitive(22));
		stats.add("body_armour", new JsonPrimitive(104));
		stats.add("health", new JsonPrimitive(252));
		stats.add("morale", new JsonPrimitive(79));
		stats.add("acceleration", new JsonPrimitive(2.6));
		stats.add("decelaration", new JsonPrimitive(4.5));
		stats.add("movement_speed", new JsonPrimitive(4.4));
		stats.add("turn_speed", new JsonPrimitive(392));
		stats.add("view_range", new JsonPrimitive(181));
		root.add("stats", stats);
		
		JsonObject consumables = new JsonObject();
		JsonObject spar = new JsonObject();
		JsonObject stat = new JsonObject();
		stat.addProperty("melee_attack", 5);
		stat.addProperty("isFlat", true);
		spar.add("stat_1", stat);
			
		stat = new JsonObject();
		stat.addProperty("shield_armour", 20);
		stat.addProperty("isFlat", true);
		spar.add("stat_2", stat);
		
		root.add("consumables", consumables);
		
		
		Path p = Paths.get("data", "units");
		
		if(Files.notExists(p, LinkOption.NOFOLLOW_LINKS)) {
			try {
				Files.createDirectories(p);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			try(BufferedWriter bw = Files.newBufferedWriter(Paths.get("data", "units", "falxmen"))) {
				bw.write(gson.toJson(root));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
