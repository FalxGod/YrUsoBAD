package onion.falxgod.yrusobad.references;

import java.util.Arrays;

public enum GearTypeIdentifiers {
	HELMET,
	LEGS,
	CHEST,
	SHIELD,
	WEAPON,
	//ELE
	ELE_ARMOUR,
	HOWDAH,
	//LIGHT and HEAVY ARTY
	CRANK,
	DIOPTRA,
	FRAME,
	JOIN,
	TOOLKIT;
	
	@Override
	public String toString() {
		return name().toLowerCase();
	}
	
	public static GearTypeIdentifiers getFromString(String gtype) {
		for(GearTypeIdentifiers gt : Arrays.asList(GearTypeIdentifiers.values())) {
			if(gt.toString().equals(gtype)) {
				return gt;
			}
		}
		return null;
	}
	
	public static boolean containsAsString(String gtype) {
		for(GearTypeIdentifiers gt : Arrays.asList(GearTypeIdentifiers.values())) {
			if(gt.toString().equals(gtype)) {
				return true;
			}
		}
		return false;
	}
	
	
}
