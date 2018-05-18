package onion.falxgod.yrusobad.references;

public enum UnitTypes {
	FALX, SWORD, SPEAR, SWORD_CAV, SPEAR_CAV, ARCHER, SLINGER, JAVELIN, HEAVY_ARTY, SLIGHT_ARTY, ELEPHANT;
	
	@Override
	public String toString() {
		return name().toLowerCase();
	}
}
