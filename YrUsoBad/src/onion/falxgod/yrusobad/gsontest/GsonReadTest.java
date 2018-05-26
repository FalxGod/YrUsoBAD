package onion.falxgod.yrusobad.gsontest;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import onion.falxgod.yrusobad.datastruct.Enhancement;
import onion.falxgod.yrusobad.datastruct.Triplet;
import onion.falxgod.yrusobad.enhancements.EnhancementDEAD;
import onion.falxgod.yrusobad.exceptions.InvalidKeyException;
import onion.falxgod.yrusobad.references.GearTypeIdentifiers;
import onion.falxgod.yrusobad.references.RefHelper;
import onion.falxgod.yrusobad.references.StatIdentifiers;
import onion.falxgod.yrusobad.references.UnitTypes;
import onion.falxgod.yrusobad.unit.Unit;

public class GsonReadTest {
	public static void main(String[] args) throws Exception {
		Path p = Paths.get("data", "units", "falxmen");
		JsonObject rootObj = null;

		try (BufferedReader br = Files.newBufferedReader(p)) {
			JsonParser parser = new JsonParser();
			rootObj = parser.parse(br).getAsJsonObject();

		} catch (IOException e) {
			e.printStackTrace();
		}

		if (rootObj != null) {
			Unit newUnit = new Unit();

			JsonElement tmp = null;

			tmp = rootObj.get("type");
			if (tmp != null && UnitTypes.contains(tmp.getAsString())) {
				newUnit.setUnitType(UnitTypes.getFromSring(tmp.getAsString()));
			} else {
				throw new InvalidKeyException("type");
			}

			tmp = rootObj.get("unit_name");
			if (tmp != null && rootObj.get("unit_name").getAsString().length() > 0) {
				newUnit.setName(tmp.getAsString());
			} else {
				throw new InvalidKeyException("unit_name");
			}

			tmp = rootObj.get("tier");
			if (tmp != null && RefHelper.intWithinTierLimit(rootObj.get("tier").getAsInt())) {
				newUnit.setTier(tmp.getAsInt());
			} else {
				throw new InvalidKeyException("tier");
			}

			JsonObject tmpObj = rootObj.get("stats").getAsJsonObject();
			if (tmpObj != null) {
				tmpObj.entrySet().forEach(e -> {
					if (StatIdentifiers.contains(StatIdentifiers.getFromSring(e.getKey()))) {
						newUnit.addStat(StatIdentifiers.getFromSring(e.getKey()),
								e.getValue().getAsNumber().floatValue());
					}
				});
			}

			constructCGB(newUnit, rootObj, "consumables", "gear", "buffs");
			// if(tmpObj != null) {
			// for(Map.Entry<String, JsonElement> e : tmpObj.entrySet()) {
			// Enhancement consumable = new Enhancement(e.getKey());
			// for(Map.Entry<String, JsonElement> i :
			// e.getValue().getAsJsonObject().entrySet()) {
			// for(Map.Entry<String, JsonElement> s :
			// i.getValue().getAsJsonObject().entrySet()) {
			// boolean isFlat = false;
			// StatIdentifiers statID = null;
			// float value = 0f;
			//
			// if(s.getKey().equals("isFlat")) {
			// isFlat = s.getValue().getAsBoolean();
			// } else {
			// if(StatIdentifiers.contains(StatIdentifiers.getFromSring(s.getKey())))
			// {
			// statID = StatIdentifiers.getFromSring(s.getKey());
			// value = s.getValue().getAsFloat();
			// }
			// }
			//
			// if(statID != null && value != 0f) {
			// consumable.addTriplet(new Triplet(statID, value, isFlat));
			// }
			// }
			// }
			// newUnit.addConsumable(consumable);
			//
			// }
			// }
		}
	}

	public static void constructCGB(Unit unit, JsonObject entry, String... rootStr) {
		if (rootStr != null && rootStr.length > 0) {
			for (String string : Arrays.asList(rootStr)) {
				JsonElement rootCheck = entry.get(string);
				JsonObject root = null;
				if (rootCheck != null) {
					root = rootCheck.getAsJsonObject();
				}

				if (root != null) {
					for (Map.Entry<String, JsonElement> e : root.entrySet()) {
						Enhancement enhancement = new Enhancement(e.getKey());
						for (Map.Entry<String, JsonElement> i : e.getValue().getAsJsonObject().entrySet()) {
							if (string.equals("gear") && i.getKey().equals("g_type") && GearTypeIdentifiers.containsAsString(i.getValue().getAsString())) {
								enhancement.setGearType(GearTypeIdentifiers.getFromString(i.getValue().getAsString()));
							} else {
								for (Map.Entry<String, JsonElement> s : i.getValue().getAsJsonObject().entrySet()) {
									boolean isFlat = false;
									StatIdentifiers statID = null;
									float value = 0f;

									if (s.getKey().equals("isFlat")) {
										isFlat = s.getValue().getAsBoolean();
									} else {
										if (StatIdentifiers.contains(StatIdentifiers.getFromSring(s.getKey()))) {
											statID = StatIdentifiers.getFromSring(s.getKey());
											value = s.getValue().getAsFloat();
										}
									}

									if (statID != null && value != 0f) {
										enhancement.addTriplet(new Triplet(statID, value, isFlat));
									}
								}
							}
						}
						if (!string.equals("buffs")) {
							unit.addEnhancement(enhancement);
						} else {
							unit.addBuff(enhancement);
						}
					}
				}
			}
		}
	}

}
