package onion.falxgod.yrusobad.datastruct;

import onion.falxgod.yrusobad.references.StatIdentifiers;

public class Triplet {
	private StatIdentifiers statID;
	private float value;
	private boolean isFlat;
	
	public Triplet(StatIdentifiers statID, float value, boolean isFlat) {
		this.statID = statID;
		this.value = value;
		this.isFlat = isFlat;
	}

	public StatIdentifiers getStatID() {
		return statID;
	}

	public float getValue() {
		return value;
	}

	public boolean isFlat() {
		return isFlat;
	}
	
	
}
