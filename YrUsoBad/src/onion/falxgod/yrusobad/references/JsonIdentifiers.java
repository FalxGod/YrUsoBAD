package onion.falxgod.yrusobad.references;

public enum JsonIdentifiers {
	TYPE,
	UNIT_NAME,
	TIER,
	STATS,
	CONSUMABLES,
	GEAR,
	BUFFS,
	ISFLAT;
	
	
	@Override
	public String toString() {
		return name().toLowerCase();
	}

}
