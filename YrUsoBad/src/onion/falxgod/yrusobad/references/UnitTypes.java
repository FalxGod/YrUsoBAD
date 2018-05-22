package onion.falxgod.yrusobad.references;

import java.util.ArrayList;
import java.util.Arrays;

public enum UnitTypes {
	FALX, SWORD, SPEAR, SWORD_CAV, SPEAR_CAV, ARCHER, SLINGER, JAVELIN, HEAVY_ARTY, SLIGHT_ARTY, ELEPHANT;
	
	@Override
	public String toString() {
		return name().toLowerCase();
	}
	
	public static boolean contains(UnitTypes unitType) {
		if(unitType != null && Arrays.asList(UnitTypes.values()).contains(unitType)) return true;
		
		return false;
	}
	public static boolean contains(String unitType) {
		if(unitType != null) {
			for(UnitTypes uT : Arrays.asList(UnitTypes.values())) {
				if(uT.toString().equals(unitType)) return true;
			}
		}
		return false;
	}
	
	public static UnitTypes getFromSring(String unitType) {
		if(unitType != null) {
			for(UnitTypes uT : Arrays.asList(UnitTypes.values())) {
				if(uT.toString().equals(unitType)) return uT;
			}
		}
		return null;
	}
}
