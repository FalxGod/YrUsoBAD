package onion.falxgod.yrusobad.references;

public class RefHelper {
	public static boolean intWithinTierLimit(int tier) {
		if(tier < 1 || tier > 10) return false;
		return true;
	}
}
